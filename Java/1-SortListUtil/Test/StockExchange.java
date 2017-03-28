package com.ouc.cs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StockExchange {

	private static int CODE = 0;

	public static void main(String[] args) {
		//Scanner cin = new Scanner(System.in);
		// args[0]: input filename
		//String inputFileName = cin.nextLine();
		// args[1]: output filename
		//String outputFileName = cin.nextLine();
		//cin.close();

		// args[0]: input filename
		String inputFileName = args[0];
		// args[1]: output filename
		String outputFileName = args[1];

		OfferFile offerFile = new OfferFile(inputFileName);
		offerFile.setInputFileName(inputFileName);
		offerFile.setOutputFileName(outputFileName);

		List<Offer> offerList = new ArrayList<Offer>();

		StringBuilder result = new StringBuilder();

		// 读 input
		try {
			FileReader reader = new FileReader(offerFile.getInputFileName());
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			str = br.readLine();
			while (str != null) { // 使用readLine方法，一次读一行
				if (!str.trim().equals("")) { // 忽略空行
					String[] array = str.split(" "); // 文本里面以空格隔开了每个数据

					if(array.length != 4) {
						System.out.println("Invalid input file!");
					}
					
					Offer offer = new Offer();
					// 出价ID
					try {
						if(Long.parseLong(array[0]) >= 0) {
							offer.setOfferId(Long.parseLong(array[0]));  
						} else {
							System.out.println("Invalid id (negative number) - Invalid input file!");
						}
					} catch (Exception e) {
						System.out.println("Invalid id (not number) - Invalid input file!");
						CODE = 2;
					}

					// 出价时间
					try {
						if(Long.parseLong(array[1]) >= 0) {
							offer.setTimeStamp(Long.parseLong(array[1])); 
						} else {
							System.out.println("Invalid timestamp (negative number) - Invalid input file!");
						}
					} catch (Exception e) {
						System.out.println("Invalid timestamp (not num) - Invalid input file!");
						CODE = 2;
					}

					// 出价的行为，B=BUY，S=SELL
					try {
						if (array[2].charAt(0) == 'B' || array[2].charAt(0) == 'S') {
							offer.setBehavior(array[2].charAt(0));
						} else if('0' <= array[2].charAt(0) && array[2].charAt(0) <= '9') {
							System.out.println("Invalid offer type (number) - Invalid input file!");
						} else {
							System.out.println("Invalid offer type (wrong case) - Invalid input file!");
						}
					} catch (Exception e) {
						System.out.println("Invalid offer type - Invalid input file!");
						CODE = 2;
					}
					
					// 出价极限额
					try {
						if(Integer.parseInt(array[3]) >= 0) {
							offer.setLimitPrice(Integer.parseInt(array[3])); 
						} else {
							System.out.println("Invalid price (negative) - Invalid input file!");
						}
					} catch (Exception e) {
						System.out.println("Invalid price (not number) - Invalid input file!");
						CODE = 2;
					}
					
					offerList.add(offer);

					// result.append(offer.toString() + System.lineSeparator());
				}
				str = br.readLine();
			}

			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Not found input file!");
			CODE = 1;
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Cannot read input file!");
			CODE = 1;
			e.printStackTrace();
		}

		// 进行交易，如果没有可以执行的交易即写出一个空的文本
		// System.out.println("Offer数量：" + offerList.size());
		offerFile.setOfferList(offerList);

		Exchange exchange = new Exchange();
		List<Offer> buyOfferList = new ArrayList<Offer>(); // 待买入 Offer
		List<Offer> sellOfferList = new ArrayList<Offer>(); // 待卖出 Offer

		for (int i = 0; i < offerFile.getOfferList().size(); i++) {
			if (offerFile.getOfferList().get(i).getBhavior() == 'B') {
				buyOfferList.add(offerFile.getOfferList().get(i));
			} else {
				sellOfferList.add(offerFile.getOfferList().get(i));
			}
		}

		//Collections.sort(buyOfferList, Collections.reverseOrder());
		Collections.sort(buyOfferList);
		Collections.sort(sellOfferList);

		/*
		 * SortListUtil<Offer> sortedBuyOfferList = new SortListUtil<Offer>();  // 已排序的待买入Offer 
		 * SortListUtil<Offer> sortedSellOfferList = new SortListUtil<Offer>(); // 已排序的待卖出Offer
		 * sortedBuyOfferList.sortByMethod(buyOfferList, "getTimeStamp", false);
		 * sortedBuyOfferList.sortByMethod(buyOfferList, "getLimitPrice", true);
		 * 
		 * sortedSellOfferList.sortByMethod(sellOfferList, "getTimeStamp", false); 
		 * sortedSellOfferList.sortByMethod(sellOfferList, "getLimitPrice", false); 
		 * System.out.println(buyOfferList);
		 * System.out.println(sellOfferList);
		 */

		exchange.setBuyOfferList(buyOfferList);
		exchange.setSellOfferList(sellOfferList);

		int buyNum = exchange.getBuyOfferList().size();
		int sellNum = exchange.getSellOfferList().size();

		if (buyNum != 0 && sellNum != 0) {
			int tradeNum = 0;
			int buyIndex = 0; // 当前处理的待买入 Offer索引
			int sellIndex = 0; // 当前处理的待卖出 Offer索引

			while (buyIndex < buyNum && sellIndex < sellNum) {
				 if (exchange.getBuyOfferList().get(buyIndex).getTimeStamp() <= 
							exchange.getSellOfferList().get(sellIndex).getTimeStamp()) {
						if (exchange.getBuyOfferList().get(buyIndex).getLimitPrice() >= 
								exchange.getSellOfferList().get(sellIndex).getLimitPrice()) {
							Trade trade = new Trade();
							trade.setBuyOfferId(exchange.getBuyOfferList().get(buyIndex).getOfferId());
							trade.setSellOfferId(exchange.getSellOfferList().get(sellIndex).getOfferId());
							trade.setPrice(exchange.getBuyOfferList().get(buyIndex).getLimitPrice());

							if (tradeNum == 0) {
								result.append(trade.toString()); // 首行无需添加换行符'\n'
							} else {
								result.append(System.lineSeparator() + trade.toString()); // 添加换行符'\n'换行
							}

							tradeNum++;
							
							sellIndex++;
						} 
					    buyIndex++;
					} else {
						if (exchange.getSellOfferList().get(sellIndex).getLimitPrice() <= 
								exchange.getBuyOfferList().get(buyIndex).getLimitPrice()) {
							Trade trade = new Trade();
							trade.setBuyOfferId(exchange.getBuyOfferList().get(buyIndex).getOfferId());
							trade.setSellOfferId(exchange.getSellOfferList().get(sellIndex).getOfferId());
							trade.setPrice(exchange.getSellOfferList().get(sellIndex).getLimitPrice());

							if (tradeNum == 0) {
								result.append(trade.toString()); // 首行无需添加换行符'\n'
							} else {
								result.append(System.lineSeparator() + trade.toString()); // 添加换行符'\n'换行
							}

							tradeNum++;

							buyIndex++;
						} 
						sellIndex++;
					}
			}
		}

		// 写output Trade里的数据
		try {
			FileWriter writer = new FileWriter(offerFile.getOutputFileName());
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(result.toString());

			bw.close();
			writer.close();
		} catch (Exception e) {
			System.out.println("Cannot write output file!");
			CODE = 1;
			e.printStackTrace();
		}
	}
}

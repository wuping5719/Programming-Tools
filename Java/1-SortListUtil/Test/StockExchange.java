package com.ouc.cs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StockExchange {

	private static int CODE = 0;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		// args[0]: input filename
		String inputFileName = cin.nextLine();
		// args[1]: output filename
		String outputFileName = cin.nextLine();
		cin.close();

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
				String[] array = str.split(" "); // 文本里面以空格隔开了每个数据

				Offer offer = new Offer();
				try {
					offer.setOfferId(Long.parseLong(array[0])); // 出价ID
					offer.setTimeStamp(Long.parseLong(array[1])); // 出价时间
					offer.setBehavior(array[2].charAt(0)); // 出价的行为，B=BUY，S=SELL
					offer.setLimitPrice(Integer.parseInt(array[3])); // 出价极限额
				} catch (Exception e) {
					System.out.println("Invalid input file!");
					CODE = 2;
				}

				offerList.add(offer);
				
				//result.append(offer.toString() + System.lineSeparator());
				
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
		System.out.println("Offer数量：" + offerList.size());
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
		
		// Collections.sort(buyOfferList, Collections.reverseOrder());
		// Collections.sort(sellOfferList); 

		SortListUtil<Offer> sortedBuyOfferList = new SortListUtil<Offer>(); // 已排序的待买入Offer
		SortListUtil<Offer> sortedSellOfferList = new SortListUtil<Offer>(); // 已排序的待卖出Offer
		sortedBuyOfferList.sortByMethod(buyOfferList, "getTimeStamp", false);
		sortedBuyOfferList.sortByMethod(buyOfferList, "getLimitPrice", true);

		sortedSellOfferList.sortByMethod(sellOfferList, "getTimeStamp", false);
		sortedSellOfferList.sortByMethod(sellOfferList, "getLimitPrice", false);
		System.out.println(buyOfferList);
		System.out.println(sellOfferList);

		exchange.setBuyOfferList(buyOfferList);
		exchange.setSellOfferList(sellOfferList);

		int buyNum = exchange.getBuyOfferList().size();
		int sellNum = exchange.getSellOfferList().size();
		if (buyNum != 0 && sellNum != 0) {
			if(buyNum - sellNum == 0) {
				int index = 0;
				while(index < sellNum) {
					Trade trade = new Trade();
					trade.setBuyOfferId(exchange.getBuyOfferList().get(index).getOfferId());
					trade.setSellOfferId(exchange.getSellOfferList().get(index).getOfferId());
					trade.setPrice(exchange.getBuyOfferList().get(index).getLimitPrice());
					
					result.append(trade.toString() + System.lineSeparator());
					index++;
				}
			}else if(buyNum - sellNum >= 0) {
				int index = 0;
				while(index < sellNum) {
					Trade trade = new Trade();
					trade.setBuyOfferId(exchange.getBuyOfferList().get(index).getOfferId());
					trade.setSellOfferId(exchange.getSellOfferList().get(index).getOfferId());
					if(exchange.getBuyOfferList().get(index).getLimitPrice() 
							>= exchange.getSellOfferList().get(index).getLimitPrice()) {
						trade.setPrice(exchange.getSellOfferList().get(index).getLimitPrice());
					}else {
						trade.setPrice(exchange.getBuyOfferList().get(index).getLimitPrice());
					}
					System.out.println(trade.getPrice());
					
					result.append(trade.toString() + System.lineSeparator());
					index++;
				}
			}else{
				int index = 0;
				while(index < buyNum) {
					Trade trade = new Trade();
					trade.setBuyOfferId(exchange.getBuyOfferList().get(index).getOfferId());
					trade.setSellOfferId(exchange.getSellOfferList().get(index).getOfferId());
					if(exchange.getBuyOfferList().get(index).getLimitPrice() 
							>= exchange.getSellOfferList().get(index).getLimitPrice()) {
						trade.setPrice(exchange.getSellOfferList().get(index).getLimitPrice());
					}else {
						trade.setPrice(exchange.getBuyOfferList().get(index).getLimitPrice());
					}
					System.out.println(trade.getPrice());
					
					result.append(trade.toString() + System.lineSeparator());
					index++;
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

package com.nick.love.myra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DefaultFunction {

	public static void main(String[] args) {
		List<ICard> cards = new ArrayList<>();
		
		ICard iCard1 = new ICard();
		iCard1.setName("招商银行白金Young卡");
		iCard1.setHolder("Nick");
		iCard1.setNumber("6028-5688-3698-888");
		iCard1.setPassword("86592201");
		cards.add(iCard1);
		
		ICard iCard2 = new ICard();
		iCard2.setName("招商银行金葵花卡");
		iCard2.setHolder("Myra");
		iCard2.setNumber("6026-5688-3688-888");
		iCard2.setPassword("86592202");
		cards.add(iCard2);
		
		ICardGroup iCardGroup = new ICardGroupImpl(cards);
		
		// 调用 ICardGroupImpl 的 sort 方法进行排序
		List<ICard> res1Cards = iCardGroup.sort();

		for(ICard iCard : res1Cards) {
			System.out.println(iCard.getName());
			System.out.println(iCard.getNumber());
			System.out.println(iCard.getHolder());
		}
		
		System.out.println("--------------------------");
		// 调用 ICardGroup.sort(Comparator) 方法进行排序，用户自定义排序规则
		// 使用 Lambda 表达式实现
		List<ICard> res2Cards = iCardGroup.sort((a, b) -> a.getName().compareTo(b.getName()));
		for(ICard iCard : res2Cards) {
			System.out.println(iCard.getName());
			System.out.println(iCard.getNumber());
			System.out.println(iCard.getHolder());
		}
		
		System.out.println("--------------------------");
		// 实现更复杂的功能, 使用 Comparator 的静态方法 comparing 实现
		List<ICard> res3Cards = iCardGroup.sort(Comparator.comparing(ICard::getHolder));
		for(ICard iCard : res3Cards) {
			System.out.println(iCard.getName());
			System.out.println(iCard.getNumber());
			System.out.println(iCard.getHolder());
		}
		
		System.out.println("--------------------------");
		// 实现更复杂的功能, 使用 Comparator 的静态方法 comparing 逆序实现
		List<ICard> res4Cards = iCardGroup.sort(Comparator.comparing(ICard::getHolder).reversed());
		for(ICard iCard : res4Cards) {
			System.out.println(iCard.getName());
			System.out.println(iCard.getNumber());
			System.out.println(iCard.getHolder());
		}
	}

}

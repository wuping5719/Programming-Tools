package com.ouc.cs;

import java.util.List;

public class Exchange {
	// buy books
	private List<Offer> buyOfferList;   // 待买入 Offer
	
	// sell books
	private List<Offer> sellOfferList;   // 待卖出 Offer

	public List<Offer> getBuyOfferList() {
		return buyOfferList;
	}

	public void setBuyOfferList(List<Offer> buyOfferList) {
		this.buyOfferList = buyOfferList;
	}

	public List<Offer> getSellOfferList() {
		return sellOfferList;
	}

	public void setSellOfferList(List<Offer> sellOfferList) {
		this.sellOfferList = sellOfferList;
	}
	
	/*
	 * 判断交易是否执行 条件：
	 * 对于一个新的(timestamp较大)BUY：选择一个最低卖价等于或小于其最高买价的SELL(timestamp较小)，交易成功
	 * 对于一个新的(timestamp较大)SELL：选择一个最高买价等于或大于其最低卖价的BUY(timestamp较小)，交易成功
	 */
	
}

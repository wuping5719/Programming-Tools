package com.ouc.cs;

public class Trade {
	private long buyOfferId;   // 成功出售的出价Id
	private long sellOfferId;   // 成功购买的出价Id
	private int price;   // 交易的价格

	// 为了打印设计
    @Override
    public String toString() {
        return buyOfferId + " " + sellOfferId + " " + price;
    }
    
	public void setBuyOfferId(long value) {
		this.buyOfferId = value;
	}

	public long getbuyOfferId() {
		return this.buyOfferId;
	}

	public void setSellOfferId(long value) {
		this.sellOfferId = value;
	}

	public long getSellOfferId() {
		return this.sellOfferId;
	}

	public void setPrice(int value) {
		this.price = value;
	}

	public int getPrice() {
		return this.price;
	}
}

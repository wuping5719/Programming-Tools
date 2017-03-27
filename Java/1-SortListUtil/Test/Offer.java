package com.ouc.cs;

public class Offer implements Comparable<Offer> {
	private int orderId;    // 有多个Offer，按读入先后顺序排序
	private long offerId;   // 出价ID
	private long timeStamp; // 出价时间，出价时间越早，权重越高，交易时取越早的极限额
	private char behavior;  // 出价的行为，B=BUY，S=SELL
	private int limitPrice;   // 出价极限额。如果是BUY，代表最高买价；如果是SELL，代表最低卖价

	public void setOrderId(int value) {
		this.orderId = value;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOfferId(long value) {
		this.offerId = value;
	}

	public long getOfferId() {
		return this.offerId;
	}

	public void setTimeStamp(long value) {
		this.timeStamp = value;
	}

	public long getTimeStamp() {
		return this.timeStamp;
	}

	public void setBehavior(char value) {
		this.behavior = value;
	}

	public char getBhavior() {
		return this.behavior;
	}

	public int getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(int limitPrice) {
		this.limitPrice = limitPrice;
	}
	
	// 为了打印设计
    @Override
    public String toString() {
        return offerId + " " + timeStamp + " " + behavior + " " + limitPrice;
    }
    
	// 注意：如果使用MySortList类，则此方法不再需要。因为此方法是提供给Collections.sort方法使用的。
    @Override
    public int compareTo(Offer o) {
        // 只能对一个字段做比较，如果做整个对象的比较就实现不了按指定字段排序了。
        return this.getLimitPrice() - o.getLimitPrice();
    }
}

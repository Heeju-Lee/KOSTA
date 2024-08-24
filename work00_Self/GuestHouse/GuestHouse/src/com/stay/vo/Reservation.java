package com.stay.vo;

import java.sql.Date;

public class Reservation {
	int id;
	String guestHouseId;
	String roomNum;
	Date startDate;
	Date endDate;
	int totalPrice;

	public Reservation() {}
	public Reservation(int id, Date startDate, Date endDate, int totalPrice) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
	}
	public Reservation(String guestHouseId, String roomNum, Date startDate, Date endDate, int totalPrice) {
		this.guestHouseId = guestHouseId;
		this.roomNum = roomNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Reservation [guestHouseId=" + guestHouseId + ", roomNum=" + roomNum + ", startDate=" + startDate + ", endDate=" + endDate+ ", totalPrice=" + totalPrice + "]";
	}
}
package com.example.master.dto;

import java.sql.Date;
import java.util.List;

public class PriceDTO {
	
	private long priceId;
	private PriceGroupDTO itemGroup;
	private ItemPriceDTO item;
	private String itemGroupCode;
	private String itemCode;
	
	private long rate;
	private Date recievedDate;
	private String modBy;
	private Date modOn;
	private long receivedQty;
	public long getPriceId() {
		return priceId;
	}
	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}
	public PriceGroupDTO getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(PriceGroupDTO itemGroup) {
		this.itemGroup = itemGroup;
	}
	public ItemPriceDTO getItem() {
		return item;
	}
	public void setItem(ItemPriceDTO item) {
		this.item = item;
	}
	public String getItemGroupCode() {
		return itemGroupCode;
	}
	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	public Date getRecievedDate() {
		return recievedDate;
	}
	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}
	public String getModBy() {
		return modBy;
	}
	public void setModBy(String modBy) {
		this.modBy = modBy;
	}
	public Date getModOn() {
		return modOn;
	}
	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}
	public long getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(long receivedQty) {
		this.receivedQty = receivedQty;
	}
	@Override
	public String toString() {
		return "PriceDTO [priceId=" + priceId + ", itemGroupCode=" + itemGroupCode + ", itemCode=" + itemCode
				+ ", rate=" + rate + ", recievedDate=" + recievedDate + ", modBy=" + modBy + ", modOn=" + modOn
				+ ", receivedQty=" + receivedQty + "]";
	}
	
	
	
	
	
	
	
	
	

}

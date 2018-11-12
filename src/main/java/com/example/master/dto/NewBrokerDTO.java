package com.example.master.dto;

public class NewBrokerDTO {

	private long brokerId;
	private String brokerName;
	private String address;
	
	public long getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

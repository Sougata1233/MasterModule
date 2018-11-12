package com.example.master.dto;

import java.util.List;

import com.example.master.entity.Mukam;

public class BrokerEntityDTO {

	private long brokerId;
	private String brokerName;
	private String address;
	
	private List<Mukam> mukam;
	
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
	public List<Mukam> getMukam() {
		return mukam;
	}
	public void setMukam(List<Mukam> mukam) {
		this.mukam = mukam;
	}
}

package com.example.master.dto;

import java.util.List;

import com.example.master.entity.Mukam;

public class BrokerNewDTO {

	private List<NewBrokerDTO> broker;
//	private List<SupplierMaster> supplier;
	private List<Mukam> mukamBroker;
	
	/*public List<SupplierMaster> getSupplier() {
		return supplier;
	}
	public void setSupplier(List<SupplierMaster> supplier) {
		this.supplier = supplier;
	}*/
	public List<Mukam> getMukamBroker() {
		return mukamBroker;
	}
	public void setMukamBroker(List<Mukam> mukamBroker) {
		this.mukamBroker = mukamBroker;
	}
	public List<NewBrokerDTO> getBroker() {
		return broker;
	}
	public void setBroker(List<NewBrokerDTO> broker) {
		this.broker = broker;
	}
	
}

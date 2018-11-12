package com.example.master.dto;

public class BrokerWithMukamDTO {

	private BrokerNewDTO broker;
	private SupplierNewDTO supplier;
	
	public SupplierNewDTO getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierNewDTO supplier) {
		this.supplier = supplier;
	}
	public BrokerNewDTO getBroker() {
		return broker;
	}
	public void setBroker(BrokerNewDTO br) {
		this.broker = br;
	}
	
	
}

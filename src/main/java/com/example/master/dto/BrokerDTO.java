package com.example.master.dto;

import java.util.List;

import com.example.master.controller.SuppMapDTO;
import com.example.master.entity.SupplierMaster;

public class BrokerDTO {
	
	private long brokerId;
	private String brokerName;
	private String email;
	private String pan;
	private String gst;
	private String address;
	private List<SuppMapDTO> suppliers;
	private String isMapped;
	
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public List<SuppMapDTO> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<SuppMapDTO> suppliers) {
		this.suppliers = suppliers;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public BrokerDTO(long brokerId, String brokerName, String email, String pan, String gst) {
		super();
		this.brokerId = brokerId;
		this.brokerName = brokerName;
		this.email = email;
		this.pan = pan;
		this.gst = gst;
	}
	public BrokerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BrokerDTO [brokerId=" + brokerId + ", brokerName=" + brokerName + ", email=" + email + ", pan=" + pan
				+ ", gst=" + gst + "]";
	}
	
	

}

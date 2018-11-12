package com.example.master.dto;

import java.util.List;

import com.example.master.entity.Mukam;

public class BrokerSuppMukamDTO {

	private String suppCode;
	private String suppName;
	private String address1;
	private List<Mukam> mukams;
	private String flag;
	
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public List<Mukam> getMukams() {
		return mukams;
	}
	public void setMukams(List<Mukam> mukams) {
		this.mukams = mukams;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}

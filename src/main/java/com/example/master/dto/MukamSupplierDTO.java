package com.example.master.dto;

public class MukamSupplierDTO {
	
	private long id;
	private String mukamName;
	private String suppCode;
	private String isMapped;
	
	
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMukamName() {
		return mukamName;
	}
	public void setMukamName(String mukamName) {
		this.mukamName = mukamName;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public MukamSupplierDTO(long id, String mukamName, String isMapped) {
		super();
		this.id = id;
		this.mukamName = mukamName;
		this.isMapped = isMapped;
	}
	public MukamSupplierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MukamSupplierDTO [id=" + id + ", mukamName=" + mukamName + ", isMapped=" + isMapped + "]";
	}
	
	

}

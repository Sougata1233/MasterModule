package com.example.master.controller;

public class SuppMapDTO {
	
	private String id;
	private String suppName;
	private String isMapped;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public SuppMapDTO(String id, String suppName, String isMapped) {
		super();
		this.id = id;
		this.suppName = suppName;
		this.isMapped = isMapped;
	}
	public SuppMapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SuppMapDTO [id=" + id + ", suppName=" + suppName + ", isMapped=" + isMapped + "]";
	}
	
	
	
	

}

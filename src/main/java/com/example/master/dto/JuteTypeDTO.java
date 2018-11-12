package com.example.master.dto;

public class JuteTypeDTO {

	private String id;
	private String itemDsc;
	private String isMapped;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getitemDsc() {
		return itemDsc;
	}
	public void setitemDsc(String itemDsc) {
		this.itemDsc = itemDsc;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public JuteTypeDTO(String id, String itemDsc, String isMapped) {
		super();
		this.id = id;
		this.itemDsc = itemDsc;
		this.isMapped = isMapped;
	}
	public JuteTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JuteTypeDTO [id=" + id + ", itemDsc=" + itemDsc + ", isMapped=" + isMapped + "]";
	}
	
	
	
}

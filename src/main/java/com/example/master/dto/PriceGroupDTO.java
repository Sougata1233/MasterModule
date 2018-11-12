package com.example.master.dto;

public class PriceGroupDTO {
	
	private String id;
	private String groupDesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	@Override
	public String toString() {
		return "ItemPriceDTO [id=" + id + ", groupDesc=" + groupDesc + "]";
	}
	public PriceGroupDTO(String id, String groupDesc) {
		super();
		this.id = id;
		this.groupDesc = groupDesc;
	}
	public PriceGroupDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

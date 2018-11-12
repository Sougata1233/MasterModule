package com.example.master.dto;

public class ItemPriceDTO {
	
	private String id;
	private String  itemDesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public ItemPriceDTO(String id, String itemDesc) {
		super();
		this.id = id;
		this.itemDesc = itemDesc;
	}
	public ItemPriceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ItemPriceDTO [id=" + id + ", itemDesc=" + itemDesc + "]";
	}
	
	
	
	

}

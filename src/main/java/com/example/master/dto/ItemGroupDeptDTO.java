package com.example.master.dto;

public class ItemGroupDeptDTO {
	
	private long mapId;
	private String itemGrp;
	private String deptId;
	private String isMapped;
	public long getMapId() {
		return mapId;
	}
	public void setMapId(long mapId) {
		this.mapId = mapId;
	}
	public String getItemGrp() {
		return itemGrp;
	}
	public void setItemGrp(String itemGrp) {
		this.itemGrp = itemGrp;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public ItemGroupDeptDTO(long mapId, String itemGrp, String deptId, String isMapped) {
		super();
		this.mapId = mapId;
		this.itemGrp = itemGrp;
		this.deptId = deptId;
		this.isMapped = isMapped;
	}
	public ItemGroupDeptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ItemGroupDeptDTO [mapId=" + mapId + ", itemGrp=" + itemGrp + ", deptId=" + deptId + ", isMapped="
				+ isMapped + "]";
	}
	
	
	

}

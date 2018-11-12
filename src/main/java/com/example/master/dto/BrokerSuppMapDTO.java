package com.example.master.dto;

public class BrokerSuppMapDTO {
	
	private long mapId;
	private long brokerId;
	private String suppCode;
	private String isMapped;
	public long getMapId() {
		return mapId;
	}
	public void setMapId(long mapId) {
		this.mapId = mapId;
	}
	public long getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public BrokerSuppMapDTO(long mapId, long brokerId, String suppCode, String isMapped) {
		super();
		this.mapId = mapId;
		this.brokerId = brokerId;
		this.suppCode = suppCode;
		this.isMapped = isMapped;
	}
	public BrokerSuppMapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BrokerSuppMapDTO [mapId=" + mapId + ", brokerId=" + brokerId + ", suppCode=" + suppCode + ", isMapped="
				+ isMapped + "]";
	}
	
	

}

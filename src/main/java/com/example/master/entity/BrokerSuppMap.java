package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BROKER_SUPP_MAP")
public class BrokerSuppMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BROKER_SUPP_MAP_SEQ")
	@SequenceGenerator(name="BROKER_SUPP_MAP_SEQ", sequenceName="BROKER_SUPP_MAP_SEQ")
	@Column(name="MAP_ID")
	private long mapId;
	
	@Column(name="BROKER_ID")
	private long brokerId;
	
	@Column(name="SUPP_CODE")
	private String suppCode;
	
	@Column(name="IS_MAPPED")
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

	public BrokerSuppMap(long mapId, long brokerId, String suppCode, String isMapped) {
		super();
		this.mapId = mapId;
		this.brokerId = brokerId;
		this.suppCode = suppCode;
		this.isMapped = isMapped;
	}

	public BrokerSuppMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BrokerSuppMap [mapId=" + mapId + ", brokerId=" + brokerId + ", suppCode=" + suppCode + ", isMapped="
				+ isMapped + "]";
	}
	
	
	

}

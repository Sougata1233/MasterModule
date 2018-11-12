package com.example.master.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STORE_MASTER")
public class StoreMaster {
	
	@Id
	@Column(name="STORE_ID")
	private long storeId;
	
	@Column(name="STORE_NAME")
	private String storeName;
	
	@Column(name="STORE_ADDRESS")
	private String storeAddress;
	
	@Column(name="MOD_ON")
	private Date modOn;
	
	@Column(name="MOD_BY")
	private String modBy;

	
	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	@Override
	public String toString() {
		return "StoreMaster [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", modOn=" + modOn + ", modBy=" + modBy + "]";
	}
	
	
	

}

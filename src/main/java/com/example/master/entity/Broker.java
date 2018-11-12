package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BROKER_MASTER")
public class Broker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BROKER_SEQ")
	@SequenceGenerator(name="BROKER_SEQ", sequenceName="BROKER_SEQ")
	@Column(name="BROKER_ID")
	private long brokerId;
	
	@Column(name="BROKER_NAME")
	private String brokerName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PAN_NO")
	private String pan;
	
	@Column(name="GST_NO")
	private String gst;

	public long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public Broker(long brokerId, String brokerName, String address, String email, String pan, String gst) {
		super();
		this.brokerId = brokerId;
		this.brokerName = brokerName;
		this.address = address;
		this.email = email;
		this.pan = pan;
		this.gst = gst;
	}

	public Broker() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Broker [brokerId=" + brokerId + ", brokerName=" + brokerName + ", address=" + address + ", email="
				+ email + ", pan=" + pan + ", gst=" + gst + "]";
	}
	
	
	

}

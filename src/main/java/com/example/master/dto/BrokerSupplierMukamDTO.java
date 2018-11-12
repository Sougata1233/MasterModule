package com.example.master.dto;

import java.util.List;

import com.example.master.entity.Mukam;

public class BrokerSupplierMukamDTO {

	private String id;
	private String name;
	private String address;

	private List<Mukam> mukams;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Mukam> getMukams() {
		return mukams;
	}
	public void setMukams(List<Mukam> mukams) {
		this.mukams = mukams;
	}
}

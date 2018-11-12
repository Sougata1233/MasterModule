package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WAREHOUSE_DETAILS")
public class WarehouseDetails {
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "WarehouseDetails [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public WarehouseDetails(long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public WarehouseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

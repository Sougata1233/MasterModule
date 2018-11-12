package com.example.master.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.Branch;

public class BankDTO {
	private long id;
	
	private String bname;
	
	private String location;
	
	private String add;
	
	private String modBy;
	
	private Date modOn;
	
	private List<BranchDTO> branchs;

	public BankDTO() {
		super();
		
	}
	
	
	
	public List<BranchDTO> getBranch() {
		return branchs;
	}

	public void setBranch(List<BranchDTO> branchs) {
		this.branchs = branchs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	@Override
	public String toString() {
		return "BankDto [id=" + id + ", bname=" + bname + ", location=" + location + ", add=" + add + ", modBy="
				+ modBy + ", modOn=" + modOn + "]";
	}
	
	

}

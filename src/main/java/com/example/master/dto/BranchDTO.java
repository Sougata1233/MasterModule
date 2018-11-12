package com.example.master.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class BranchDTO {
	private long id;
	
	private String brname;
	
	private String add;
	
	private String modBy;
	
	private Date modOn;
	
	private String ifsc;
	
	private Long bankId;
	
	private BankDTO bank;

	
	public BankDTO getBank() {
		return bank;
	}

	public void setBank(BankDTO bank) {
		this.bank = bank;
	}

	
	public long getbankId() {
		return bankId;
	}

	public void setbankId(long bankId) {
		this.bankId = bankId;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
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

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public BranchDTO() {
		super();
	}
	
	

	
	@Override
	public String toString() {
		return "Branch [id=" + id + ", brname=" + brname + ", add=" + add + ", modBy=" + modBy + ", modOn=" + modOn
				+ ", ifsc=" + ifsc + ", bank=" + bank + "]";
	}

	
	
	

}

package com.example.master.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "BRANCH_MASTER")
public class Branch {
	@Id
	@Column(name = "BRANCH_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "BRANCH_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name = "BRANCH_NAME")
	private String brname;
	
	@Column(name = "ADDRESS")
	private String add;
	
	@Column(name = "MOD_BY")
	private String modBy;
	
	@Column(name = "MOD_ON")
	private Date modOn;
	
	@Column(name = "IFSC_CODE")
	private String ifsc;
	
	     
	@Column(name = "BANK_ID")
	private Long bankId;
	
	@OneToOne(cascade = {  }, fetch = FetchType.EAGER)
	@JoinColumn(name = "BANK_ID",insertable = false, updatable = false)
	private Bank bank;

	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
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

	public Branch() {
		super();
	}
	
	

	
	@Override
	public String toString() {
		return "Branch [id=" + id + ", brname=" + brname + ", add=" + add + ", modBy=" + modBy + ", modOn=" + modOn
				+ ", ifsc=" + ifsc + ", bank=" + bank + "]";
	}

	
	
	

}

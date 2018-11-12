package com.example.master.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "BANK_MASTER")
public class Bank {
	
	@Id 
	@Column(name = "BANK_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "BANK_SEQ", allocationSize = 1)
    private long id;
	
	@Column(name = "BANK_NAME")
	private String bname;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "ADDRESS")
	private String add;
	
	@Column(name = "MOD_BY")
	private String modBy;
	
	@Column(name = "MOD_ON")
	private Date modOn;
	
	 @OneToMany(cascade = {  })
	 @JoinColumn(name = "BANK_ID",insertable = false, updatable = false)
	 private List<Branch> branchs;
	    
	
	public List<Branch> getBranch() {
		return branchs;
	}

	public void setBranch(List<Branch> branchs) {
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

	public Bank() {
		super();
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bname=" + bname + ", location=" + location + ", add=" + add + ", modBy=" + modBy
				+ ", modOn=" + modOn + "]";
	}
	
	

}

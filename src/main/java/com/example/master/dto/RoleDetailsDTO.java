package com.example.master.dto;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class RoleDetailsDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String role;

    private int isEnable;
    
    private Date fromDate;
    
    private Date toDate;
    
    private String modby;

    private Date modifiedOn;
    
    
    
    
    public RoleDetailsDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getrole() {
	return role;
    }

    public void setrole(String role) {
	this.role = role;
    }

    public int getisEnable() {
	return isEnable;
    }

    public void setisEnable(int isEnable) {
	this.isEnable = isEnable;
    }

    public Date getfromDate() {
	return fromDate;
    }

    public void setfromDate(Date fromDate) {
	this.fromDate = fromDate;
    }

    public Date gettoDate() {
	return toDate;
    }

    public void settoDate(Date toDate) {
	this.toDate = toDate;
    }

    public String getmodby() {
	return modby;
    }

    public void setmodby(String modby) {
	this.modby = modby;
    }

    public Date getmodifiedOn() {
	return modifiedOn;
    }

    public void setmodifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    
    @Override
    public String toString() {
	return "RoleDetailsDTO[id=" + id + ", role=" + role + ", isEnable=" + isEnable + ", fromDate=" + fromDate
		+ ", toDate=" + toDate + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


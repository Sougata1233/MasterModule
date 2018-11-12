package com.example.master.entity;


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
import javax.persistence.Table;

@Entity
@Table(name = "USER_GROUP_MASTER")
public class Usergroup implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "USER_GRP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USER_GRP_NAME")
    private String usrgrpName;

    @Column(name = "IS_ENABLE")
    private int isenable;
    
    
    @Column(name = "FROM_DATE")
    private Date fromDate;
    

    @Column(name = "TO_DATE")
    private Date toDate;
    
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_DATE")
    private Date modifiedOn;
    
    
    public Usergroup() {
	 super();
    }

    public Long getId() {
	 return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUsrgrpName() {
	  return usrgrpName;
    }

    public void setUsrgrpName(String usrgrpName) {
	this.usrgrpName = usrgrpName;
    }

    public int getIsenable() {
	  return isenable;
    }

    public void setIsenable(int isenable) {
	  this.isenable = isenable;
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
	return "Usrgrp [id=" + id + ", usrgrpName=" + usrgrpName + ", isenable=" + isenable + ", fromDate=" + fromDate
		+ ", toDate=" + toDate + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


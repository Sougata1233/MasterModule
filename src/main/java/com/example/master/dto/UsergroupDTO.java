package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class UsergroupDTO {

    private Long id;

    private String usrgrpName;

    private int isenable;
    
    private Date fromDate;
    
    private Date toDate;
    
    private String modby;

    private Date modifiedOn;
    
    
 
    
    public UsergroupDTO() {
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

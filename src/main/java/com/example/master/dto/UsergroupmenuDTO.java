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

public class UsergroupmenuDTO {

    private Long id;

    private int usergrpid;

    private int menuId;
    
    private Date fromDate;
    
    private Date endDate;
    
    private int Isenable;
    
    private String modby;

    private Date modifiedOn;
    
    
    
    public UsergroupmenuDTO() {
	super();
    }

    public Long getId() {
   	 return id;
       }

       public void setId(Long id) {
   	this.id = id;
       }

       public int getUsergrpid() {
   	  return usergrpid;
       }

       public void setUsergrpid(int usergrpid) {
   	this.usergrpid = usergrpid;
       }

       public int getmenuId() {
   	  return menuId;
       }

       public void setmenuId(int menuId) {
   	  this.menuId = menuId;
       }

       public Date getfromDate() {
   	 return fromDate;
       }

       public void setfromDate(Date fromDate) {
   	 this.fromDate = fromDate;
       }

       
       
       public Date getendDate() {
        return endDate;
       }

       public void setendDate(Date endDate) {
         this.endDate = endDate;
       }

       public int getIsenable() {
          return Isenable;
       }

        public void setIsenable(int Isenable) {
          this.Isenable = Isenable;
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
   	return "Usergrpmenu [id=" + id + ", usergrpid=" + usergrpid + ", menuId=" + menuId + ", fromDate=" + fromDate
   		+ ", endDate=" + endDate + ",Isenable=" +Isenable+  ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
       }
}

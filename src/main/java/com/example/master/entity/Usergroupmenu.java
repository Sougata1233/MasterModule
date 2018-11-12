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
@Table(name = "USER_GRP_MENU_MASTER")
public class Usergroupmenu implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "MAPPING_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USER_GRP_ID")
    private int usergrpid;

    @Column(name = "MENU_ID")
    private int menuId;
    
    
    @Column(name = "FROM_DATE")
    private Date fromDate;
    

    @Column(name = "END_DATE")
    private Date endDate;
    
    
    @Column(name = "IS_ENABLE")
    private int Isenable;
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public Usergroupmenu() {
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


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

import com.example.master.entity.User;
import com.example.master.entity.Usergroup;

public class ApproverMasterDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id;
    
    private String taskDsc;

    private Long approval1;
    
    private UsergroupDTO usergrp1;
    
    private Long approval2;
    
    private UsergroupDTO usergrp2;
    
    private Long approval3;
    
    private UsergroupDTO usergrp3;
    
    private Long approval4;
    
    private UsergroupDTO usergrp4;
    
    private Long approval5;
    
    private UsergroupDTO usergrp5;
    
    private String modby;

    private Date modifiedOn;
    
    private Long userGrp;
    
    private Long approvalLabel;
    
    public Long getuserGroup() {
	 return userGrp;
    }

    public void setuserGrp(Long userGrp) {
	  this.userGrp = userGrp;
    }
        
    public Long getapprovalLabel() {
     return approvalLabel;
   }

   public void setapprovalLabel(Long approvalLabel) {
     this.approvalLabel = approvalLabel;
   }

    
    public ApproverMasterDTO() {
	  super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public UsergroupDTO getusergrp1() {
    	return usergrp1;
    }

    public void setusergrp1(UsergroupDTO usergrp1) {
    	this.usergrp1 = usergrp1;
    	
    	
    }
    
    public UsergroupDTO getusergrp2() {
    	return usergrp2;
    }
    
    public void setusergrp2(UsergroupDTO usergrp2) {
    	
    	this.usergrp2 = usergrp2;
    	
    	
    }
    
    public UsergroupDTO getusergrp3() {
    	return usergrp3;
    }
    
    
   public void setusergrp3(UsergroupDTO usergrp3) {
    	
    	this.usergrp3 = usergrp3;
    	
    	
    }
   
   public UsergroupDTO getusergrp4() {
   	return usergrp4;
   }
    
   public void setusergrp4(UsergroupDTO usergrp3) {
   	
   	this.usergrp3 = usergrp3;
   	
   	
   }
   
   public UsergroupDTO getusergrp5() {
	   	return usergrp5;
   }
	    
    
   public void setusergrp5(UsergroupDTO usergrp5) {
	   	
	   	this.usergrp5 = usergrp5;
	   	
	   	
	   }

    public String gettaskDsc() {
	return taskDsc;
    }

    public void settaskDsc(String taskDsc) {
	this.taskDsc = taskDsc;
    }

    public Long getapproval1() {
	return approval1;
    }

    public void setapproval1(Long approval1) {
	this.approval1 = approval1;
    }
    
    public Long getapproval2() {
    	return approval2;
    }

    public void setapproval2(Long approval2) {
    	this.approval2 = approval2;
    }
    
    public Long getapproval3() {
    	return approval3;
    }

    public void setapproval3(Long approval3) {
    	this.approval3 = approval3;
    }

    public Long getapproval4() {
    	return approval4;
    }

    public void setapproval4(Long approval4) {
    	this.approval4 = approval4;
    }

    
    public Long getapproval5() {
    	return approval5;
    }

    public void setapproval5(Long approval5) {
    	this.approval5 = approval5;
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
	return "ApproverMasterDTO [id=" + id + ", taskDsc=" + taskDsc + "]";
    }

    

   

}



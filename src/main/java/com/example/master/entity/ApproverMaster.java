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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APPROVER_MASTER")
public class ApproverMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "APPROVER_TASK_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TASK_DESC")
    private String taskDsc;

    @Column(name = "USER_1")
    private Long approval1;
    
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_1",insertable = false, updatable = false)
    private Usergroup usergrp1;
    
    @Column(name = "USER_2")
    private Long approval2;
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_2" ,insertable = false, updatable = false)
    private Usergroup usergrp2;
    
    @Column(name = "USER_3")
    private Long approval3;
    
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_3",insertable = false, updatable = false)
    private Usergroup usergrp3;
    
    @Column(name = "USER_4")
    private Long approval4;
    
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_4",insertable = false, updatable = false)
    private Usergroup usergrp4;
    
    @Column(name = "USER_5")
    private Long approval5;
    
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "USER_5",insertable = false, updatable = false)
    private Usergroup usergrp5;
    
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
 
    
    public ApproverMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public Usergroup getusergrp1() {
    	return usergrp1;
    }

    public void setusergrp1(Usergroup usergrp1) {
    	this.usergrp1 = usergrp1;
    	
    	
    }
    
    public Usergroup getusergrp2() {
    	return usergrp2;
    }
    
    public void setusergrp2(Usergroup usergrp2) {
    	
    	this.usergrp2 = usergrp2;
    	
    	
    }
    
    public Usergroup getusergrp3() {
    	return usergrp3;
    }
    
    
   public void setusergrp3(Usergroup usergrp3) {
    	
    	this.usergrp3 = usergrp3;
    	
    	
    }
   
   public Usergroup getusergrp4() {
   	return usergrp4;
   }
    
   public void setusergrp4(Usergroup usergrp3) {
   	
   	this.usergrp3 = usergrp3;
   	
   	
   }
   
   public Usergroup getusergrp5() {
	   	return usergrp5;
   }
	    
    
   public void setusergrp5(Usergroup usergrp5) {
	   	
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
	return "ApproverMaster [id=" + id + ", taskDsc=" + taskDsc + "]";
    }

    

   

}


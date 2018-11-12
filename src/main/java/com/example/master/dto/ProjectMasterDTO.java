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

public class ProjectMasterDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String prjName;
    
    private String prjDsc;

    private Date prjStartDt;
    
    private Date prjEndDt;
    
    private Date prjActualStartDt;
    
    private Date prjActualEndDt;
    
    private Long plannedDuration;
    
    private Long actualDuration;
    
    private Long prjAllocBudget;
    
    private Long prjAvlBudget;
    
    private String prjStatus;
    
    private String modby;

    private Date modifiedOn;
    
    
    
    public ProjectMasterDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getprjName() {
	return prjName;
    }

    public void setprjName(String prjName) {
	this.prjName = prjName;
    }
    
    
    public String getprjDsc() {
    	return prjDsc;
        }

        public void setprjDsc(String prjDsc) {
    	this.prjDsc = prjDsc;
        }


    public Date getprjStartDt() {
	return prjStartDt;
    }

    public void setprjStartDt(Date prjStartDt) {
	this.prjStartDt = prjStartDt;
    }
    
    public Date getprjEndDt() {
    	return prjEndDt;
    }

    public void setprjEndDt(Date prjEndDt) {
    	this.prjEndDt = prjEndDt;
    }
    
    public Date getprjActualStartDt() {
    	return prjActualStartDt;
    }

    public void setprjActualStartDt(Date prjActualStartDt) {
    	this.prjActualStartDt = prjActualStartDt;
    }
    
    
    public Date getprjActualEndDt() {
    	return prjActualEndDt;
    }

    public void setprjActualEndDt(Date prjActualEndDt) {
    	this.prjActualEndDt = prjActualEndDt;
    }
    

    public Long getplannedDuration() {
    	return plannedDuration;
    }

    public void setplannedDuration(Long plannedDuration) {
    	this.plannedDuration = plannedDuration;
    }

    
    public Long getactualDuration() {
    	return actualDuration;
    }

    public void setactualDuration(Long actualDuration) {
    	this.actualDuration = actualDuration;
    }


    public Long getprjAllocBudget() {
    	return prjAllocBudget;
    }

    public void setprjAllocBudget(Long prjAllocBudget) {
    	this.prjAllocBudget = prjAllocBudget;
    }
    
    public Long getprjAvlBudget() {
    	return prjAvlBudget;
    }

    public void setprjAvlBudget(Long prjAvlBudget) {
    	this.prjAvlBudget = prjAvlBudget;
    }
    
    public String getprjStatus() {
    	return prjStatus;
    }

    public void setprjStatus(String prjStatus) {
    	this.prjStatus = prjStatus;
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
	return "ProjectMasterDTO [id=" + id + ", prjName=" + prjName + "]";
    }

    

   

}


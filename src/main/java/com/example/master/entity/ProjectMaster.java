package com.example.master.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_MASTER")
public class ProjectMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "PRJ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "PROJECT_MASTER_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "PRJ_NAME", nullable=true)
    private String prjName;
    
    @Column(name = "PRJ_DESC", nullable=true)
    private String prjDsc;

    @Column(name = "PRJ_START_DT", nullable=true)
    private Date prjStartDt;
    
    @Column(name = "PRJ_END_DT", nullable=true)
    private Date prjEndDt;
    
    @Column(name = "PRJ_ACTUAL_START_DT", nullable=true)
    private Date prjActualStartDt;
    
    @Column(name = "PRJ_ACTUAL_END_DT", nullable=true)
    private Date prjActualEndDt;
    
    @Column(name = "PLANNED_DURATION", nullable=true)
    private long plannedDuration;
    
    @Column(name = "ACTUAL_DURATION", nullable=true)
    private long actualDuration;
    
    @Column(name = "PRJ_ALLOC_BUDGET", nullable=true)
    private long prjAllocBudget;
    
    @Column(name = "PRJ_AVL_BUDGET", nullable=true)
    private long prjAvlBudget;
    
    @Column(name = "PRJ_STATUS", nullable=true)
    private String prjStatus;
    
    @Column(name = "MOD_BY", nullable=true)
    private String modby;

    @Column(name = "MOD_ON", nullable=true)
    private Date modifiedOn;
    
    
    public ProjectMaster() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
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
	return "ProjectMaster [id=" + id + ", prjName=" + prjName + "]";
    }

    

   

}


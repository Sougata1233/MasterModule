package com.example.master.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY_TYPE")
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "ACTIVITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "ACTIVITY_TYPE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @OneToMany(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "ACTIVITY_ID")
    private List<TaskType> tasktypes;

    @Column(name = "ACTIVITY_START_DATE")
    private Date activityStartDate;
    
    
    @Column(name = "ACTIVITY_END_DATE")
    private Date activityEndDate;
    

    @Column(name = "ACTIVITY_STATUS")
    private String activityStatus;
    
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public Activity() {
	super();
    }
    
    
    public List<TaskType> getTaskType() {
        return tasktypes;
    }

    public void setTaskType(List<TaskType> tasktypes) {
        this.tasktypes = tasktypes;
    }
    

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getActivityName() {
	return activityName;
    }

    public void setActivityName(String activityName) {
	this.activityName = activityName;
    }

    public Date getActivityStartDate() {
	return activityStartDate;
    }

    public void setActivityStartDate(Date activityStartDate) {
	this.activityStartDate = activityStartDate;
    }

    public Date getActivityEndDate() {
	return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
	  this.activityEndDate = activityEndDate;
    }

    public String getActivityStatus() {
	return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
	this.activityStatus = activityStatus;
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
	return "Activity [id=" + id + ", activityName=" + activityName + ", activityStartDate=" + activityStartDate + ", activityEndDate=" + activityEndDate
		+ ", activityStatus=" + activityStatus + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


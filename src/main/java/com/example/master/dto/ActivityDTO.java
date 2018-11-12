package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;
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

import com.example.master.entity.TaskType;

public class ActivityDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

    private String activityName;

    private List<TaskType> tasktypes;

    private Date activityStartDate;
    
    private Date activityEndDate;
    
    private String activityStatus;
    
    private String modby;

    private Date modifiedOn;
    
    
    public ActivityDTO() {
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

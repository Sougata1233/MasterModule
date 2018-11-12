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

public class TaskTypeDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String taskName;

    private String modby;

    private Date modifiedOn;
    
    private Long activityId; 
    
    private ActivityDTO activity;
    
    
    public TaskTypeDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public Long getactivityId() {
	  return activityId;
	  }
	
	  public void setactivityId(Long activityId) {
	  this.activityId = activityId;
	  }
      

    public String gettaskName() {
	return taskName;
    }

    public void settaskName(String taskName) {
	this.taskName = taskName;
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
    
    public ActivityDTO getActivity() {
        return activity;
    }

    public void setActivity(ActivityDTO activity) {
        this.activity = activity;
    }

    
    @Override
    public String toString() {
	return "TaskTypeDTO [id=" + id + ", taskName=" + taskName + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


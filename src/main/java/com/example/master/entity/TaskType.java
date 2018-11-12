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
@Table(name = "TASK_TYPE")
public class TaskType implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "TASK_TYPE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "ACTIVITY_ID")
    private Long activityId;
    
    @OneToOne(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "ACTIVITY_ID",insertable = false, updatable = false)
    private Activity activity;
    
    
    public TaskType() {
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
    
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    

    
    @Override
    public String toString() {
	return "TaskType [id=" + id + ", taskName=" + taskName + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


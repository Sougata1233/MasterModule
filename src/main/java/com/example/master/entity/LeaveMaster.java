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

import com.example.master.dto.StateDTO;

import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "LEAVE_MASTER")
public class LeaveMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "LEAVE_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "LEAVE_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "LEAVE_TYPE")
    private String leaveType;

    @Column(name = "IS_CARRY_FWD")
    private String isCarryFwd;
    
    
    @Column(name = "MAX_NUM_IN_A_YEAR")
    private Long maxNumInAYear;
    

    @Column(name = "CARRY_FWD_LIMIT")
    private Long carrayFwdLimit;
    
    
    @Column(name = "VALIDITY")
    private Long validity;
    
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
   
 
	@Column(name = "CREATED_BY")
	 private Long createdBy;
	
	@Column(name = "CREATED_ON")
    private Date createdOn;
             
	@Column(name = "LOCATION_ID")
    private Long locationId;
	
	@OneToOne(cascade = {  }, fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID",insertable = false, updatable = false)
    private LocationMaster locationmaster;
	
    
    public LeaveMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    
    public LocationMaster getLocationMaster() {
        return locationmaster;
    }

    public void setLocationMaster(LocationMaster locationmaster) {
        this.locationmaster = locationmaster;
    }
   
    public String getleaveType() {
	return leaveType;
    }

    public void setleaveType(String leaveType) {
	this.leaveType = leaveType;
    }

    public String getisCarryFwd() {
	return isCarryFwd;
    }

    public void setisCarryFwd(String isCarryFwd) {
	this.isCarryFwd = isCarryFwd;
    }
    
   
    public Long getmaxNumInAYear() {
	return maxNumInAYear;
    }

    public void setmaxNumInAYear(Long maxNumInAYear) {
	this.maxNumInAYear = maxNumInAYear;
    }

    public Long getCarrayFwdLimit() {
	return carrayFwdLimit;
    }

    public void setCarrayFwdLimit(Long carrayFwdLimit) {
	this.carrayFwdLimit = carrayFwdLimit;
    }
    
   
    public Long getvalidity() {
      return validity;
    }

    public void setvalidity(Long validity) {
      this.validity = validity;
    }
  
    public String getstatus() {
    	return status;
    }

    public void setstatus(String status) {
    	this.status = status;
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

    public Long getcreatedBy() {
        return createdBy;
    }

    public void setcreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    
    public Date getcreatedOn() {
    	return createdOn;
    }

    public void setcreatedOn(Date createdOn) {
    	this.createdOn = createdOn;
    }
    
    public Long getlocationId() {
        return locationId;
    }

    public void setlocationId(Long locationId) {
        this.locationId = locationId;
    }
    
    
    
   
    @Override
    public String toString() {
	return "LeaveMaster [id=" + id + ", leaveType=" + leaveType + ", isCarryFwd=" + isCarryFwd + ", maxNumInAYear=" + maxNumInAYear
		+ ", carrayFwdLimit=" + carrayFwdLimit + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


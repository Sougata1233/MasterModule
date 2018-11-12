package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.LocationMaster;

public class LeaveMasterDTO {

	    private Long id;

	    private String leaveType;

	    private String isCarryFwd;
	    
	    private Long maxNumInAYear;
	    
	    private Long carrayFwdLimit;
	    
	    private Long validity;
	    
	    private String status;
	    
	    private String modby;

	    private Date modifiedOn;
	 
	    private Long createdBy;
		
		private Date createdOn;
	             
		private Long locationId;
		
		private LocationMasterDTO locationmaster;
    
    
    public LeaveMasterDTO() {
	super();
    }

    public Long getId() {
    	return id;
        }

        public void setId(Long id) {
    	this.id = id;
        }
        
        
        public LocationMasterDTO getLocationMaster() {
            return locationmaster;
        }

        public void setLocationMaster(LocationMasterDTO locationmaster) {
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
    	return "LeaveMasterDTO [id=" + id + ", leaveType=" + leaveType + ", isCarryFwd=" + isCarryFwd + ", maxNumInAYear=" + maxNumInAYear
    		+ ", carrayFwdLimit=" + carrayFwdLimit + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
        }

        
  

  

}

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

public class LocationMasterDTO {

    private Long id;

    private String locationArea;

    private String locationCity;
    
    private String locationState;
    
    private String locationCountry;
    
    private Long locationPin;
    
    private Long createdBy;
    
    private Date createdOn;
    
    private Long modby;

    private Date modifiedOn;
    
    
    public LocationMasterDTO() {
	super();
    }

    public Long getId() {
    	return id;
        }

        public void setId(Long id) {
    	this.id = id;
        }
      
        public String getlocationArea() {
    	return locationArea;
        }

        public void setlocationArea(String locationArea) {
    	this.locationArea = locationArea;
        }
        
        public String getlocationCity() {
    	return locationCity;
        }

        public void setlocationCity(String locationCity) {
    	this.locationCity = locationCity;
        }
       
        public String getlocationState() {
    	return locationState;
        }

        public void setlocationState(String locationState) {
    	this.locationState = locationState;
        }
       
        public String getlocationCountry() {
    	return locationCountry;
        }

        public void setlocationCountry(String locationCountry) {
    	this.locationCountry = locationCountry;
        }
        
      
        
        public Long getlocationPin() {
        	return locationPin;
        }

        public void setlocationPin(Long locationPin) {
        	this.locationPin = locationPin;
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
        public Long getmodby() {
    	return modby;
        }

        public void setmodby(Long modby) {
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
    	return "LocationMaster [id=" + id + ", locationArea=" + locationArea + ", locationCity=" + locationCity + ", locationState=" + locationState
    		+ ", locationCountry=" + locationCountry + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
        }

  

}

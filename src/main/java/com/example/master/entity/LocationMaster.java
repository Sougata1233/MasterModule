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
@Table(name = "LOCATION_MASTER")
public class LocationMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "LOCATION_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "LOCATION_AREA")
    private String locationArea;

    @Column(name = "LOCATION_CITY")
    private String locationCity;
    
    
    @Column(name = "LOCATION_STATE")
    private String locationState;
    

    @Column(name = "LOCATION_COUNTRY")
    private String locationCountry;
    
    @Column(name = "LOCATION_PIN")
    private Long locationPin;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_ON")
    private Date createdOn;
    
    @Column(name = "MOD_BY")
    private Long modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public LocationMaster() {
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
	return "Activity [id=" + id + ", locationArea=" + locationArea + ", locationCity=" + locationCity + ", locationState=" + locationState
		+ ", locationCountry=" + locationCountry + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


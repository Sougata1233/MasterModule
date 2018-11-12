package com.example.master.dto;


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

public class HolidayMasterDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date holiday;

    private String description;
    
    private String holidayTyp;
    
    private Long locationId;
    
    private LocationMasterDTO locationmaster;
    
    private Long holidayYr;
    
    private String modby;

    private Date modifiedOn;
    
    private String createdby;

    private Date createdOn;
    
       
    
    public HolidayMasterDTO() {
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

    public Date getholiday() {
	return holiday;
    }

    public void setholiday(Date holiday) {
	this.holiday = holiday;
    }

    public String getdescription() {
	return description;
    }

    public void setdescription(String description) {
	this.description = description;
    }

    public String getholidayTyp() {
	return holidayTyp;
    }

    public void setholidayTyp(String holidayTyp) {
	this.holidayTyp = holidayTyp;
    }

    public Long getlocationId() {
	return locationId;
    }

    public void setlocationId(Long locationId) {
	this.locationId = locationId;
    }
    
    public Long getholidayYr() {
    	return holidayYr;
     }

    public void setholidayYr(Long holidayYr) {
    	this.holidayYr = holidayYr;
    }

   
    public Date getmodifiedOn() {
	return modifiedOn;
    }

    public void setmodifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }
    
    
    
    public String getmodby() {
    	return modby;
    }

     public void setmodby(String modby) {
    	this.modby = modby;
    }
     
     public String getcreatedby() {
    	return createdby;
     }

     public void setcreatedby(String createdby) {
    	this.createdby = createdby;
     }


     public Date getcreatedOn() {
    	return createdOn;
     }

     public void setcreatedOn(Date createdOn) {
    	this.createdOn = createdOn;
     }

    
    @Override
    public String toString() {
	return "HolidayMaster [id=" + id + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}


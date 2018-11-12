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
@Table(name = "HOLIDAY_MASTER")
public class HolidayMaster implements Serializable {
	
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "HOLIDAY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "HOLIDAY_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "HOLIDAY")
    private Date holiday;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "HOLIDAY_TYPE")
    private String holidayTyp;
    
    @Column(name = "LOCATION_ID")
    private Long locationId;
    
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID",insertable = false, updatable = false)
    private LocationMaster locationmaster;
    
    @Column(name = "HOLIDAY_YEAR")
    private Long holidayYr;
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "CREATED_BY")
    private String createdby;

    @Column(name = "CREATED_ON")
    private Date createdOn;
    
    
    public HolidayMaster() {
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


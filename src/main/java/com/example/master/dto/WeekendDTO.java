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
import com.example.master.entity.Organization;

public class WeekendDTO {

	    private Long id;

	    private int locationId;

	    private LocationMasterDTO locationmaster;
	    
	    private OrganizationDTO organization;

	    private int unitId;
	    
	    private String weekend1;
	    
	    private String weekend2;
	    
	    private String alterforw1;
	    
	    private String modby;

	    private Date modifiedOn;
	    
	    
 
    
    
    
    public WeekendDTO() {
	super();
    }

    public Long getId() {
   	 return id;
       }

       public void setId(Long id) {
   	this.id = id;
       }
       
       
    
       public OrganizationDTO getOrganization() {
           return organization;
       }

       public void setOrganization(OrganizationDTO organization) {
           this.organization = organization;
       }
       
       
       public LocationMasterDTO getLocationMaster() {
           return locationmaster;
       }

       public void setLocationMaster(LocationMasterDTO locationmaster) {
           this.locationmaster = locationmaster;
       }

       public int getLocationId() {
   	  return locationId;
       }

       public void setLocationId(int locationId) {
   	this.locationId = locationId;
       }

       public int getunitId() {
   	  return unitId;
       }

       public void setunitId(int unitId) {
   	  this.unitId = unitId;
       }

       public String getWeekend1() {
   	 return weekend1;
       }

       public void setWeekend1(String weekend1) {
   	 this.weekend1 = weekend1;
       }

       
       
       public String getWeekend2() {
        return weekend2;
       }

       public void setWeekend2(String weekend2) {
         this.weekend2 = weekend2;
       }

       public String getAlterforw1() {
          return alterforw1;
       }

        public void setAlterforw1(String alterforw1) {
          this.alterforw1 = alterforw1;
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
   	return "Weekend [id=" + id + ", locationId=" + locationId + ", unitId=" + unitId + ", weekend1=" + weekend1
   		+ ", weekend2=" + weekend2 + ",alterforw1=" +alterforw1+  ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
       }


}

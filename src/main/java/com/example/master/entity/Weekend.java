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

import com.example.master.dto.OrganizationDTO;

@Entity
@Table(name = "WEEKEND_MASTER")
public class Weekend implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "WEEKEND_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "WEEKEND_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "LOCATION_ID")
    private int locationId;

    @OneToOne(cascade = {  }, fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID",insertable = false, updatable = false)
    private LocationMaster locationmaster;
    
    @OneToOne(cascade = {  }, fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT_ID",insertable = false, updatable = false)
    private Organization organization;
    

    @Column(name = "UNIT_ID")
    private int unitId;
    
    
    @Column(name = "WEEKEND1")
    private String weekend1;
    

    @Column(name = "WEEKEND2")
    private String weekend2;
    
    
    @Column(name = "ALTR_FOR_W1")
    private String alterforw1;
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public Weekend() {
	 super();
    }

    public Long getId() {
	 return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
    
    public LocationMaster getLocationMaster() {
        return locationmaster;
    }

    public void setLocationMaster(LocationMaster locationmaster) {
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


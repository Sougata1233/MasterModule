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
@Table(name = "ORGANIZATION")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "ORG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "ORGANIZATION_SEQ", allocationSize = 1)
    private Long id;
    
    
    @OneToMany(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    private List<Department> departments;
    
    

    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "HIERARCHY_ID")
    private long hierarchyId;
    
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "SHORT_CODE")
    private String shortCode;
 
    @Column(name = "ORG_TYPE")
    private String orgTyp;
    
    @Column(name="LOCATION_ID")
    private Long locationId;
    
    
    
    
    public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Organization() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    
    public List<Department> getDepartment() {
    	return departments;
    }

    public void setDepartment(List<Department> departments) {
    	this.departments = departments;
    }
	
  
    public String getorgName() {
	return orgName;
    }

    public void setorgName(String orgName) {
	this.orgName = orgName;
    }

   
    

    public long getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(long hierarchyId) {
		this.hierarchyId = hierarchyId;
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
    
    public String getshortCode() {
    	return shortCode;
    }

    public void setshortCode(String shortCode) {
    	this.shortCode = shortCode;
    }
    
    
    public String getorgTyp() {
    	return orgTyp;
    }

    public void setorgTyp(String orgTyp) {
    	this.orgTyp = orgTyp;
    }

    
    @Override
    public String toString() {
	return "Organization [id=" + id + ", orgName=" + orgName + "]";
    }

    

   

}


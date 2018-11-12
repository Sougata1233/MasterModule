package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;
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

public class OrganizationDTO {

    private Long id;
	
    private List<DepartmentDTO> departments;

    private String orgName;

    private long hierarchyId;
    
    private String modby;

    private Date modifiedOn;
    
    private String shortCode;
 
    private String orgTyp;
    
    private long locationId;
    
    private String location;
    
    
    
    
    
    
    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public OrganizationDTO() {
	super();
    }

    public Long getId() {
    	return id;
        }

        public void setId(Long id) {
    	this.id = id;
        }
        
        
        public List<DepartmentDTO> getDepartment() {
        	return departments;
        }

        public void setDepartment(List<DepartmentDTO> departments) {
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

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

import com.example.master.entity.Organization;


public class DepartmentDTO {
		
    	private Long id;

	    private Long orgId;

	    private OrganizationDTO organization;
	    
//	    private List<EmployeeDTO> employees;
	    
	    private String departmentName;
	    
	    private String modby;

	    private Date modifiedOn;
	    
    
    public DepartmentDTO() {
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
    	
    	
       
        /*public List<EmployeeDTO> getEmployee() {
        	return employees;
         }

            public void setEmployee(List<EmployeeDTO> employees) {
        	this.employees = employees;
            }
    	*/
    	
    	
    	
    	public Long getorgId() {
    	return orgId;
        }

        public void setorgId(Long orgId) {
    	this.orgId = orgId;
        }

        public String getdepartmentName() {
    	return departmentName;
        }

        public void setdepartmentName(String departmentName) {
    	this.departmentName = departmentName;
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
			return "DepartmentDTO [id=" + id + ", orgId=" + orgId + ", organization=" + organization
					+ ", departmentName=" + departmentName + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
		}

        
        

  

  

}

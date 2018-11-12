package com.example.master.dto;

import java.sql.Date;
import java.util.List;

import com.example.master.entity.ItemGroupDept;


public class ItemGroupMasterDTO {

    private String id;
 
//    private List<ItemMasterDTO> itemmasteres;
   
    private String grpDsc;
    
    private String activeFlag;
    
    private Long purchaseCode;
 
    private String inactiveTag;
    
    private String modBy;
    
    private Date modOn;
    
    private List<DepartmentMapDTO> department;
    
    
    
    public List<DepartmentMapDTO> getDepartment() {
		return department;
	}

	public void setDepartment(List<DepartmentMapDTO> department) {
		this.department = department;
	}

	
	public ItemGroupMasterDTO() {
	super();
    }

    public String getId() {
    	return id;
        }

        public void setId(String id) {
    	this.id = id;
        }
        
        
    	
        public String getgrpDsc() {
           	return grpDsc;
        }

        public void setgrpDsc(String grpDsc) {
          this.grpDsc = grpDsc;
        }



        public String getactiveFlag() {
    	return activeFlag;
        }

        public void setactiveFlag(String activeFlag) {
    	this.activeFlag = activeFlag;
        }
        
        
        public Long getpurchaseCode() {
        	return purchaseCode;
        }

        public void setpurchaseCode(Long purchaseCode) {
        	this.purchaseCode = purchaseCode;
        }
        
        
        public String getinactiveTag() {
        	return inactiveTag;
        }

        public void setinactiveTag(String inactiveTag) {
        	this.inactiveTag = inactiveTag;
        }
        
        public String getmodBy() {
        	return modBy;
        }

        public void setmodBy(String modBy) {
        	this.modBy = modBy;
        }
        
        
        public Date getmodOn() {
        	return modOn;
        }

        public void setmodOn(Date modOn) {
        	this.modOn = modOn;
        }

        
        @Override
        public String toString() {
    	return "ITEM_GROUP_MASTER [id=" + id + ",grpDsc=" + grpDsc + ", activeFlag=" + activeFlag +  "]";
        }

        
  

  

}

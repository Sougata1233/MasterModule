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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.master.entity.Mukam;
import com.example.master.entity.MukamSupplier;

public class SupplierMasterDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private String id;

    private String suppName;

    private String address1;
    
    private String address2;
    
    private String address3;
    
    private String suppTyp;
    
    private String phone1;
    
    private String phone2;
    
    private String fax;
    
    private String cellPhone;
    
    private String email;
    
    private String user1;
    
    private Date date1;
    
    private String user2;
    
    private Date date2;
    
    private String user3;
    
    private Date date3;
    
    private String user4;
    
    private Date date4;
    
    private String activeFlag;
    
    private String saleTaxNo;
    
    private String blackListedTag;
    
    private Date blackListedDate;
   
    private String vatno;  

	 private String contactPerson;  
    
	 private String designation; 
   
	 private String cst;  
    
	 private String cin;
    
	 private String gstNo;
    
	 private String panNo;
    
    private String modby;

    private Date modifiedOn;
   
	 private String district;
    
	 private String state;
    
	 private String country;
    
	 private String pincode;
    
    private List<MukamSuppMapDTO> mukam;
    private String isMapped;
    
    
    
    
    
    public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}

	public List<MukamSuppMapDTO> getMukam() {
		return mukam;
	}

	public void setMukam(List<MukamSuppMapDTO> mukam) {
		this.mukam = mukam;
	}

	public SupplierMasterDTO() {
	super();
    }

    public String getId() {
    	return id;
     }

     public void setId(String id) {
    	this.id = id;
     }
     
     
     
    public String getsuppTyp() {
   	  return suppTyp;
     }

    public void setsuppTyp(String suppTyp) {
   	  this.suppTyp = suppTyp;
    }


        public String getsuppName() {
    	return suppName;
        }

        public void setsuppName(String suppName) {
    	this.suppName = suppName;
        }

        public String getaddress1() {
        	return address1;
        }

        public void setaddress1(String address1) {
        	this.address1 = address1;
        }
        
        public String getaddress2() {
        	return address2;
        }

        public void setaddress2(String address2) {
        	this.address2 = address2;
        }
        
        public String getaddress3() {
        	return address3;
        }

        public void setaddress3(String address3) {
        	this.address3 = address3;
        }
        
      
        
        
        public String getphone1() {
        	return phone1;
        }

        public void setphone1(String phone1) {
        	this.phone1 = phone1;
        }
        
        public String getphone2() {
        	return phone2;
        }

        public void setphone2(String phone2) {
        	this.phone2 = phone2;
        }
        
        
        public String getfax() {
        	return fax;
        }

        public void setfax(String fax) {
        	this.fax = fax;
        }
        
        
        public String getactiveFlag() {
        	return activeFlag;
        }

        public void setactiveFlag(String activeFlag) {
        	this.activeFlag = activeFlag;
        }
        
        
        public String getsaleTaxNo() {
        	return saleTaxNo;
        }

        public void setsaleTaxNo(String saleTaxNo) {
        	this.saleTaxNo = saleTaxNo;
        }
        
        public String getemail() {
        	return email;
        }

        public void setemail(String email) {
        	this.email = email;
        }
        
        public String getuser1() {
        	return user1;
        }

        public void setuser1(String user1) {
        	this.user1 = user1;
        }
        
        public Date getdate1() {
        	return date1;
        }

        public void setdate1(Date date1) {
        	this.date1 = date1;
        }
        
        
        public String getuser2() {
        	return user2;
        }

        public void setuser2(String user2) {
        	this.user2 = user2;
        }
        
        public Date getdate2() {
        	return date2;
        }

        public void setdate2(Date date2) {
        	this.date2 = date2;
        }
        
        
        public String getuser3() {
        	return user3;
        }

        public void setuser3(String user3) {
        	this.user3 = user3;
        }
        
        public Date getdate3() {
        	return date3;
        }

        public void setdate3(Date date3) {
        	this.date3 = date3;
        }
        
        public String getuser4() {
        	return user4;
        }

        public void setuser4(String user4) {
        	this.user4 = user4;
        }
        
        public Date getdate4() {
        	return date4;
        }

        public void setdate4(Date date4) {
        	this.date4 = date4;
        }
        
        public String getcellPhone() {
        	return cellPhone;
        }

        public void setcellPhone(String cellPhone) {
        	this.cellPhone = cellPhone;
        }
        
        public String getblackListedTag() {
        	return blackListedTag;
        }

        public void setblackListedTag(String blackListedTag) {
        	this.blackListedTag = blackListedTag;
        }
        
        
        public Date getblackListedDate() {
        	return blackListedDate;
        }

        public void setblackListedDate(Date blackListedDate) {
        	this.blackListedDate = blackListedDate;
        }
        
        public String getvatno() {
        	return vatno;
        }

        public void setvatno(String vatno) {
        	this.vatno = vatno;
        }
        
        public String getcontactPerson() {
        	return contactPerson;
        }

        public void setcontactPerson(String contactPerson) {
        	this.contactPerson = contactPerson;
        }
        
        
        public String getdesignation() {
        	return designation;
        }

        public void setdesignation(String designation) {
        	this.designation = designation;
        }
        
       
       
       public String getcst() {
       	return cst;
       }

       public void setcst(String cst) {
       	this.cst = cst;
       }
       
       
       public String getcin() {
    	   	return cin;
       }

       public void setcin(String cin) {
    	   	this.cin = cin;
       }
       
       public String getgstNo() {
    	   	return gstNo;
      }

      public void setgstNo(String gstNo) {
    	   	this.gstNo = gstNo;
      }
      
      
      public String getpanNo() {
      	return panNo;
      }

      public void setpanNo(String panNo) {
      	this.panNo = panNo;
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
        
       
       public String getdistrict() {
    		return district;
       }

       public void setdistrict(String district) {
    		this.district = district;
       }
       
       public String getstate() {
    		return state;
      }

      public void setstate(String state) {
    		this.state = state;
      }
      
      
      public String getcountry() {
    		return country;
      }

      public void setcountry(String country) {
    		this.country = country;
      }
      
      public String getpincode() {
    		return pincode;
      }

     public void setpincode(String pincode) {
    		this.pincode = pincode;
     }
      

        
        @Override
        public String toString() {
    	return "SupplierMaster [id=" + id + ", suppName=" + suppName + "]";
        }

        

       
   

}


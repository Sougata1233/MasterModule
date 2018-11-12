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
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_MASTER")
public class Employee  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "EB_NO")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
  
    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "DEPT_ID")
     private String deptId;
    
    @OneToOne(cascade = {  }, fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPT_ID",insertable = false, updatable = false)
    private Department department;
    
    @Column(name = "EB_ID")
    private String ebId;
    
    @Column(name = "EB_FIXED_ID")
    private String ebFixedId;
    
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
    
    @Column(name = "SEX")
    private String sex;
    
    @Column(name = "FATHER_HUSBAND_NAME")
    private String fatherHusbandName;
    
    
    @Column(name = "RELIGION")
    private String religion;
   
    @Column(name = "OCCU_ID")
    private String occuId;
    
   
	@Column(name = "DATE_OF_JOINING")
	 private String dateOfJoining;  
    
    @Column(name = "DATE_OF_PF_JOINING")
	 private String dateOfPfJoining;  
    
    @Column(name = "ACTIVE")
	 private String active; 
    
    @Column(name = "DATE_OF_INACTIVE")
	 private String dateOfInactive; 
    
    @Column(name = "CATA_ID")
	 private String cataId;
   
	  
	 @Column(name = "WORKING_RELEY")
	  private String workingReley;	
    
    @Column(name = "QUARTER")
	  private String quarter;
    
    @Column(name = "QUARTER_NO")
	  private String quarterNo;
    
    @Column(name = "ESI_MEMBER")
	  private String esiMember;
    
    @Column(name = "PF_MEMBER ")
	  private String pfMember;
    
    @Column(name = "FPF_MEMBER")
	  private String fpfMember;
    
    @Column(name = "ESI_NO")
	  private String esiNo;
    
	  @Column(name = "PF_NO")
	  private String pfNo;
    
     @Column(name = "FPF_NO")
	  private String fpffNo;
     
     @Column(name = "EDUCATION")
	  private String education;
    
     @Column(name = "EDUCATION_READ")
	  private String educationRead;
     
     @Column(name = "EDUCATION_WRITE")
	  private String educationWrite;
     
	@Column(name = "PREV_EMPLOYMENT")
	  private String prevEmployment;
     
     
     @Column(name = "IDENTICAL_MARKS")
	  private String identicalMarks; 
     
     @Column(name = "PERMANENT_ADD1")
	  private String permanentAdd1; 
     
     @Column(name = "PERMANENT_ADD2")
	  private String permanentAdd2; 
     
     @Column(name = "PERMANENT_ADD3")
	  private String permanentAdd3; 
     
     
     @Column(name = "PERMANENT_ADD4")
	  private String permanentAdd4; 
   
	  
	  @Column(name = "LOCAL_ADD1")
	  private String localAdd1;  
     
     
     @Column(name = "LOCAL_ADD2")
	  private String localAdd2; 
     
     @Column(name = "LOCAL_ADD3")
	  private String localAdd3; 
    
     @Column(name = "LOCAL_ADD4")
	  private String localAdd4; 
   
	 @Column(name = "PHONE_NO")
	  private String phoneNo;
     
     @Column(name = "MOBILE_NO")
	  private String mobileNo; 
     
     @Column(name = "OFFDAY")
	  private String offday; 
     
     @Column(name = "PHOTO_DIR")
	  private String photoDir; 
     
     @Column(name = "UPDATED")
	  private String updated; 
     
     @Column(name = "USER_ID")
	  private String userId;
 
	  @Column(name = "OCCU_CODE")
	  private String occuCode;  
     
     @Column(name = "WRK_TYPE")
	  private String wrkType; 
     
     
     @Column(name = "PHOTOFILE")
	  private String photofile;
     
     @Column(name = "CHK_OLD")
	  private String chkOld;
     
     @Column(name = "OLD_EB")
	  private String oldEb;
     
    public Employee() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
    
   
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    

    public String getempName() {
	return empName;
    }

    public void setempName(String empName) {
	this.empName = empName;
    }

    public String getdeptId() {
	  return deptId;
    }

    public void setdeptId(String deptId) {
	this.deptId = deptId;
    } 
    
    public String getebId() {
  	  return ebId;
    }

    public void setebId(String ebId) {
  	    this.ebId = ebId;
    } 
    
    public String getebFixedId() {
    	  return ebFixedId;
    }

    public void setebFixedId(String ebFixedId) {
    	    this.ebFixedId = ebFixedId;
    } 
    
    public String getdateOfBirth() {
  	  return dateOfBirth;
   }

   public void setdateOfBirth(String dateOfBirth) {
  	    this.dateOfBirth = dateOfBirth;
    } 
    
   
    public String getsex() {
	  	  return sex;
    }

	public void setsex(String sex) {
	  	    this.sex = sex;
	} 
	
	
	public String getfatherHusbandName() {
	  	  return fatherHusbandName;
    }

	public void setfatherHusbandName(String fatherHusbandName) {
	  	    this.fatherHusbandName = fatherHusbandName;
	} 
	
	
	
	public String getreligion() {
	  	  return religion;
    }

	public void setreligion(String religion) {
	  	    this.religion = religion;
	} 
	
	
	
	public String getoccuId() {
	  	  return occuId;
    }

	public void setoccuId(String occuId) {
	  	    this.occuId = occuId;
	} 
	
	
	public String getdateOfJoining() {
	  	  return dateOfJoining;
    }

	public void setdateOfJoining(String dateOfJoining) {
	  	    this.dateOfJoining = dateOfJoining;
	}
	
	public String getdateOfPfJoining() {
	  	  return dateOfPfJoining;
    }

	public void setdateOfPfJoining(String dateOfPfJoining) {
	  	    this.dateOfPfJoining = dateOfPfJoining;
	}

	public String getactive() {
	  	  return active;
    }

	public void setactive(String active) {
	  	    this.active = active;
	}
	
  
   public String getdateOfInactive() {
	  	  return dateOfInactive;
   }

	public void setdateOfInactive(String dateOfInactive) {
	  	    this.dateOfInactive = dateOfInactive;
	}
	

    public String getcataId() {
	  	  return cataId;
    }

	public void setcataId(String cataId) {
	  	    this.cataId = cataId;
	}
	
	 public String getworkingReley() {
	  	  return workingReley;
     }

	 public void setworkingReley(String workingReley) {
	  	    this.workingReley = workingReley;
	 }

	 public String getquarter() {
	  	  return quarter;
     }

	 public void setquarter(String quarter) {
	  	    this.quarter = quarter;
	 }
   
  
    public String getquarterNo() {
	  	  return quarterNo;
    }

	 public void setquarterNo(String quarterNo) {
	  	    this.quarterNo = quarterNo;
	 }
   
  
    public String getesiMember() {
	  	  return esiMember;
    }

	 public void setesiMember(String esiMember) {
	  	    this.esiMember = esiMember;
	 }
   
	 
	 
	 public String getpfMember() {
	  	  return pfMember;
    }

	 public void setpfMember(String pfMember) {
	  	    this.pfMember = pfMember;
	 }
   
   
    public String getfpfMember() {
	  	  return fpfMember;
    }

	 public void setfpfMember(String fpfMember) {
	  	    this.fpfMember = fpfMember;
	 }
	 
	 
	 public String getesiNo() {
	  	  return esiNo;
     }

	 public void setesiNo(String esiNo) {
	  	    this.esiNo = esiNo;
	 }
	 
	 
	 public String getpfNo() {
	  	  return pfNo;
    }

	 public void setpfNo(String pfNo) {
	  	    this.pfNo = pfNo;
	 }
	 
	 
	 
	 public String getfpffNo() {
	  	  return fpffNo;
     }

	 public void setfpffNo(String fpffNo) {
	  	    this.fpffNo = fpffNo;
	 }

	 public String geteducation() {
	  	  return education;
     }

	 public void seteducation(String education) {
	  	    this.education = education;
	 }
   
   
    
    public String geteducationRead() {
	  	  return educationRead;
    }

	 public void seteducationRead(String educationRead) {
	  	    this.educationRead = educationRead;
	 }
    
  
    
    public String geteducationWrite() {
	  	  return educationWrite;
    }

	 public void seteducationWrite(String educationWrite) {
	  	    this.educationWrite = educationWrite;
	 }
  
   
	
	public String getprevEmployment() {
	  	  return prevEmployment;
    }

	 public void setprevEmployment(String prevEmployment) {
	  	    this.prevEmployment = prevEmployment;
	 }
    

     public String getidenticalMarks() {
	  	  return identicalMarks;
     }

	 public void setidenticalMarks(String identicalMarks) {
	  	    this.identicalMarks = identicalMarks;
	 }
	 
	 
	 public String getpermanentAdd1() {
	  	  return permanentAdd1;
    }

	 public void setpermanentAdd1(String permanentAdd1) {
	  	    this.permanentAdd1 = permanentAdd1;
	 }
	 
	 
	 public String getpermanentAdd2() {
	  	  return permanentAdd2;
     }
    
	 public void setpermanentAdd2(String permanentAdd2) {
	  	    this.permanentAdd2 = permanentAdd2;
	 }
	 
	 public String getpermanentAdd3() {
	  	  return permanentAdd3;
     }
	 
	 public void setpermanentAdd3(String permanentAdd3) {
	  	    this.permanentAdd3 = permanentAdd3;
	 }
	 
	 
	 public String getpermanentAdd4() {
	  	  return permanentAdd4;
     }
	 
	 public void setpermanentAdd4(String permanentAdd4) {
	  	    this.permanentAdd4 = permanentAdd4;
	 }
    
	
	 public String getlocalAdd1() {
	  	  return localAdd1;
     }
	 
	 public void setlocalAdd1(String localAdd1) {
	  	    this.localAdd1 = localAdd1;
	 }
	 
	 
	 public String getlocalAdd2() {
	  	  return localAdd2;
    }
	 
	 public void setlocalAdd2(String localAdd2) {
	  	    this.localAdd2 = localAdd2;
	 }
	 
	 public String getlocalAdd3() {
	  	  return localAdd3;
    }
	 
	 public void setlocalAdd3(String localAdd3) {
	  	    this.localAdd3 = localAdd3;
	 }
	 
	 public String getlocalAdd4() {
	  	  return localAdd4;
    }
	 
	 public void setlocalAdd4(String localAdd4) {
	  	    this.localAdd4 = localAdd4;
	 }
	 
	
	 
	 public String getphoneNo() {
	  	  return phoneNo;
     }
	 
	 public void setphoneNo(String phoneNo) {
	  	    this.phoneNo = phoneNo;
	 }
	 
	
    public String getmobileNo() {
	  	  return mobileNo;
    }
	 
	 public void setmobileNo(String mobileNo) {
	  	    this.mobileNo = mobileNo;
	 }
    
     
    public String getoffday() {
	  	  return offday;
    }
	 
	 public void setoffday(String offday) {
	  	    this.offday = offday;
	 }
	 
	
	 public String getphotoDir() {
	  	  return photoDir;
     }
	 
	 public void setphotoDir(String photoDir) {
	  	    this.photoDir = photoDir;
	 }
	 
       
    public String getupdated() {
	  	  return updated;
    }
	 
	 public void setupdated(String updated) {
	  	    this.updated = updated;
	 }
    
     public String getuserId() {
	  	  return userId;
     }
	 
	 public void setuserId(String userId) {
	  	    this.userId = userId;
	 }

	 public String getoccuCode() {
	  	  return occuCode;
     }
	 
	 public void setoccuCode(String occuCode) {
	  	    this.occuCode = occuCode;
	 }
	 
	
	public String getwrkType() {
	  	  return wrkType;
    }
	 
	 public void setwrkType(String wrkType) {
	  	    this.wrkType = wrkType;
	 }
   
    public String getphotofile() {
	  	  return photofile;
    }
	 
	 public void setphotofile(String photofile) {
	  	    this.photofile = photofile;
	 }
    
   
    public String getchkOld() {
	  	  return chkOld;
    }
	 
	 public void setchkOld(String chkOld) {
	  	    this.chkOld = chkOld;
	 }
    
    
  
    public String getoldEb() {
	  	  return oldEb;
    }
	 
	 public void setoldEb(String oldEb) {
	  	    this.oldEb = oldEb;
	 }
    
    @Override
    public String toString() {
	return "Employee[id=" + id + ", empName=" + empName + ", deptId=" + deptId + "]";
    }

    

   

}


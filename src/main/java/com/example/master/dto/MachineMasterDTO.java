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
import javax.persistence.Table;

public class MachineMasterDTO {

    private String id;

    private String machineDsc;

    private String millFact;
    
    private String user1;
    
    private Date date1;
    
    private String user2;
    
    private Date date2;
    
    private String user3;
    
    private Date date3;
    
    private String user4;
    
    private Date date4;
    
    private String activeFlag;

    private String dept;
    
    
    
    public MachineMasterDTO() {
	super();
    }

    public String getId() {
    	return id;
        }

        public void setId(String id) {
    	this.id = id;
        }

        public String getmachineDsc() {
    	return machineDsc;
        }

        public void setmachineDsc(String machineDsc) {
    	this.machineDsc = machineDsc;
        }

        public String getmillFact() {
    	return millFact;
        }

        public void setmillFact(String millFact) {
    	this.millFact = millFact;
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
        public String getactiveFlag() {
    	return activeFlag;
        }

        public void setactiveFlag(String activeFlag) {
    	this.activeFlag = activeFlag;
        }

        public String getdept() {
    	return dept;
        }

        public void setdept(String dept) {
    	this.dept = dept;
        }

        
        @Override
        public String toString() {
    	return "MachineMaster[id=" + id + ", machineDsc=" + machineDsc+ "]";
        }

        

  

  

}

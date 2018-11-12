package com.example.master.dto;




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

public class ShiftMasterDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String shiftName;

    private float workingHours;
    
    
    
    public ShiftMasterDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getshiftName() {
	return shiftName;
    }

    public void setshiftName(String shiftName) {
	this.shiftName = shiftName;
    }

    public float getworkingHours() {
	return workingHours;
    }

    public void setworkingHours(float workingHours) {
	this.workingHours = workingHours;
    }

   
    
    @Override
    public String toString() {
	return "ShiftMasterDTO [id=" + id + ", shiftName=" + shiftName + ", workingHours=" + workingHours + "]";
    }

    

   

}



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

@Entity
@Table(name = "SHIFT_MASTER")
public class ShiftMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "REC_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "SHIFT_MASTER_REC_ID", allocationSize = 1)
    private Long id;

    @Column(name = "SHIFT_NAME")
    private String shiftName;

    @Column(name = "WORKING_HOURS")
    private float workingHours;
    
    
    public ShiftMaster() {
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
	return "ShiftMaster [id=" + id + ", shiftName=" + shiftName + ", workingHours=" + workingHours + "]";
    }

    

   

}


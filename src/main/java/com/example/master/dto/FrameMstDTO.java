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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class FrameMstDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private Long id;

    private Long frameNo;

    private String side;
    
    private Long trollyNo;
    
    private String frameType;
    
    private String spindleQtyTyp;
    
    private Long bobbinWeight;
    
    private String mcNum;
    
    private String frameVvfd;
    
    public FrameMstDTO() {
	super();
    }
    
    

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public Long getframeNo() {
    	return frameNo;
    }

    public void setframeNo(Long frameNo) {
    	this.frameNo = frameNo;
    }
    

    public String getside() {
	return side;
    }

    public void setside(String side) {
	this.side = side;
    }

    public Long gettrollyNo() {
	return trollyNo;
    }

    public void settrollyNo(Long trollyNo) {
	this.trollyNo = trollyNo;
    }

    public String getframeType() {
	return frameType;
    }

    public void setframeType(String frameType) {
	this.frameType = frameType;
    }

    public String getspindleQtyTyp() {
	return spindleQtyTyp;
    }

    public void setspindleQtyTyp(String spindleQtyTyp) {
	this.spindleQtyTyp = spindleQtyTyp;
    }

    public Long getbobbinWeight() {
	return bobbinWeight;
    }

    public void setbobbinWeight(Long bobbinWeight) {
	this.bobbinWeight = bobbinWeight;
    }

    public String getmcNum() {
	return mcNum;
    }

    public void setmcNum(String mcNum) {
	this.mcNum = mcNum;
    }
    
    public String getframeVvfd() {
    	return frameVvfd;
    }

    public void setframeVvfd(String frameVvfd) {
      this.frameVvfd = frameVvfd;
    }


    
    @Override
    public String toString() {
	return "FrameMstDTO [id=" + id + ", trollyNo=" + trollyNo + "]";
    }

    

   

}



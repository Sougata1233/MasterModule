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
@Table(name = "FRAMEMST")
public class FrameMst implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "FRAMEID", nullable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "FRAMEMST_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FRAMENO", nullable = true)
    private Long frameNo;

    @Column(name = "SIDE", nullable = true)
    private String side;
    
    @Column(name = "TROLLYNO", nullable = true)
    private Long trollyNo;
    
    @Column(name = "FRAME_TYPE", nullable = true)
    private String frameType;
    
    @Column(name = "SPINDLE_QTY_TYPE", nullable = true)
    private String spindleQtyTyp;
    
   
    @Column(name = "BOBBIN_WEIGHT", nullable = true)
    private Long bobbinWeight;
    
    @Column(name = "MC_NUM", nullable = true)
    private String mcNum;
    
    @Column(name = "FRAME_VVFD", nullable = true)
    private String frameVvfd;
    
    public FrameMst() {
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
	return "FrameMst [id=" + id + ", trollyNo=" + trollyNo + "]";
    }

    

   

}


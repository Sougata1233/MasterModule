

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
@Table(name = "SELECTION_QUALITY_MST")
public class SelectionQualityMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "REC_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "SELECTION_QUALITY_MST_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "QUALITY")
    private String quality;

   
    public SelectionQualityMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getquality() {
	return quality;
    }

    public void setquality(String quality) {
	this.quality = quality;
    }

    
    @Override
    public String toString() {
	return "SelectionQualityMaster [id=" + id + ", quality=" + quality + "]";
    }

    

   

}



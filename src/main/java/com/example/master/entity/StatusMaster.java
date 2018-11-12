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
@Table(name = "STATUS_MASTER")
public class StatusMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "STATUS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "STATUS_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "STATUS_NAME")
    private String statusName;

    public StatusMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getstatusName() {
	return statusName;
    }

    public void setstatusName(String statusName) {
	this.statusName = statusName;
    }

    
    @Override
    public String toString() {
	return "StatusMaster[id=" + id + ", statusName=" + statusName + "]";
    }

}


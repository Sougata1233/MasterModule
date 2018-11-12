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
@Table(name = "SCM_INDENT_TYPE_MASTER")
public class ScmIndentTypeMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "INDENT_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "SCM_INDENT_TYPE_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "INDENT_TYPE_CODE")
    private String indentTypeCode;

    @Column(name = "INDENT_TYPE_DESC")
    private String indentTypeDsc;
    
    
    public ScmIndentTypeMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getindentTypeCode() {
	return indentTypeCode;
    }

    public void setindentTypeCode(String indentTypeCode) {
	this.indentTypeCode = indentTypeCode;
    }

    public String getindentTypeDsc() {
	return indentTypeDsc;
    }

    public void setindentTypeDsc(String indentTypeDsc) {
	this.indentTypeDsc = indentTypeDsc;
    }

   
    
    @Override
    public String toString() {
	return "ScmIndentTypeMaster [id=" + id + ", indentTypeCode=" + indentTypeCode + ", indentTypeDsc=" + indentTypeDsc + "]";
    }

    

   

}


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
@Table(name = "CODEMASTER")
public class Codemaster implements Serializable {
	
	@Id() 
    @Column(name = "CODE")
    private String code;
	
	@Column(name = "CODE_TYPE")
    private String codeType;

	@Column(name = "CODE_DESC")
    private String codeDsc;
    

    public Codemaster() {
	super();
    }

    
    public String getCodeType() {
	return codeType;
    }

    public void setCodeType(String codeType) {
	this.codeType = codeType;
    }

    
    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getcodeDsc() {
	return codeDsc;
    }

    public void setcodeDsc(String codeDsc) {
	this.codeDsc = codeDsc;
    }

   
    
    @Override
    public String toString() {
	return "Codemaster [codeType=" + codeType + ", code=" + code + ", codeDsc=" + codeDsc + "]";
    }

    

   

}


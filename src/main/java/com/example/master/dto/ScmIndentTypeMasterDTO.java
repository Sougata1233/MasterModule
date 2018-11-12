package com.example.master.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


public class ScmIndentTypeMasterDTO {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String indentTypeCode;

    private String indentTypeDsc;
    
    
    
    
    
    public ScmIndentTypeMasterDTO() {
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
	return "ScmIndentTypeMasterDTO [id=" + id + ", indentTypeCode=" + indentTypeCode + ", indentTypeDsc=" + indentTypeDsc + "]";
    }

    

   

}

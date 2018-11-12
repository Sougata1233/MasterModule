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

public class CodemasterDTO {
    
	private String codeType;

	private String code;
    
    private String codeDsc;
       
    
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

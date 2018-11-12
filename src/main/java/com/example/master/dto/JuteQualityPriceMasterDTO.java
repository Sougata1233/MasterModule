package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class JuteQualityPriceMasterDTO {

	    private Long id;
	   
	    private String itemCode;

	    private String juteQuality;
	    
	    private Long rate;
	    
	    private String currency;

    
    
    public JuteQualityPriceMasterDTO() {
	super();
    }

    public Long getId() {
    	return id;
        }

        public void setId(Long id) {
    	this.id = id;
        }
        
       
        public String getitemCode() {
        	return itemCode;
        }

        public void setitemCode(String itemCode) {
        	this.itemCode = itemCode;
        }
       
        
        public String getjuteQuality() {
        	return juteQuality;
        }

        public void setjuteQuality(String juteQuality) {
        	this.juteQuality = juteQuality;
        }

        public Long getrate() {
        	return rate;
        }

        public void setrate(Long rate) {
        	this.rate = rate;
        }

        public String getcurrency() {
        	return currency;
        }

        public void setcurrency(String currency) {
        	this.currency = currency;
        }

        
        @Override
        public String toString() {
    	return "JuteQualityPriceMaster [id="+id+", itemCode=" + itemCode +  ",juteQuality="+juteQuality+",rate="+rate+",currency="+currency+"]";
        }

        
  

  

}

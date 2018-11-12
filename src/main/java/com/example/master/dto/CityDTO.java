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

import com.example.master.entity.State;

public class CityDTO {
		
		private Long id;

	    private StateDTO state;
	
	    private Long stateId;
	    
	    private String cityName;
    
    
    public CityDTO() {
	super();
    }

    public Long getId() {
    	return id;
    }

   public void setId(Long id) {
    	this.id = id;
   }
   
   public StateDTO getState() {
       return state;
   }

   public void setState(StateDTO state) {
       this.state = state;
   }
    	
  
   public Long getstateId() {
   	return stateId;
       }

       public void setstateId(Long stateId) {
   	        this.stateId = stateId;
       }

        

        public String getcityName() {
    	return cityName;
        }

        public void setcityName(String cityName) {
    	this.cityName = cityName;
        }

        
        @Override
        public String toString() {
    	return "State [id=" + id + ",stateId=" +stateId+ ", cityName=" + cityName +  "]";
        }

  

  

}

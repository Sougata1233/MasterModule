package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.Country;



public class StateDTO {

    private long id;
    private CountryDTO country;
	private List<CityDTO> cities;
    private long countryId;
    private String stateName;
    
    
    public StateDTO() {
	super();
    }

    public long getId() {
    	return id;
        }

        public void setId(long id) {
    	this.id = id;
        }
        
        
        public long getcountryId() {
        	return countryId;
            }
        
        public CountryDTO getCountry() {
            return country;
        }

        public void setCountry(CountryDTO country) {
            this.country = country;
        }
        
        
        
        public List<CityDTO> getCity() {
            return cities;
        }

        public void setCity(List<CityDTO> cities) {
            this.cities = cities;
        }
        

            public void setcountryId(long countryId) {
        	this.countryId = countryId;
            }
    	/*
        public CountryDTO getCountry() {
          return  country;
        }
        public void setCountry(CountryDTO country) {
            this.country = country;
        }
*/
       

        public String getstateName() {
    	return stateName;
        }

        public void setstateName(String stateName) {
    	this.stateName = stateName;
        }

        
        @Override
        public String toString() {
        	return "State [id=" + id + ",cities=" + cities + ",countryId=" + countryId + ", stateName=" + stateName +  "]";
        }
  

  

}

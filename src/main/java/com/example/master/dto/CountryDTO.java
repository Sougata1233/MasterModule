package com.example.master.dto;


import javax.persistence.CascadeType;




import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class CountryDTO {
	
	private long id;
	
	private List<StateDTO> states;
    
    private String countryName;
    
    
    public CountryDTO() {
	super();
    }

    public long getId() {
    	return id;
        }

        public void setId(long id) {
    	this.id = id;
        }
        
       public List<StateDTO> getState() {
            return states;
        }

        public void setState(List<StateDTO> states) {
            this.states = states;
        }
        
        
    
   /* public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }*/

        public String getcountryName() {
    	return countryName;
        }

        public void setcountryName(String countryName) {
    	this.countryName = countryName;
        }

        
        @Override
        public String toString() {
    	return "Country [ states="+states+",countryName=" + countryName +", id="+id+"]";
        }

  

  

}

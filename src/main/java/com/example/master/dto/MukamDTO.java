package com.example.master.dto;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.ItemMaster;

public class MukamDTO implements Serializable {
	
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String mukamName;
    
    private String isMapped;
    
    
    
   

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}


	private List<JuteTypeDTO> itemJuteCode;
    
    

	public List<JuteTypeDTO> getItemJuteCode() {
		return itemJuteCode;
	}

	public void setItemJuteCode(List<JuteTypeDTO> itemJuteCode) {
		this.itemJuteCode = itemJuteCode;
	}

	public MukamDTO() {
	super();
    }
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getmukamName() {
	return mukamName;
    }

    public void setmukamName(String mukamName) {
    	this.mukamName = mukamName;
    }

    
    @Override
    public String toString() {
	return "MukamDTO[id=" + id + ", mukamName=" + mukamName + "]";
    }

    

   

}


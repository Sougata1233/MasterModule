package com.example.master.dto;


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

import com.example.master.entity.MenuMaster;

public class SubmenuMasterDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long menuId;

    private MenuMasterDTO menumaster;
   
    private String subMenu;

    private String modBy;
    
    private Date modOn;
    
    public SubmenuMasterDTO() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    public MenuMasterDTO getMenuMaster() {
        return menumaster;
    }

    public void setMenuMaster(MenuMasterDTO menumaster) {
        this.menumaster = menumaster;
    }

    public Long getmenuId() {
	return menuId;
    }

    public void setmenuId(Long menuId) {
	this.menuId = menuId;
    }

    public String getsubMenu() {
    	return subMenu;
    }

    public void setsubMenu(String subMenu) {
    	this.subMenu = subMenu;
    }
    
    public String getmodBy() {
    	return modBy;
    }

    public void setmodBy(String modBy) {
    	this.modBy = modBy;
    }
    
    public Date getmodOn() {
    	return  modOn;
    }

    public void setmodOn(Date modOn) {
    	this.modOn = modOn;
    }
   
    
    @Override
    public String toString() {
	return "SubmenuMasterDTO[id=" + id + ", menuId=" + menuId + "]";
    }

    

   

}


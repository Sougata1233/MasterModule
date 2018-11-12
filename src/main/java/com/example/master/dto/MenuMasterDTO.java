package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.SubmenuMaster;

public class MenuMasterDTO {

    private Long id;
	
    private List<SubmenuMasterDTO> submenumaster;

    private String menu;

    private String modby;

    private Date modifiedOn;
    
    private String menuiconName;
    
    
    public MenuMasterDTO() {
	super();
    }

    public Long getId() {
   	 return id;
       }

       public void setId(Long id) {
   	this.id = id;
       }
       
       
       public List<SubmenuMasterDTO> getSubmenuMaster() {
           return submenumaster;
       }

       public void setSubmenuMaster(List<SubmenuMasterDTO> submenumaster) {
           this.submenumaster = submenumaster;
       }

       public String getmenu() {
   	  return menu;
       }

       public void setmenu(String menu) {
   	this.menu = menu;
       }

       
       public String getmodby() {
   	return modby;
       }

       public void setmodby(String modby) {
   	this.modby = modby;
       }

       public Date getmodifiedOn() {
   	return modifiedOn;
       }

       public void setmodifiedOn(Date modifiedOn) {
   	this.modifiedOn = modifiedOn;
       }
       
       public String getmenuIconName() {
       	return menuiconName;
           }

           public void setmenuIconName(String menuiconName) {
       	this.menuiconName = menuiconName;
           }

       
       @Override
       public String toString() {
   	return "Menu [id=" + id + ", menu=" + menu + ",  modby=" + modby + ", modifiedOn=" + modifiedOn + ",menuiconName="+ menuiconName +"]";
       }

       
       

}

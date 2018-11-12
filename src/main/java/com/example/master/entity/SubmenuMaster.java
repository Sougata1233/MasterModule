package com.example.master.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SUBMENU_MASTER")
public class SubmenuMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "SUB_MENU_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "SUBMENU_MASTER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_ID",insertable = false, updatable = false)
    private MenuMaster menumaster;
   
    @Column(name = "SUB_MENU")
    private String subMenu;

    
    @Column(name = "MOD_BY")
    private String modBy;
    
    
    @Column(name = "MOD_ON")
    private Date modOn;
    
    public SubmenuMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    
    public MenuMaster getMenuMaster() {
        return menumaster;
    }

    public void setMenuMaster(MenuMaster menumaster) {
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
	return "SubmenuMaster[id=" + id + ", menuId=" + menuId + "]";
    }

    

   

}


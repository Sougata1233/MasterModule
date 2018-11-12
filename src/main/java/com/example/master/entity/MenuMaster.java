package com.example.master.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_MASTER")
public class MenuMaster implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "MENU_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "MENU_MASTER_SEQ", allocationSize = 1)
    private Long id;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_ID",insertable = false, updatable = false)
    private List<SubmenuMaster> submenumaster;

    @Column(name = "MENU")
    private String menu;

    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @Column(name = "MENU_ICON_NAME")
    private String menuIconName;
 
   
    public MenuMaster() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    
    public List<SubmenuMaster> getSubmenuMaster() {
        return submenumaster;
    }

    public void setState(List<SubmenuMaster> submenumaster) {
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
    	return menuIconName;
        }

        public void setmenuIconName(String menuIconName) {
    	this.menuIconName = menuIconName;
        }

    
    @Override
    public String toString() {
	return "Activity [id=" + id + ", menuIconName=" + menuIconName + "]";
    }

    

   

}


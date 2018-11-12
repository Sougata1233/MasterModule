package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity()
@Table(name="MUKAM_SUPPLIER_MAP")
public class MukamSupplier {	
	
	@Id
	@Column(name="MAPPING_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MUKAM_SUPP_MAP_SEQ")
	@SequenceGenerator(name="MUKAM_SUPP_MAP_SEQ", sequenceName="MUKAM_SUPP_MAP_SEQ")
	private  long id;
	
	@Column(name="MUKAM_ID")
	private  long mukamId;
	
	@Column(name="SUPP_CODE")
	private  String supplierName ;
	
	@Column(name="IS_MAPPED")
	private String isMapped;
	
	

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMukamId() {
		return mukamId;
	}

	public void setMukamId(long mukamId) {
		this.mukamId = mukamId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

}

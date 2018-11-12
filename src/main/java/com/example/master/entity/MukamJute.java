package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name="MUKAM_JUTE_MAP")
public class MukamJute {	
	
	@Id
	@Column(name="MAPPING_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MUKAM_JUTE_MAP_SEQ")
	@SequenceGenerator(name="MUKAM_JUTE_MAP_SEQ", sequenceName="MUKAM_JUTE_MAP_SEQ")
	private  long id;
	
	@Column(name="MUKAM_ID")
	private  long mukamId;
	
	@Column(name="ITEM_CODE_JUTE")
	private  String ItemJuteCode;
	
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

	public void setMukamId(long string) {
		this.mukamId = string;
	}

	public String getItemJuteCode() {
		return ItemJuteCode;
	}

	public void setItemJuteCode(String itemJuteCode) {
		ItemJuteCode = itemJuteCode;
	}

	

}

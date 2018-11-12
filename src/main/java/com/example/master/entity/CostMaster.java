package com.example.master.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COSTMASTER")
public class CostMaster {
	
	@Id
	@Column(name="COST_CODE")
	private String costCode;
	
	@Column(name="DEPT_CODE")
	private String deptCode;
	
	@Column(name="COST_DESC")
	private String costDesc;
	
	@Column(name="MODBY")
	private String modBy;
	
	@Column(name="MODON")
	private Date modOn;

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}
}

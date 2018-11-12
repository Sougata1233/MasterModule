package com.example.master.dto;

public class DepartmentMapDTO {
	
	private long id;
	private String deptName;
	private String isMapped;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getIsMapped() {
		return isMapped;
	}
	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}
	public DepartmentMapDTO(long id, String deptName, String isMapped) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.isMapped = isMapped;
	}
	public DepartmentMapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DepartmentMapDTO [id=" + id + ", deptName=" + deptName + ", isMapped=" + isMapped + "]";
	}
	
	
	
	

}

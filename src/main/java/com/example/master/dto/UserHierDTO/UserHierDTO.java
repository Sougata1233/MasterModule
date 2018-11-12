package com.example.master.dto.UserHierDTO;

import java.sql.Date;

import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.DesignationDTO;
import com.example.master.dto.OrganizationDTO;

/*
 * DTO Class For User Hierarchy
 */
public class UserHierDTO {

	private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String alternateEmail;
    private Long mobile;
    private OrganizationDTO organization;
    private DepartmentDTO department;
    private DesignationDTO designation;
    private String typeOfEmployment;
    private byte[] userImg;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public OrganizationDTO getOrganization() {
		return organization;
	}
	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public DesignationDTO getDesignation() {
		return designation;
	}
	public void setDesignation(DesignationDTO designation) {
		this.designation = designation;
	}
	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}
	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}
	public byte[] getUserImg() {
		return userImg;
	}
	public void setUserImg(byte[] userImg) {
		this.userImg = userImg;
	}
}

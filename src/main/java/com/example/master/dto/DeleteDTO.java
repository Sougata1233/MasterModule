package com.example.master.dto;

import java.sql.Date;
import java.util.Arrays;
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

public class DeleteDTO {

   
    private int status;

    private int statusCode;
    
    private String msg;

    
    public DeleteDTO() {
	super();
    }

   
    public int getstatus() {
	return status;
    }

    public void setstatus(int status) {
	this.status = status;
    }

    public int getstatusCode() {
	  return statusCode;
    }

    public void setstatusCode(int statusCode) {
	  this.statusCode = statusCode;
    }
   
    
    public String getmsg() {
  	  return msg;
    }

     public void setmsg(String msg) {
  	  this.msg = msg;
    }
   
    
    @Override
    public String toString() {
	return "DeleteDTO [status=" + status + "]";
    }

  

  

}

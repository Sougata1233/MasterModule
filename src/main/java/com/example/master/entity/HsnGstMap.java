package com.example.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SCM_HSN_GST_MAP")
public class HsnGstMap {

	@Id
	@Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
//    @SequenceGenerator(name = "sequence", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1)
    private Long id;
	
	@Column(name="HSN_CODE")
	private String hsnCode;
	
	@Column(name="GST")
	private Long gst;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Long getGst() {
		return gst;
	}

	public void setGst(Long gst) {
		this.gst = gst;
	}
}

package com.example.master.dto;

public class MukamSuppMapDTO {
	
	private Long id;

    private String mukamName;
    
    private String isMapped;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMukamName() {
		return mukamName;
	}

	public void setMukamName(String mukamName) {
		this.mukamName = mukamName;
	}

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}

	public MukamSuppMapDTO(Long id, String mukamName, String isMapped) {
		super();
		this.id = id;
		this.mukamName = mukamName;
		this.isMapped = isMapped;
	}

	public MukamSuppMapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MukamSuppMapDTO [id=" + id + ", mukamName=" + mukamName + ", isMapped=" + isMapped + "]";
	}
    
    

}

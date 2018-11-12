package com.example.master.dto;

import java.util.List;

import com.example.master.entity.Mukam;
import com.example.master.entity.SupplierMaster;

public class SupplierNewDTO {

	private List<NewSupplierDTO> supplier;
	private List<Mukam> supplierMukam;
	
	public List<NewSupplierDTO> getSupplier() {
		return supplier;
	}
	public void setSupplier(List<NewSupplierDTO> supplier) {
		this.supplier = supplier;
	}
	public List<Mukam> getSupplierMukam() {
		return supplierMukam;
	}
	public void setSupplierMukam(List<Mukam> supplierMukam) {
		this.supplierMukam = supplierMukam;
	}
}

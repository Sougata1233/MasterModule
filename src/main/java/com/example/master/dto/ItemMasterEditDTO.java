package com.example.master.dto;

import java.sql.Date;
import java.util.List;

import com.example.master.entity.UomMaster;

public class ItemMasterEditDTO {

	 	private String id;

	    private String grpCode; 

		 private String itemDsc;

		 private List<UomMaster> uom;
		 
		 private String uomCode;
	    
	    private double centralStock;
	    
	    private String directIndirectTag;
	    
	    private String activeFlag;
	    
	    private String make;
	    
	    private String hsnCode;
	    
	    private String modBy;
	    
	    private Date modOn;
	    
	    private double threshold;
	    
	    private String legacyItemCode;
	    
	    private double max;
	    
	    private double maxOrderValue;
	    
	    private double centralStockValue;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getGrpCode() {
			return grpCode;
		}

		public void setGrpCode(String grpCode) {
			this.grpCode = grpCode;
		}

		public String getItemDsc() {
			return itemDsc;
		}

		public void setItemDsc(String itemDsc) {
			this.itemDsc = itemDsc;
		}

		public String getUomCode() {
			return uomCode;
		}

		public void setUomCode(String uomCode) {
			this.uomCode = uomCode;
		}

		public double getCentralStock() {
			return centralStock;
		}

		public void setCentralStock(double centralStock) {
			this.centralStock = centralStock;
		}

		public String getDirectIndirectTag() {
			return directIndirectTag;
		}

		public void setDirectIndirectTag(String directIndirectTag) {
			this.directIndirectTag = directIndirectTag;
		}

		public String getActiveFlag() {
			return activeFlag;
		}

		public void setActiveFlag(String activeFlag) {
			this.activeFlag = activeFlag;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getHsnCode() {
			return hsnCode;
		}

		public void setHsnCode(String hsnCode) {
			this.hsnCode = hsnCode;
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

		public double getThreshold() {
			return threshold;
		}

		public void setThreshold(double threshold) {
			this.threshold = threshold;
		}

		public String getLegacyItemCode() {
			return legacyItemCode;
		}

		public void setLegacyItemCode(String legacyItemCode) {
			this.legacyItemCode = legacyItemCode;
		}

		public double getMax() {
			return max;
		}

		public void setMax(double max) {
			this.max = max;
		}

		public double getMaxOrderValue() {
			return maxOrderValue;
		}

		public void setMaxOrderValue(double maxOrderValue) {
			this.maxOrderValue = maxOrderValue;
		}

		public double getCentralStockValue() {
			return centralStockValue;
		}

		public void setCentralStockValue(double centralStockValue) {
			this.centralStockValue = centralStockValue;
		}

		public List<UomMaster> getUom() {
			return uom;
		}

		public void setUom(List<UomMaster> uom) {
			this.uom = uom;
		}
	    
	    
	
}

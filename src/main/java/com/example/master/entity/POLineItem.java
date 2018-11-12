package com.example.master.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()

@Table(name="SCM_PO_LINE_ITEM")
public class POLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PO_ITM_SEQ")
    @SequenceGenerator(sequenceName = "SCM_PO_ITEM_SEQ", allocationSize = 1, name = "PO_ITM_SEQ")
	
	@Column(name="LINE_ITEM_NUM")
	private  long id;
	
	@Column(name="PO_NUM")
	private  String poId;
	
	@Column(name="INDENT_NO")
	private  String indentId;
	
	@Column(name="INDENT_TYPE")
	private  String type ;
	
	@Column(name="STATUS")
	private  String status ;
	
	@Column(name="GROUP_CODE")
	private  String itemGroupId;
	
	@Column(name="ITEM_CODE")
	private  String itemId;
	
	@Column(name="UOM")
	private  String unitId;
		
	@Column(name="QUANTITY")
	private float quantity;
	
	@Column(name="ACTUAL_QUANTITY")
	private float actualQuantity;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private  String approverFirst ;
	
	@Column(name="QUALITY")
	private  long qualityCode;
	
	@Column(name="MARKA")
	private  String marka;
	
	@Column(name="RATE")
	private float rate;
	
	@Column(name="ALLOWABLE_MOISTURE_PERCENTAGE")
	private float allowableMoisturePercentage;
	
	@Column(name="TAX_APPLIED")
	private float tax;
	
	@Column(name="VALUE_WT_TAX")
	private float valueWithTax;
	
	@Column(name="VALUE_WO_TAX")
	private float valueWithoutTax;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private  String approverSecond ;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private  Date approveFirstDate ;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private  Date approveSecondDate ;
	
	@Column(name="DISCOUNT")
	private  float discount ;
	
	@Column(name="ITEM_DESC")
	private String itemDesc;
	
	@Column(name="BALE")
	private long bale;
	
	@Column(name="LOOSE")
	private long loose;
	
	
	
	
	public long getBale() {
		return bale;
	}
	public void setBale(long bale) {
		this.bale = bale;
	}
	public long getLoose() {
		return loose;
	}
	public void setLoose(long loose) {
		this.loose = loose;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getIndentId() {
		return indentId;
	}
	public void setIndentId(String indentId) {
		this.indentId = indentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItemGroupId() {
		return itemGroupId;
	}
	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getActualQuantity() {
		return actualQuantity;
	}
	public void setActualQuantity(float actualQuantity) {
		this.actualQuantity = actualQuantity;
	}
	
	public String getApproverFirst() {
		return approverFirst;
	}
	public void setApproverFirst(String approverFirst) {
		this.approverFirst = approverFirst;
	}
	
	
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getValueWithTax() {
		return valueWithTax;
	}
	public void setValueWithTax(float valueWithTax) {
		this.valueWithTax = valueWithTax;
	}
	public float getValueWithoutTax() {
		return valueWithoutTax;
	}
	public void setValueWithoutTax(float valueWithoutTax) {
		this.valueWithoutTax = valueWithoutTax;
	}
	public String getApproverSecond() {
		return approverSecond;
	}
	public void setApproverSecond(String approverSecond) {
		this.approverSecond = approverSecond;
	}
	public Date getApproveFirstDate() {
		return approveFirstDate;
	}
	public void setApproveFirstDate(Date approveFirstDate) {
		this.approveFirstDate = approveFirstDate;
	}
	public Date getApproveSecondDate() {
		return approveSecondDate;
	}
	public void setApproveSecondDate(Date approveSecondDate) {
		this.approveSecondDate = approveSecondDate;
	}
	public long getQualityCode() {
		return qualityCode;
	}
	public void setQualityCode(long qualityCode) {
		this.qualityCode = qualityCode;
	}	
	
	public float getAllowableMoisturePercentage() {
		return allowableMoisturePercentage;
	}
	public void setAllowableMoisturePercentage(float allowableMoisturePercentage) {
		this.allowableMoisturePercentage = allowableMoisturePercentage;
	}
	


	

	

}

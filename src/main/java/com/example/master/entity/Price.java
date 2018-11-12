package com.example.master.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.dto.PriceGroupDTO;


@Entity
@Table(name="PRICE_MASTER")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRICE_ID_SEQ")
	@SequenceGenerator(name="PRICE_ID_SEQ", sequenceName="PRICE_ID_SEQ")
	@Column(name="PRICE_ID")
	private long priceId;
	
//	@OneToOne
//	@JoinColumn(name="ITEM_GROUP_CODE",insertable = false, updatable = false)
//	private PriceGroupDTO itemGrpCode;
	
	@Column(name="ITEM_GROUP_CODE")
	private String  itemGroupCode;
	
//	@OneToOne
//	@JoinColumn(name="ITEM_CODE",insertable = false, updatable = false)
//	private ItemMaster itmCode;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	

	@Column(name="RATE")
	private long rate;
	
	@Column(name="RECEIVED_DATE")
	private Date recievedDate;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;
	
	@Column(name="RECEIVED_QTY")
	private long receivedQty;

	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	/*public PriceGroupDTO getItemGrpCode() {
		return itemGrpCode;
	}

	public void setItemGrpCode(PriceGroupDTO groupprice) {
		this.itemGrpCode = groupprice;
	}*/

	public String getItemGroupCode() {
		return itemGroupCode;
	}

	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}

	/*public ItemMaster getItmCode() {
		return itmCode;
	}

	public void setItmCode(ItemMaster itmCode) {
		this.itmCode = itmCode;
	}*/

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public Date getRecievedDate() {
		return recievedDate;
	}

	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
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

	public long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public Price(long priceId, PriceGroupDTO itemGrpCode, String itemGroupCode, ItemMaster itmCode, String itemCode,
			long rate, Date recievedDate, String modBy, Date modOn, long receivedQty) {
		super();
		this.priceId = priceId;
//		this.itemGrpCode = itemGrpCode;
		this.itemGroupCode = itemGroupCode;
//		this.itmCode = itmCode;
		this.itemCode = itemCode;
		this.rate = rate;
		this.recievedDate = recievedDate;
		this.modBy = modBy;
		this.modOn = modOn;
		this.receivedQty = receivedQty;
	}

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", itemGroupCode=" + itemGroupCode + ", itemCode=" + itemCode + ", rate="
				+ rate + ", recievedDate=" + recievedDate + ", modBy=" + modBy + ", modOn=" + modOn + ", receivedQty="
				+ receivedQty + "]";
	}

	
	
	
	
	

}

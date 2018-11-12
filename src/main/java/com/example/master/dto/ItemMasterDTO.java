package com.example.master.dto;

import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.master.entity.ItemGroupMaster;

public class ItemMasterDTO {

    private String id;

    private String grpCode; 
	
//	 private ItemGroupMasterDTO itemgroupmaster;

	 private String itemDsc;
    
//	 private String location;

	 private String uomCode;
    
//    private String uomPur;
    
//    private Long multiFact;
    
//    private Long srRate;
    
    private double centralStock;
    
    private String directIndirectTag;
    
//    private String splItemTag;
    
//    private String issuableTag;
    
//    private String user1;
    
//    private Date date1;
    
//    private String user2;
    
//    private Date date2;
    
//    private String user3;
    
//    private Date date3;
    
//    private String user4;
    
//    private Date date4;
    
    private String activeFlag;
    
//    private String dtlItemDsc1;
    
//    private String dtlItemDsc2;
    
    private String make;
    
//    private Blob itemPhoto;
    
    private String hsnCode;
    
    private String modBy;
    
    private Date modOn;
    
    private double threshold;
    
//    private Long deptId;
    
    private String legacyItemCode;
    
//    private String isMapped;
    
    private double max;
    
    private double maxOrderValue;
    
    private double centralStockValue;
    
    
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

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
    
//    public String getIsMapped() {
//		return isMapped;
//	}
//
//	public void setIsMapped(String isMapped) {
//		this.isMapped = isMapped;
//	}

	public ItemMasterDTO() {
	super();
    }

    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }
    	
   
    /*public ItemGroupMasterDTO getItemGroupMaster() {
        return itemgroupmaster;
    }

    public void setItemGroupMaster(ItemGroupMasterDTO itemgroupmaster) {
        this.itemgroupmaster = itemgroupmaster;
    }*/
    
    public String getgrpCode() {
    	return grpCode;
    }

    public void setgrpCode(String grpCode) {
    	this.grpCode = grpCode;
    }


        public String getitemDsc() {
    	return itemDsc;
        }

        public void setitemDsc(String itemDsc) {
    	this.itemDsc = itemDsc;
        }
        
        
        /*public String getlocation() {
        	return location;
            }

            public void setlocation(String location) {
        	this.location = location;
            }
        */
        

            public String getuomCode() {
            	return uomCode;
            }

            public void setuomCode(String uomCode) {
            	this.uomCode = uomCode;
            } 
            
            
            /*public String getuomPur() {
            	return uomPur;
            }

            public void setuomPur(String uomPur) {
            	this.uomPur = uomPur;
            }
                
         
                
            public Long getmultiFact() {
            	return multiFact;
            }

            public void setmultiFact(Long multiFact) {
            	this.multiFact = multiFact;
            } 
            
           
            
            public Long getsrRate() {
            	return srRate;
            }

            public void setsrRate(Long srRate) {
            	this.srRate = srRate;
            } 
            */
           
            public double getcentralStock() {
            	return centralStock;
            }

            public void setcentralStock(double centralStock) {
            	this.centralStock =centralStock;
            }
            
            
            
            
            public String getdirectIndirectTag() {
            	return directIndirectTag;
            }

            public void setdirectIndirectTag(String directIndirectTag) {
            	this.directIndirectTag =directIndirectTag;
            }
            
            
            
            /*
            public String getsplItemTag() {
            	return splItemTag;
            }

            public void setsplItemTag(String splItemTag) {
            	this.splItemTag =splItemTag;
            }
            
            
           
            
            public String getissuableTag() {
            	return issuableTag;
            }

            public void setissuableTag(String issuableTag) {
            	this.issuableTag =issuableTag;
            }
            
            
            public String getuser1() {
            	return user1;
            }

            public void setuser1(String user1) {
            	this.user1 =user1;
            }
            
            
            public Date getdate1() {
            	return date1;
            }

            public void setdate1(Date date1) {
            	this.date1 =date1;
            }
            
            
            public String getuser2() {
            	return user2;
            }

            public void setuser2(String user2) {
            	this.user2 =user2;
            }
            
            
            public Date getdate2() {
            	return date2;
            }

            public void setdate2(Date date2) {
            	this.date2 =date2;
            }
            
            
            public String getuser3() {
            	return user3;
            }

            public void setuser3(String user3) {
            	this.user3 =user3;
            }
            
            
            public Date getdate3() {
            	return date3;
            }

            public void setdate3(Date date3) {
            	this.date3 =date3;
            }
            
            
            public String getuser4() {
            	return user4;
            }

            public void setuser4(String user4) {
            	this.user4 =user4;
            }
            
            
            public Date getdate4() {
            	return date4;
            }

            public void setdate4(Date date4) {
            	this.date4 =date4;
            }
            */
           
            
            public String getactiveFlag() {
            	return activeFlag;
            }

            public void setactiveFlag(String activeFlag) {
            	this.activeFlag =activeFlag;
            }
            
            
           
            
           /* public String getdtlItemDsc1() {
            	return dtlItemDsc1;
            }

            public void setdtlItemDsc1(String dtlItemDsc1) {
            	this.dtlItemDsc1 =dtlItemDsc1;
            }*/
            
            
          
            
            
            /*public String getdtlItemDsc2() {
            	return dtlItemDsc2;
            }

            public void setdtlItemDsc2(String dtlItemDsc2) {
            	this.dtlItemDsc2 =dtlItemDsc2;
            }*/
            
            
           
            
            
            public String getmake() {
            	return make;
            }

            public void setmake(String make) {
            	this.make =make;
            }
            
            
           
            
            /*public Blob getitemPhoto() {
            	return itemPhoto;
            }

            public void setitemPhoto(Blob itemPhoto) {
            	this.itemPhoto =itemPhoto;
            }*/
            
            
            
           
            public String gethsnCode() {
            	return hsnCode;
            }

            public void sethsnCode(String hsnCode) {
            	this.hsnCode =hsnCode;
            }
            
            
            
          
            
            public String getmodBy() {
            	return modBy;
            }

            public void setmodBy(String modBy) {
            	this.modBy =modBy;
            }
            
            
            
            public Date getmodOn() {
            	return modOn;
            }

            public void setmodOn(Date modOn) {
            	this.modOn =modOn;
            }
            
            
           
            
            public double getthreshold() {
            	return threshold;
            }

            public void setthreshold(double threshold) {
            	this.threshold =threshold;
            }
            
            
            
            /*public Long getdeptId() {
            	return deptId;
            }

            public void setdeptId(Long deptId) {
            	this.deptId =deptId;
            }*/
            
           
            
            public String getlegacyItemCode() {
            	return legacyItemCode;
            }

            public void setlegacyItemCode(String legacyItemCode) {
            	this.legacyItemCode =legacyItemCode;
            }
            
        
        /*@Override
        public String toString() {
    	return "ItemMaster [id=" + id + ",itemDsc=" + itemDsc +  ",location="+location+"]";
        }*/

        


}

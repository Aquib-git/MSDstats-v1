package com.kng.pharm.pharmmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ITEM_MASTER",catalog="ECLINIC_KNG")
public class PharmItemMaster 
{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ITEM_ID")
		private String itemId;
		
		@Column(name="ITEM_NAME")
		private String itemName;
		
		@Column(name="ITEM_CODE")
		private String itemCode;
		
		@Column(name="ITEM_DESC")
		private int itemDesc;
		
		@Column(name="ITEM_UNIT")
		private String itemUnit;
		
		@Column(name="PACK_UNIT")
		private String packUnit;
		
		@Column(name="ACTIVE_STATUS")
		private String activeStatus;
		
		@Column(name="SALE_STATUS")
		private String saleStatus;
		
		@Column(name="MANUFACTURER_ID")
		private String manufacturerId;
		
		@Column(name="ITEM_TYPE")
		private String itemType;
		
		@Column(name="ITEMGROUP_ID")
		private int itemGroupId;
		
		@Column(name="GENERIC_NAME")
		private String genericName;
		
		@Column(name="MEDICINE_ID")
		private String medicineId;
		
		@Column(name="TRADE_NAME")
		private String tradeName;


}

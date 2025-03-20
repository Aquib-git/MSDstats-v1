package com.kng.brtrprts.brtrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.brtrprts.brtmodel.ItemFilterMaster;

public interface ItemFilterMasterRepo extends JpaRepository<ItemFilterMaster, Long>
{
	String sqlStmt="SELECT * \r\n"
			+ "FROM eclinic_kng.ITEM_MASTER im\r\n"
			+ "WHERE im.active_status='Y'\r\n"
			+ "ORDER BY im.ITEM_NAME ASC; ";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ItemFilterMaster> getItemFilterMaster();
	
	
	String sqlStmt2="SELECT DISTINCT(im.ITEM_ID),\r\n"
			+ "	   im.ITEM_NAME,\r\n"
			+ "		im.ITEM_CODE,\r\n"
			+ "		im.ITEM_DESC,\r\n"
			+ "		im.ITEM_UNIT,\r\n"
			+ "		im.PACK_UNIT,\r\n"
			+ "		im.ACTIVE_STATUS,\r\n"
			+ "		im.SALE_STATUS,\r\n"
			+ "		im.MANUFACTURER_ID,\r\n"
			+ "		im.ITEM_TYPE,\r\n"
			+ "		im.ITEMGROUP_ID,\r\n"
			+ "		im.GENERIC_NAME,\r\n"
			+ "		im.MEDICINE_ID,\r\n"
			+ "		im.TRADE_NAME\r\n"
			+ "FROM eclinic_kng.ITEM_MASTER im\r\n"
			+ "INNER JOIN ECLINIC_KNG.ITEM_STOCK ist\r\n"
			+ "on(im.ITEM_ID=ist.ITEM_ID)\r\n"
			+ "INNER JOIN ECLINIC_KNG.OFFICE_DETAILS od \r\n"
			+ "on(ist.OFFICE_ID=od.OFFICE_ID)\r\n"
			+ "WHERE \r\n"
			+ "	ist.OFFICE_ID =?\r\n"
			+ "AND\r\n"
			+ "	im.ACTIVE_STATUS='Y'\r\n"
			+ "AND \r\n"
			+ "	od.ACTIVE_STATUS='Y'\r\n"
			+ "GROUP BY \r\n"
			+ "	im.ITEM_ID,\r\n"
			+ "	im.ITEM_NAME,\r\n"
			+ "	im.ITEM_CODE,\r\n"
			+ "	im.ITEM_DESC,\r\n"
			+ "	im.ITEM_UNIT,\r\n"
			+ "	im.PACK_UNIT,\r\n"
			+ "	im.ACTIVE_STATUS,\r\n"
			+ "	im.SALE_STATUS,\r\n"
			+ "	im.MANUFACTURER_ID,\r\n"
			+ "	im.ITEM_TYPE,\r\n"
			+ "	im.ITEMGROUP_ID,\r\n"
			+ "	im.GENERIC_NAME,\r\n"
			+ "	im.MEDICINE_ID,\r\n"
			+ "	im.TRADE_NAME\r\n"
			+ "ORDER BY im.ITEM_NAME ASC";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ItemFilterMaster> getItemFilterMasterByOfficeId(int officeId);
	
	

}

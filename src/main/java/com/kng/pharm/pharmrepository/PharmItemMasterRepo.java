package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kng.pharm.pharmmodel.PharmItemMaster;

public interface PharmItemMasterRepo extends JpaRepository<PharmItemMaster, String> 
{
	String sqlStmt="SELECT * FROM ECLINIC_KNG.ITEM_MASTER im WHERE im.ACTIVE_STATUS LIKE 'Y' ORDER BY im.ITEM_NAME ASC ";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmItemMaster> getItemMasterList();

}

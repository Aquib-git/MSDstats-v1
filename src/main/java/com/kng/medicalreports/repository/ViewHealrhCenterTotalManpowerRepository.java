package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.kng.medicalreports.model.*;

@Repository
public interface ViewHealrhCenterTotalManpowerRepository extends JpaRepository<ViewHealrhCenterTotalManpower,Integer> {
	

}

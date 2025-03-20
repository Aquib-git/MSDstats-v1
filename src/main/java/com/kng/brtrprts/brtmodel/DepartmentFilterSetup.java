package com.kng.brtrprts.brtmodel;

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
@Table(name="DEPARTMENT_SETUP",catalog="ECLINIC_KNG")
public class DepartmentFilterSetup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="DEPTNAME_AR")
	private String departmentNameAR;
	
	@Column(name="DIFF_REGNO")
	private String diffRegno;
	
	@Column(name="DEPT_PREFIX")
	private String deptPrefix;
	
	@Column(name="ACTIVE_STATUS")
	private String activStatus;
	
	@Column(name="GROUP_ID")
	private String groupId;
	
	@Column(name="DEPT_TYPE")
	private String deptType;
	
	@Column(name="DEPT_CODE")
	private String deptCode;
	
}

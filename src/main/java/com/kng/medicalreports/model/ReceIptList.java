package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RECEIPT_LIST",catalog="ECLINIC")
public class ReceIptList implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="receipt_id")
	private int receipt_id;
	@Column(name="receipt_date")
	@Temporal(TemporalType.DATE)
	private Date receipt_date;
	
	
	
	
	
	public ReceIptList() {
		
	}


	public ReceIptList(int receipt_id, Date receipt_date) {
		super();
		this.receipt_id = receipt_id;
		this.receipt_date = receipt_date;
	}


	public int getReceipt_id() {
		return receipt_id;
	}


	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}


	public Date getReceipt_date() {
		return receipt_date;
	}


	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}


	@Override
	public int hashCode() {
		return Objects.hash(receipt_date, receipt_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceIptList other = (ReceIptList) obj;
		return Objects.equals(receipt_date, other.receipt_date) && receipt_id == other.receipt_id;
	}


	

	
	
	
	

}

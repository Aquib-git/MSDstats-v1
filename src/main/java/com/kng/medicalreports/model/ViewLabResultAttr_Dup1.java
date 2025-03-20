package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
//import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
/* @Data */
@Table(name="VIEW_LAB_RSLT_ATTR_FETCH_DUP1",catalog="ECLINIC")
public class ViewLabResultAttr_Dup1 implements Serializable {
	
	
	public ViewLabResultAttr_Dup1() {
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535350470101898162L;

	@Id
	@Column(name="row_num")
	private Integer row_num;
	

	

	@Column(name="CONSULT_ID")
	private int  CONSULT_ID;
	
	@Column(name="PARAMETER_ID")
	private Integer PARAMETER_ID;
	
	
	@Column(name="PARAM_MAPPING_NAME")
	private String PARAM_MAPPING_NAME;
	
	@Column(name="TEST_ID")
	private Integer TEST_ID;
	
	@Column(name="TEST_NAME")
	private String TEST_NAME;
	
	@Column(name="TEST_RESULT")
	private String TEST_RESULT;
	
	@Column(name="MIN_VALUE")
	private String MIN_VALUE;
	
	@Column(name="MAX_VALUE")
	private String MAX_VALUE;
	
	@Column(name="TEST_DETAILSID")
	private Integer TEST_DETAILSID;
	
	@Column(name="OP_NUMBER")
	private String OP_NUMBER;

	
	@Column(name="LAB_IDNO")
	private String LAB_IDNO;


	public Integer getRow_num() {
		return row_num;
	}


	public void setRow_num(Integer row_num) {
		this.row_num = row_num;
	}


	


	public int getCONSULT_ID() {
		return CONSULT_ID;
	}


	public void setCONSULT_ID(int cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}


	public Integer getPARAMETER_ID() {
		return PARAMETER_ID;
	}


	public void setPARAMETER_ID(Integer pARAMETER_ID) {
		PARAMETER_ID = pARAMETER_ID;
	}


	public String getPARAM_MAPPING_NAME() {
		return PARAM_MAPPING_NAME;
	}


	public void setPARAM_MAPPING_NAME(String pARAM_MAPPING_NAME) {
		PARAM_MAPPING_NAME = pARAM_MAPPING_NAME;
	}


	

	public String getTEST_NAME() {
		return TEST_NAME;
	}


	public void setTEST_NAME(String tEST_NAME) {
		TEST_NAME = tEST_NAME;
	}


	public String getTEST_RESULT() {
		return TEST_RESULT;
	}


	public void setTEST_RESULT(String tEST_RESULT) {
		TEST_RESULT = tEST_RESULT;
	}




	public String getMIN_VALUE() {
		return MIN_VALUE;
	}


	public void setMIN_VALUE(String mIN_VALUE) {
		MIN_VALUE = mIN_VALUE;
	}


	public String getMAX_VALUE() {
		return MAX_VALUE;
	}


	public void setMAX_VALUE(String mAX_VALUE) {
		MAX_VALUE = mAX_VALUE;
	}


	public String getOP_NUMBER() {
		return OP_NUMBER;
	}


	public void setOP_NUMBER(String oP_NUMBER) {
		OP_NUMBER = oP_NUMBER;
	}





	
	

	/*
	 * @Column(name="CATEGORY_ID") private String CATEGORY_ID;
	 */
	

	//

	public Integer getTEST_ID() {
		return TEST_ID;
	}


	public void setTEST_ID(Integer tEST_ID) {
		TEST_ID = tEST_ID;
	}


	public Integer getTEST_DETAILSID() {
		return TEST_DETAILSID;
	}


	public void setTEST_DETAILSID(Integer tEST_DETAILSID) {
		TEST_DETAILSID = tEST_DETAILSID;
	}


	public String getLAB_IDNO() {
		return LAB_IDNO;
	}


	public void setLAB_IDNO(String lAB_IDNO) {
		LAB_IDNO = lAB_IDNO;
	}

	
	
	 @Transient
	    private String style;  // This field will be used to store the CSS style

	    // Getters and Setters
	    public String getStyle() {
	        return style;
	    }

	    public void setStyle(String style) {
	        this.style = style;
	    }
	    

	    // A method to calculate the style based on test results
	    public void calculateStyle() {
	        try {
	            float testResultFloat = Float.parseFloat(TEST_RESULT);
	            float minValueFloat = Float.parseFloat(MIN_VALUE);
	            float maxValueFloat = Float.parseFloat(MAX_VALUE);

	            if (testResultFloat > maxValueFloat) {
	                style = "color: red;";
	            } else if (testResultFloat < minValueFloat) {
	                style = "color: blue;";
	            } else {
	                style = "color: black;";
	            }
	       
	    }catch(Exception e) {}
	    }

	@Override
	public String toString() {
		return "ViewLabResultAttr_Dup1 [row_num=" + row_num + ", CONSULT_ID=" + CONSULT_ID + ", PARAMETER_ID="
				+ PARAMETER_ID + ", PARAM_MAPPING_NAME=" + PARAM_MAPPING_NAME + ", TEST_ID=" + TEST_ID + ", TEST_NAME="
				+ TEST_NAME + ", TEST_RESULT=" + TEST_RESULT + ", TEST_DETAILSID=" + TEST_DETAILSID + ", OP_NUMBER="
				+ OP_NUMBER + ", LAB_IDNO=" + LAB_IDNO + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_ID, LAB_IDNO, OP_NUMBER, PARAMETER_ID, PARAM_MAPPING_NAME, TEST_DETAILSID, TEST_ID,
				TEST_NAME, TEST_RESULT, row_num);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewLabResultAttr_Dup1 other = (ViewLabResultAttr_Dup1) obj;
		return Objects.equals(CONSULT_ID, other.CONSULT_ID) && Objects.equals(LAB_IDNO, other.LAB_IDNO)
				&& Objects.equals(OP_NUMBER, other.OP_NUMBER) && PARAMETER_ID == other.PARAMETER_ID
				&& Objects.equals(PARAM_MAPPING_NAME, other.PARAM_MAPPING_NAME)
				&& Objects.equals(TEST_DETAILSID, other.TEST_DETAILSID) && Objects.equals(TEST_ID, other.TEST_ID)
				&& Objects.equals(TEST_NAME, other.TEST_NAME) && Objects.equals(TEST_RESULT, other.TEST_RESULT)
				&& row_num == other.row_num;
	}
	

	
}


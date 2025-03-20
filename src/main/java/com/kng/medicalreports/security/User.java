package com.kng.medicalreports.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_USER",catalog="ECLINIC")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	

	@Column(name = "USER_NAME",nullable = false, unique = true, length = 200)
	private String userName;
	
	@Column(name = "PASSWORD",nullable = false, length = 300)
	private String password;
	
	@Column(name = "FULLNAME", nullable = false, length = 300)
	private String fullName;
	
	@Column(name = "KNG_ID", nullable = false, length = 20)
	private String kngId;
	
	@Column(name="CIVILID", nullable = false)
	private Long civilId;
	
	@Column(name="LOGIN_DATE")
	private Date loginDate;
	
	

	@ManyToMany(cascade  ={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinTable(
			   name="TB_USER_ROLE",
			   joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName="ID")},
			   inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")}
			   
			)
  private List<Role> roles;

	/**
	 * 
	 */
	
	public User() {
		
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getKngId() {
		return kngId;
	}

	public void setKngId(String kngId) {
		this.kngId = kngId;
	}

	public Long getCivilId() {
		return civilId;
	}

	public void setCivilId(Long civilId) {
		this.civilId = civilId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
	
	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", kngId=" + kngId + ", civilId=" + civilId + ", loginDate=" + loginDate + ", roles=" + roles + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(civilId, fullName, id, kngId, loginDate, password, roles, userName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(civilId, other.civilId) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(id, other.id) && Objects.equals(kngId, other.kngId)
				&& Objects.equals(loginDate, other.loginDate) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles) && Objects.equals(userName, other.userName);
	}





	
	
}

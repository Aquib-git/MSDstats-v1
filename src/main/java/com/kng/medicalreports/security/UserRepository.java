package com.kng.medicalreports.security;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	public User findByUserName(String userName);
	
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1 and u.kngId=?2 and u.civilId=?3")
	public User CheckUserExiting(String userName,String kngHo ,Long CivilID);


}


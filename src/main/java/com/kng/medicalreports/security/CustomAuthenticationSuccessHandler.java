
  package com.kng.medicalreports.security;
  
  import org.springframework.security.core.Authentication; import
  org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.web.authentication.AuthenticationSuccessHandler;
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse; import java.io.IOException; import
  java.util.Collection;
  
  public class CustomAuthenticationSuccessHandler implements
  AuthenticationSuccessHandler {
  
  @Override public void onAuthenticationSuccess(HttpServletRequest request,
  HttpServletResponse response, Authentication authentication) throws
  IOException { // 
	// Check user roles
	  Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

	  // Redirect based on role
	  if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_LAB"))) {
	      response.sendRedirect(request.getContextPath() +"/labChart");
	  } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER") 
	                                             || a.getAuthority().equals("ROLE_NUSER") 
	                                             || a.getAuthority().equals("ROLE_ADMIN"))) {
	      response.sendRedirect(request.getContextPath() +"/dailyStatistics");
	  } else {
	      // Default redirect if role doesn't match the above
	      response.sendRedirect(request.getContextPath() +"/");
	  }
  }
  }
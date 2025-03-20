package com.kng.medicalreports.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	  @Bean public CustomAuthenticationSuccessHandler
	  customAuthenticationSuccessHandler() { return new
	  CustomAuthenticationSuccessHandler(); }
	 
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/users").authenticated()
//			.anyRequest().permitAll()
//			.and()
//			.formLogin()
//				.usernameParameter("email")
//				.defaultSuccessUrl("/users")
//				.permitAll()
//			.and()
//			.logout().logoutSuccessUrl("/").permitAll();
//	}
	
	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()
	                .authorizeRequests()
	                
	                .antMatchers("/login", "/register","/process_register","/forgot-password",
	                		"/process_forgetPassword", "/css/**", "/js/**", "/images/**", "/webjars/**", "/favicon.ico").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .successHandler(new CustomAuthenticationSuccessHandler())
	                .loginPage("/login")
	                .loginProcessingUrl("/login")
	                .defaultSuccessUrl("/dailyStatistics?ofcId=4&lang=#", true)
	                .failureUrl("/login?error")
	                .and()
	                .logout().invalidateHttpSession(true)
	                .clearAuthentication(true)
	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/login?logout");
	        
	    }
	
	 @Override
	    public void configure(WebSecurity web) {
	        web
	                .ignoring()
	                .antMatchers("/static/**")
	                .antMatchers("/favicon.ico")
	                .antMatchers("/assets/**")
	                .antMatchers("/css/**")
	                .antMatchers("/img/**")
	                .antMatchers("/js**")
	                .antMatchers("/admin/**")
	                .antMatchers("/webjars/**")
	                .antMatchers("/templates/**");
	    }
	
	
}

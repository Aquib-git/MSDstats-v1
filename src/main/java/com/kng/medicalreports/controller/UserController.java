package com.kng.medicalreports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.kng.medicalreports.security.User;
import com.kng.medicalreports.security.UserRepository;

@Controller
public class UserController {
	
	
	@Autowired
	private UserRepository userRepo;
	

	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	
	@GetMapping("/forgot-password")
	public String showforgotPasswordForm(Model model) {
		model.addAttribute("user", new User());
		return "./forgot-password";
	}
	
	@PostMapping("/process_register")
	public RedirectView processRegister(@ModelAttribute("user") User user ,RedirectAttributes redir ) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		
		
		RedirectView redirectView= new RedirectView("/login" ,true); 
		redir.addFlashAttribute("message", "You successfully registered You can now login");
		return redirectView;
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
		
	}
	
	
	
	@PostMapping("/process_forgetPassword")
	public RedirectView processForgetPassword(@ModelAttribute("user") User user ,RedirectAttributes redir ) {
		
		User userExit=userRepo.CheckUserExiting(user.getUserName(),user.getKngId(),user.getCivilId());
		
		if(userExit !=null) {
			
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		userExit.setPassword(encodedPassword);
		
		userRepo.save(userExit);
		
		redir.addFlashAttribute("message", "You successfully  password changed");
		
		}else
			
		{
			redir.addFlashAttribute("message", "User not found");
		}
		
		RedirectView redirectView= new RedirectView("/forgot-password" ,true); 
		
		return redirectView;
	}
	
//	@GetMapping("/chnge-password")
//	public String showforgotPasswordForm(Model model) {
//		model.addAttribute("user", new User());
//		return "./forgot-password";
//	}

}

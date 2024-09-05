package com.scm.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class PageController {
    
	@GetMapping("/home")
	public String home(Model model) {
		String name ="Hrutik Sargar";
		// model.addAttribute("Name", name);
		
		// model.addAttribute("collegeName", "SB Patil college of engineering, baramati");
		// model.addAttribute("leetCodeLink", "https://leetcode.com/u/hrutiksargar/");
		System.out.println("HOme Page Handler");
		return "home";
	}


	// @RequestMapping("/run")
	// public void run(){
	// 	System.out.println("run method");
	// }

	@GetMapping("/about")
	public String aboutPage( Model model){
		// model.addAttribute("isLoggedIn", false);
		System.out.println("about Page");
		return "about";
	}

	@RequestMapping("/services")
	public String services(){
		System.out.println("services page loading");
		return "services";
	}

	@GetMapping("/contact")
	public String contact(){
		return "contact";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/signup")
	public String signup(){
		return "signup";
	}

}

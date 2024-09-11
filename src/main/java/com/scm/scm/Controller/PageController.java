package com.scm.scm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.scm.scm.Entities.User;
import com.scm.scm.forms.userForm;
import com.scm.scm.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class PageController {

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home(Model model) {
		String name = "Hrutik Sargar";
		// model.addAttribute("Name", name);

		// model.addAttribute("collegeName", "SB Patil college of engineering,
		// baramati");
		// model.addAttribute("leetCodeLink", "https://leetcode.com/u/hrutiksargar/");
		System.out.println("HOme Page Handler");
		return "home";
	}

	// @RequestMapping("/run")
	// public void run(){
	// System.out.println("run method");
	// }

	@GetMapping("/about")
	public String aboutPage(Model model) {
		// model.addAttribute("isLoggedIn", false);
		System.out.println("about Page");
		return "about";
	}

	@RequestMapping("/services")
	public String services() {
		System.out.println("services page loading");
		return "services";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {

		// to get the data we are sending userform class object in the model
		userForm userForm = new userForm();
		// userForm.setName("hrutik");
		// userForm.setPhoneNumber("9876543222");
		model.addAttribute("user", userForm);

		return "signup";
	}

	@RequestMapping(value = "/do-register", method = RequestMethod.POST)
	public String ProcessRegister(@ModelAttribute userForm userForm) {

		// CONVERTED USERFORM --> USER
		// USER CREATED FROM USERFORM
		// User user = User.builder()
		// .name(userForm.getName())
		// .email(userForm.getEmail())
		// .password(userForm.getPassword())
		// .phoneNumber(userForm.getPhoneNumber())
		// .about(userForm.getAbout())
		// .build();

		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setAbout(userForm.getAbout());
		// CALL SERVICE METHOD
		userService.saveUser(user);

		return "redirect:/app/signup";

		// System.out.println(userForm.toString());
		// System.out.println("regi process");
	}

}

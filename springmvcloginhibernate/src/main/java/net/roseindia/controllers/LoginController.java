package net.roseindia.controllers;

/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import net.roseindia.form.LoginForm;
import net.roseindia.model.Registrations;
import net.roseindia.service.*;

@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@Autowired
	public LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model) {
		if (result.hasErrors()) {
			return "loginform";
		}

		/*
		 * String userName = "UserName"; String password = "password"; loginForm
		 * = (LoginForm) model.get("loginForm"); if
		 * (!loginForm.getUserName().equals(userName) ||
		 * !loginForm.getPassword().equals(password)) { return "loginform"; }
		 */
		List isAdmin = null;
		boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword());
		if (userExists) {
			List<Registrations> list = loginService.isAdmin(loginForm.getUserName());
			if (list != null && list.size() > 0) {
				model.put("lists", list);
			}
			model.put("loginForm", loginForm);
			return "loginsuccess";
		} else {
			result.rejectValue("userName", "invaliduser");
			return "loginform";
		}

	}

}

package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserServiceJpaImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController 
{

    @Autowired
    private UserServiceJpaImpl userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
    	System.out.println("Recieved login post");
        if (bindingResult.hasErrors()) {
             notifyService.addErrorMessage("Please fill the form correctly!");
             return "users/login";
        }

        if (!userService.authenticate(        	
             loginForm.getUsername(), loginForm.getPassword())) {
        	System.out.println("Invalid login");
             notifyService.addErrorMessage("Invalid login!");
             return "users/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
    
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public String login(LoginForm loginForm) {
    	System.out.println("Recieved login get");
        return "users/login";
    }
}
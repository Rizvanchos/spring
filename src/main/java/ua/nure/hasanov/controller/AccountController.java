package ua.nure.hasanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.hasanov.entity.User;
import ua.nure.hasanov.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String account(@RequestParam String login, Model model) {
        model.addAttribute(userService.find(login));
        return "hello";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userService.register(user);

        return "registrationCongratulation";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

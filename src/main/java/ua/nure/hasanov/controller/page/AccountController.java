package ua.nure.hasanov.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.hasanov.controller.AbstractPageController;
import ua.nure.hasanov.controller.ControllerConstants;
import ua.nure.hasanov.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController extends AbstractPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String account(@RequestParam String login, Model model) {
        model.addAttribute(userService.find(login));
        return ControllerConstants.Views.Pages.HOMEPAGE;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

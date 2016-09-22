package ua.nure.hasanov.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.hasanov.controller.AbstractRegisterPageController;
import ua.nure.hasanov.controller.ControllerConstants;
import ua.nure.hasanov.entity.User;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractRegisterPageController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        getUserService().register(user);

        return ControllerConstants.Views.Pages.Account.REGISTRATION_CONGRATULATION;
    }
}

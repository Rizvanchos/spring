package ua.nure.hasanov.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.hasanov.controller.AbstractRegisterPageController;
import ua.nure.hasanov.controller.ControllerConstants;
import ua.nure.hasanov.form.RegisterForm;

@Controller
@RequestMapping("/registration")
public class RegistrationController extends AbstractRegisterPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String doRegister(Model model) {
        model.addAttribute(new RegisterForm());
        return getView();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterForm registerForm, BindingResult bindingResult, Model model) {
        getRegisterFormValidator().validate(registerForm, bindingResult);
        return processRegisterRequest(registerForm, bindingResult, model);
    }

    @Override
    protected String getView() {
        return ControllerConstants.Views.Pages.Account.Register.REGISTRATION;
    }

    @Override
    protected String getSuccessRedirect() {
        return ControllerConstants.Views.Pages.Account.Register.REGISTRATION_CONGRATULATION;
    }
}

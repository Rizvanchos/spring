package ua.nure.hasanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import ua.nure.hasanov.data.UserData;
import ua.nure.hasanov.facade.UserFacade;
import ua.nure.hasanov.form.RegisterForm;

public abstract class AbstractRegisterPageController extends AbstractPageController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private Validator registerFormValidator;

    protected UserFacade getUserFacade() {
        return userFacade;
    }

    protected Validator getRegisterFormValidator() {
        return registerFormValidator;
    }

    protected String processRegisterRequest(RegisterForm registerForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOG.error("Form contains errors!");
            model.addAttribute(registerForm);
            return handleRegistrationError(model);
        } else {
            UserData userData = new UserData();

            userData.setEmail(registerForm.getEmail());
            userData.setPassword(registerForm.getPassword());
            userData.setFirstName(registerForm.getFirstName());
            userData.setLastName(registerForm.getLastName());

            try {
                userFacade.register(userData);
            } catch (Exception ex) {
                LOG.error("Error during registration", ex);
                model.addAttribute(registerForm);
                return handleRegistrationError(model);
            }
        }

        return REDIRECT_PREFIX + getSuccessRedirect();
    }

    protected String handleRegistrationError(Model model) {
        return getView();
    }

    protected abstract String getSuccessRedirect();

}

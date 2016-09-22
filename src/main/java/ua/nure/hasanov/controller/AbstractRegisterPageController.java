package ua.nure.hasanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.hasanov.service.UserService;

public abstract class AbstractRegisterPageController extends AbstractPageController {

    @Autowired
    private UserService userService;

    protected UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

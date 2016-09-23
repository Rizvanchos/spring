package ua.nure.hasanov.facade.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.hasanov.data.UserData;
import ua.nure.hasanov.entity.User;
import ua.nure.hasanov.facade.UserFacade;
import ua.nure.hasanov.service.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public void register(UserData userData) {
        User user = new User();

        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());

        userService.register(user);
    }
}

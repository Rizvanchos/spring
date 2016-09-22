package ua.nure.hasanov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.hasanov.entity.User;
import ua.nure.hasanov.repository.UserRepository;
import ua.nure.hasanov.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User find(String login) {
        return userRepository.find(login);
    }

    @Transactional
    @Override
    public void register(User user) {
        userRepository.add(user);
        userRepository.commit();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

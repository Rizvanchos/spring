package ua.nure.hasanov.service;

import ua.nure.hasanov.entity.User;

public interface UserService extends Service<User> {
    User find(String login);

    void register(User user);
}

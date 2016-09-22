package ua.nure.hasanov.repository;

import ua.nure.hasanov.entity.User;

public interface UserRepository extends Repository<User> {
    User find(String login);
}

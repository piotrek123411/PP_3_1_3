package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();

    void save(User user);

    void delete(User user);

    User getById(Long id);

    void editUser(Long id, String name, String password, String lastname, byte age, String city, String[] roles);
}

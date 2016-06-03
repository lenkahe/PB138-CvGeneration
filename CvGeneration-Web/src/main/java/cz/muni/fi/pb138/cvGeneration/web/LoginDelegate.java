package cz.muni.fi.pb138.cvGeneration.web;

import cz.muni.fi.pb138.cvGeneration.entity.User;
import cz.muni.fi.pb138.cvGeneration.service.entity.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Marek Perichta on 28.05.2016.
 */
public class LoginDelegate {

    @Autowired
    UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public boolean isValidUser(String login, String password) {

        return userService.isUserValid(login, password);

    }

    public User createNewUser(User user) {

        return userService.createNewUser(user);
    }
}

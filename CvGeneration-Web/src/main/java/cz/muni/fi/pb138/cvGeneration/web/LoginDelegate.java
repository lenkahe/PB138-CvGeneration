package cz.muni.fi.pb138.cvGeneration.web;

import cz.muni.fi.pb138.cvGeneration.api.service.UserService;
import cz.muni.fi.pb138.cvGeneration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Marek Perichta on 28.05.2016.
 */
public class LoginDelegate {

    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isValidUser(String login, String password) {

        return userService.isUserValid(login, password);

    }

    public boolean isLoginUsed(String login){
        return userService.isLoginAlreadyUsed(login);
    }

    public User createNewUser(User user) {

        return userService.createNewUser(user);
    }
}

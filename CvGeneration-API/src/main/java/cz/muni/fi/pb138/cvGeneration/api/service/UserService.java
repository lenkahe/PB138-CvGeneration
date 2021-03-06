package cz.muni.fi.pb138.cvGeneration.api.service;

import cz.muni.fi.pb138.cvGeneration.entity.User;

/**
 * Service for user entity.
 *
 * @author Lenka Heldova
 */
public interface UserService {

    /**
     * Authenticates user.
     * @param login
     * @param password
     */
    boolean isUserValid(String login, String password );

    /**
     * Create new user.
     * @param user
     * @return User
     */
    User createNewUser(User user);

    /**
     * Return true if login is already used.
     *
     *  @param login
     */
    boolean isLoginAlreadyUsed(String login);
}

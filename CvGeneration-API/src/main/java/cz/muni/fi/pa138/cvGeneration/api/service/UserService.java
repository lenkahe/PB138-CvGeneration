package cz.muni.fi.pa138.cvGeneration.api.service;

import cz.muni.fi.pa138.cvGeneration.entity.User;

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
     * @return
     */
    User createNewUser(User user);
}

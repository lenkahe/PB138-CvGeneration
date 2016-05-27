package cz.muni.fi.pb138.cvGeneration.service.user;

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
}

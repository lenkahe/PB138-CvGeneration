package cz.muni.fi.pb138.cvGeneration.service.user;

import cz.muni.fi.pb138.cvGeneration.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for user entity.
 *
 * @author Lenka Heldova
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean isUserValid(String login, String password) {
        return (userDao.findByLoginAndPassword(login,password) != null)? true : false;
    }
}
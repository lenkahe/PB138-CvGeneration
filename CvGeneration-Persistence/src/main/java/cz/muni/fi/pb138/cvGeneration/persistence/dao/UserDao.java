package cz.muni.fi.pb138.cvGeneration.persistence.dao;

import cz.muni.fi.pb138.cvGeneration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * User data access object.
 *
 * @author Lenka Heldova
 */

public interface UserDao extends JpaRepository<User, String> {

    User findByLoginAndPassword(@Param("login") String login, @Param("password")String password);

    User findByLogin(@Param("login") String login);


}

package cz.muni.fi.pb138.cvGeneration.persistence.dao;

import cz.muni.fi.pb138.cvGeneration.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User data access object.
 *
 * @author Lenka Heldova
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

}

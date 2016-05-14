import cz.muni.fi.pb138.cvGeneration.persistence.dao.DaoConfiguration;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.UserDao;
import cz.muni.fi.pb138.cvGeneration.persistence.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test for data access object for CV.
 *
 * @author Lenka Heldova
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfiguration.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Before
    public void setUp() {
        user.setLogin("login");
        user.setPassword("password");
    }

    @Test
    public void saveTest(){

        User savedUser = userDao.save(user);

        Assert.assertEquals(savedUser.getLogin(), user.getLogin());


    }

    @Test
    public void findTest(){

       userDao.save(user);
        User finedUser = userDao.findOne("login");
        Assert.assertEquals(finedUser.getLogin(), user.getLogin());
    }
}

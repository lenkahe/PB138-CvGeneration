import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDao;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.DaoConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test for data access object for CV.
 *
 * @author Lenka Heldova
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfiguration.class)
public class CvDaoTest {

    @Autowired
    private CvDao cvDao;

    @Test
    public void test(){
        Assert.assertEquals(true,true);
    }


}

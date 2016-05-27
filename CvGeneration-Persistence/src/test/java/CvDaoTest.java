import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDao;
import cz.muni.fi.pb138.cvGeneration.persistence.configuration.AppConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test for data access object for CV.
 *
 * @author Pavel Jezek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class CvDaoTest {

    @Autowired
    private CvDao cvDao;

    @Test
    public void TestCvDaoComplete() throws XMLDBException, FileNotFoundException {
        File file;
        String fileName, fileContent;
        XMLResource xmlResource;

        //save
        file = new File("src/test/java/cv.xml");
        fileName = cvDao.saveResource(file).getDocumentId();

        //get
        xmlResource = cvDao.getResource(fileName);
        fileContent = new Scanner(file).useDelimiter("\\Z").next();
        fileContent = fileContent.replace("\n", "").replace("\r", "").replace("    ", "");

        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + xmlResource.getContent(), fileContent);

        //delete
        cvDao.deleteResource(fileName);
        xmlResource = cvDao.getResource(fileName);

        Assert.assertEquals(xmlResource, null);
    }
}

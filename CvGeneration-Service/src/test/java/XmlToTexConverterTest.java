import cz.muni.fi.pa138.cvGeneration.api.converter.XmlToTexConverter;
import cz.muni.fi.pb138.cvGeneration.persistence.configuration.AppConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test for convert xml to tex.
 *
 * @author Pavel Jezek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class XmlToTexConverterTest {

    @Autowired
    private XmlToTexConverter xmlToTexConv;

    @Test
    public void TestXmlToTexConverterMinData() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/minData.xml"));
        compareFiles(new File("src/test/java/minDataOrig.tex"), texResult);
        texResult.delete();
    }

    @Test
    public void TestXmlToTexConverterFullData() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/fullData.xml"));
        compareFiles(new File("src/test/java/fullDataOrig.tex"), texResult);
        texResult.delete();
    }

    @Test
    public void TestXmlToTexConverterExtremeLimitsData() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/extremeLimitsData.xml"));
        compareFiles(new File("src/test/java/extremeLimitsDataOrig.tex"), texResult);
        texResult.delete();
    }

    private void compareFiles(File a, File b) throws FileNotFoundException {
        Assert.assertEquals(new Scanner(a).useDelimiter("\\Z").next(), new Scanner(b).useDelimiter("\\Z").next());
    }
}

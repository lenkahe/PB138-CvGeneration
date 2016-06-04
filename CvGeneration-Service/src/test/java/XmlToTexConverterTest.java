import cz.muni.fi.pb138.cvGeneration.api.converter.XmlToTexConverter;
import cz.muni.fi.pb138.cvGeneration.persistence.configuration.AppConfiguration;
import org.junit.After;
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
    public void TestXmlToTexConverterMinDataCz() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/minData.xml"), "cz");
        compareFiles(new File("src/test/resources/minDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterFullDataCz() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/fullData.xml"), "cz");
        compareFiles(new File("src/test/resources/fullDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterExtremeLimitsDataCz() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/extremeLimitsData.xml"), "cz");
        compareFiles(new File("src/test/resources/extremeLimitsDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterMinDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/minData.xml"), "en");
        compareFiles(new File("src/test/resources/minDataOrigEn.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterFullDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/fullData.xml"), "en");
        compareFiles(new File("src/test/resources/fullDataOrigEn.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterExtremeLimitsDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/resources/extremeLimitsData.xml"), "en");
        compareFiles(new File("src/test/resources/extremeLimitsDataOrigEn.tex"), texResult);
    }

    private void compareFiles(File original, File testResult) throws FileNotFoundException {
        Scanner scannerOrigin = new Scanner(original);
        Scanner scannerTest = new Scanner(testResult);
        String origin = scannerOrigin.useDelimiter("\\Z").next();
        String test = scannerTest.useDelimiter("\\Z").next();
        scannerOrigin.close();
        scannerTest.close();
        testResult.deleteOnExit();
        Assert.assertEquals(origin, test);
    }
}

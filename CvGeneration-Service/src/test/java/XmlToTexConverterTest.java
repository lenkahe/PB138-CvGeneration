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
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/minData.xml"), "cz");
        compareFiles(new File("src/test/java/minDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterFullDataCz() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/fullData.xml"), "cz");
        compareFiles(new File("src/test/java/fullDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterExtremeLimitsDataCz() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/extremeLimitsData.xml"), "cz");
        compareFiles(new File("src/test/java/extremeLimitsDataOrig.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterMinDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/minData.xml"), "en");
        compareFiles(new File("src/test/java/minDataOrigEn.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterFullDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/fullData.xml"), "en");
        compareFiles(new File("src/test/java/fullDataOrigEn.tex"), texResult);
    }

    @Test
    public void TestXmlToTexConverterExtremeLimitsDataEn() throws FileNotFoundException {
        File texResult = xmlToTexConv.convertToTex(new File("src/test/java/extremeLimitsData.xml"), "en");
        compareFiles(new File("src/test/java/extremeLimitsDataOrigEn.tex"), texResult);
    }

    private void compareFiles(File a, File b) throws FileNotFoundException {
        Scanner scannerA, scannerB;
        scannerA = new Scanner(a);
        scannerB = new Scanner(b);
        Assert.assertEquals(scannerA.useDelimiter("\\Z").next(), scannerB.useDelimiter("\\Z").next());
        scannerA.close();
        scannerB.close();
    }

    @After
    public void cleanUpFiles(){
        (new File("/src/test/java/minData.tex")).delete();
        (new File("/src/test/java/fullData.tex")).delete();
        (new File("/src/test/java/extremeLimitsData.tex")).delete();
    }
}

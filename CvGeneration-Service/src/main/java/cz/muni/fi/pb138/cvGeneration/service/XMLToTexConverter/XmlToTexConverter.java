package cz.muni.fi.pb138.cvGeneration.service.XMLToTexConverter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author Pavel Jezek
 */
public class XmlToTexConverter {

    public static void convertToTex(File xmlFile, File texFile){

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer xsltTrans;
        try {
            xsltTrans = tf.newTransformer(new StreamSource(new File("CvGeneration-Service\\src" +
                    "\\main\\java\\cz\\muni\\fi\\pb138\\cvGeneration\\service\\xml2tex.xslt")));
            xsltTrans.transform(new StreamSource(xmlFile),
                    new StreamResult(texFile));
        } catch (TransformerConfigurationException ex) {
            System.err.println("Transformer init error: "+ex.getMessage());
        } catch (TransformerException ex) {
            System.err.println("Transformation error: "+ex.getMessage());
        }
    }
}

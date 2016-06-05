package cz.muni.fi.pb138.cvGeneration.service.converter;

import cz.muni.fi.pb138.cvGeneration.api.converter.XmlToTexConverter;
import org.springframework.stereotype.Component;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Implementation for {@link XmlToTexConverter}
 * @author Pavel Jezek
 */
@Component
public class XmlToTexConverterImpl implements XmlToTexConverter{

    @Override
    public File convertToTex(File xmlFile, String language){
        File texFile = new File(xmlFile.getAbsolutePath().replace(".xml",".tex"));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer xsltTrans;
        try {
            File xslt;
            switch (language){
                case "cz": xslt = new File("..\\CvGeneration-Service\\src\\main\\resources\\xml2texCz.xslt"); break;
                case "en": xslt = new File("..\\CvGeneration-Service\\src\\main\\resources\\xml2texEn.xslt"); break;
                default: throw new IllegalArgumentException("Not valid language");
            }

            xsltTrans = tf.newTransformer(new StreamSource(xslt));
            xsltTrans.transform(new StreamSource(xmlFile),
                    new StreamResult(texFile));
        } catch (TransformerConfigurationException ex) {
            System.err.println("Transformer init error: "+ex.getMessage());
        } catch (TransformerException ex) {
            System.err.println("Transformation error: "+ex.getMessage());
        }
        return texFile;
    }
}

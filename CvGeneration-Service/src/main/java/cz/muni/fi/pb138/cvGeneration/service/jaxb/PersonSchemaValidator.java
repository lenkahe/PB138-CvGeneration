package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * This class validates an XML file against an XSD
 *
 * Created by galbavyj on 20.05.2016.
 */
public class PersonSchemaValidator {

    private Schema schema = null;

    public PersonSchemaValidator(){
        try{
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            this.schema = factory.newSchema(new File("..\\CvGeneration-Service\\src\\main\\java\\cz\\muni\\fi\\pb138\\cvGeneration\\service\\person.xsd"));
        }catch(SAXException ex){
            System.err.println("Error at setting schema for validation: "+ex.getMessage());
        }
    }

    /**
     * This method validates an XML file against an XSD
     * @param xmlFile tested xml file
     * @return true if XML file is valid
     */
    public boolean validate(File xmlFile){
        if (xmlFile.exists()) {

            Validator validator = this.schema.newValidator();
            Source xmlSource = new StreamSource(xmlFile);

            try {
                validator.validate(xmlSource);
                System.out.println(xmlFile.getName() + " is valid.");
                return true;
            } catch (SAXException ex) {
                System.err.println("XML document is not valid: " + ex.getMessage());
                return false;
            } catch (IOException ex) {
                System.err.println("DOMSource error: "+ex.getMessage());
                return false;
            }
        }
        return false;
    }
}

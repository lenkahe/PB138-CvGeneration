package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pb138.cvGeneration.api.converter.JavaToXmlConverter;
import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.persistence.exception.DataAccessCvException;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class this class is implementation for {@link JavaToXmlConverter}
 *
 * Created by galbavyj on 13.05.2016.
 */
@Component
public class JavaToXmlConverterImpl implements JavaToXmlConverter {

    @Override
    public File createXML(Person person) throws ValidationException {


        String fileName = Math.abs(person.getUserLogin().hashCode()) + ".xml";
        File file = new File(System.getProperty("user.dir") + "\\" + fileName);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);


        } catch (JAXBException e) {
            System.err.println("Can not create XML file due to error: " + e.getMessage());
        }

        PersonSchemaValidator personSchemaValidator = new PersonSchemaValidator();
        if (!personSchemaValidator.validate(file)) throw new ValidationException("XML file is not valid!");

        return file;
    }

    @Override
    public Person createPerson(String fileName){

        CvDaoImpl cvDao = new CvDaoImpl();
        XMLResource res = cvDao.getResource(fileName);

        if(res == null) throw new DataAccessCvException("No resource with this name.");

        Person person = null;

        File file = new File(System.getProperty("user.dir") + "\\" + fileName);


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write((String)res.getContent());
            writer.flush();
            writer.close();
        } catch (IOException |XMLDBException e) {
            System.err.println("Problem with writer: " + e.getMessage());
        }

        PersonSchemaValidator personSchemaValidator = new PersonSchemaValidator();
        personSchemaValidator.validate(file);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            person = (Person) jaxbUnmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            System.err.println("Can not create Person from XML file due to error: " + e.getMessage());
        } finally {
            if (!file.delete()) System.err.print("File " + file.getName() + " can not be deleted.");
        }

        return person;
    }
}

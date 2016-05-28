package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pa138.cvGeneration.api.converter.XmlConverter;
import cz.muni.fi.pa138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.persistence.exception.DataAccessCvException;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This class convert Person object to XML file and back
 *
 * Created by galbavyj on 13.05.2016.
 */
@Component
public class XmlConverterImpl implements XmlConverter{

    @Override
    public String createXML(Person person) {

        CvDaoImpl cvDao = new CvDaoImpl();
        String fileName = person.getPersonalInfo().getLastName() + person.hashCode() + ".xml";
        File file = new File(System.getProperty("user.dir") + "\\" + fileName);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);

            PersonSchemaValidator personSchemaValidator = new PersonSchemaValidator();
            if (personSchemaValidator.validate(file))
                cvDao.saveResource(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            file.delete();

        }

        return fileName;

    }

    @Override
    public Person createPerson(String name){

        CvDaoImpl cvDao = new CvDaoImpl();
        XMLResource res = cvDao.getResource(name);

        if(res == null) throw new DataAccessCvException("No resource with this name.");

        Person person = null;

        File file = new File(System.getProperty("user.dir") + "\\" + name);


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write((String)res.getContent());
            writer.flush();
            writer.close();
        } catch (IOException |XMLDBException e) {
            e.printStackTrace();
        }

        PersonSchemaValidator personSchemaValidator = new PersonSchemaValidator();
        personSchemaValidator.validate(file);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            person = (Person) jaxbUnmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }

        return person;
    }
}

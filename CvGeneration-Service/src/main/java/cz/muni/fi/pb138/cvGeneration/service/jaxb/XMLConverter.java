package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.persistence.entity.Person;
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
public class XMLConverter {

    /**
     *  This method is intended for generating a new xml document
     *
     * @param person variable in which is kept all neccessary information about person
     * @return name of xml file in database
     *
     */
    public String createXML(Person person) throws XMLDBException {

        CvDaoImpl cvDao = new CvDaoImpl();
        File file = new File(System.getProperty("user.dir") + "\\person.xml");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String name = cvDao.saveResource(file).getDocumentId();
        file.delete();

        return name;

    }

    /**
     * This method is intended for generating a new person from XML
     *
     * @param name name of xml file in which is kept all neccessary information about person
     * @return object Person
     */
    public Person createPerson(String name){

        CvDaoImpl cvDao = new CvDaoImpl();
        XMLResource res = cvDao.getResource(name);
        Person person = null;

        File file = new File(System.getProperty("user.dir") + "\\person.xml");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write((String)res.getContent());
            writer.flush();
            writer.close();
        } catch (IOException |XMLDBException e) {
            e.printStackTrace();
        }


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

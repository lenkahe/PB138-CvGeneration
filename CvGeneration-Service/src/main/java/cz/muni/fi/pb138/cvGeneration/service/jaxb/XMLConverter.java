package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.persistence.entity.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


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
     *
     */
    public static void createXML(Person person){

        String nameOfFile = person.getPersonalInfo().getFirstName() + person.getPasswordHash();
        CvDaoImpl cvDao = new CvDaoImpl();

        try {

            File file = new File("C:\\projects\\" + nameOfFile +".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);


            cvDao.saveResource(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is intended for generating a new person from XML
     *
     * @param file xml file in which is kept all neccessary information about person
     */
    public static void createPerson(File file) {

        try {

            //File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) jaxbUnmarshaller.unmarshal(file);
            System.out.println(person);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


}

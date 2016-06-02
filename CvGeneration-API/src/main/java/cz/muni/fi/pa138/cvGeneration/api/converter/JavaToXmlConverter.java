package cz.muni.fi.pa138.cvGeneration.api.converter;

import cz.muni.fi.pa138.cvGeneration.entity.Person;

import javax.xml.bind.ValidationException;
import java.io.File;

/**
 * This class convert Person object to XML file and back.
 *
 * @author Lenka Heldova
 */
public interface JavaToXmlConverter {



    /**
     *  This method is intended for generating a new xml document
     *
     * @param person variable in which is kept all necessary information about person
     * @return name of xml file in database
     *
     */
    File createXML(Person person) throws ValidationException;


    /**
     * This method is intended for generating a new person from XML
     *
     * @param name name of xml file in which is kept all necessary information about person
     * @return object Person
     */
     Person createPerson(String name);
}

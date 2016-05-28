package cz.muni.fi.pa138.cvGeneration.api.converter;

import cz.muni.fi.pa138.cvGeneration.entity.Person;

/**
 * This class convert Person object to XML file and back.
 *
 * @author Lenka Heldova
 */
public interface XmlConverter {



    /**
     *  This method is intended for generating a new xml document
     *
     * @param person variable in which is kept all necessary information about person
     * @return name of xml file in database
     *
     */
    String createXML(Person person);


    /**
     * This method is intended for generating a new person from XML
     *
     * @param name name of xml file in which is kept all necessary information about person
     * @return object Person
     */
     Person createPerson(String name);
}

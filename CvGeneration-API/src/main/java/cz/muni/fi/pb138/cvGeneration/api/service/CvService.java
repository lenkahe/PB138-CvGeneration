package cz.muni.fi.pb138.cvGeneration.api.service;

import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.entity.User;

import javax.xml.bind.ValidationException;
import java.io.File;

/**
 * Service for user entity.
 *
 * @author Lenka Heldova
 */
public interface CvService {

    /**
     * This method return CV informations by user
     * @param user
     * @return
     */
    Person getCvInformation (User user);

    /**
     * This method save CV data into xml file
     * @param cv
     * @return cv
     * @throws ValidationException
     */
    Person saveCvInformation (Person cv) throws ValidationException;

    /**
     * This method create PDF from .tex file. Once is PDF generated, all temporary files are deleted
     * @param person
     * @param lang
     * @return File pdf
     * @throws ValidationException
     */
    File createPdf(Person person, String lang) throws ValidationException;
}

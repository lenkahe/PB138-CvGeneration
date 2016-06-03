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

    Person getCvInformation (User user);

    Person saveCvInformation (Person cv) throws ValidationException;

    File createPdf(Person person, String lang) throws ValidationException;
}

package cz.muni.fi.pa138.cvGeneration.api.service;

import cz.muni.fi.pa138.cvGeneration.entity.Person;
import cz.muni.fi.pa138.cvGeneration.entity.User;

import java.io.File;

/**
 * Service for user entity.
 *
 * @author Lenka Heldova
 */
public interface CvService {

    Person getCvInformation (User user);

    Person saveCvInformation (Person cv);

    File createPdf(Person person);
}

package cz.muni.fi.pb138.cvGeneration.service.entity;

import cz.muni.fi.pa138.cvGeneration.api.service.CvService;
import cz.muni.fi.pa138.cvGeneration.entity.Person;
import cz.muni.fi.pa138.cvGeneration.entity.User;

import java.io.File;

/**
 * Implementation for CvService.
 *
 * @author DOPISAT
 */
public class CvServiceImpl implements CvService{
    @Override
    public Person getCvInformation(User user) {
        return null;
    }

    @Override
    public Person saveCvInformation(Person cv) {
        return null;
    }

    @Override
    public File createPdf(Person person) {
        return null;
    }
}

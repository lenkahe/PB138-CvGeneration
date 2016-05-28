package cz.muni.fi.pb138.cvGeneration.service.entity;

import cz.muni.fi.pa138.cvGeneration.api.converter.TexToPdfConverter;
import cz.muni.fi.pa138.cvGeneration.api.converter.XmlToTexConverter;
import cz.muni.fi.pa138.cvGeneration.api.service.CvService;
import cz.muni.fi.pa138.cvGeneration.entity.Person;
import cz.muni.fi.pa138.cvGeneration.entity.User;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.service.converter.TexToPdfConverterImpl;
import cz.muni.fi.pb138.cvGeneration.service.converter.XmlToTexConverterImpl;
import cz.muni.fi.pb138.cvGeneration.service.jaxb.XmlConverterImpl;
import java.io.File;


/**
 * Implementation for CvService.
 *
 * @author galbavyj
 */
public class CvServiceImpl implements CvService{

    private XmlConverterImpl converter = new XmlConverterImpl();

    @Override
    public Person getCvInformation(User user) {

        return converter.createPerson(user.getCvFileName());
    }

    @Override
    public Person saveCvInformation(Person cv, User user) {

        CvDaoImpl cvDao = new CvDaoImpl();

        File xmlFile = converter.createXML(cv);
        cvDao.saveResource(xmlFile);
        if (!xmlFile.delete()) System.err.print("File " + xmlFile.getName() + " can not be delete.");

        user.setCvFileName(xmlFile.getName());

        return cv;
    }

    @Override
    public File createPdf(Person person) {

        TexToPdfConverter texToPdfconv = new TexToPdfConverterImpl();
        XmlToTexConverter xmlToTexconv = new XmlToTexConverterImpl();


        File xmlFile = converter.createXML(person);
        File texFile = xmlToTexconv.convertToTex(xmlFile);

        String pdfFilePath = texToPdfconv.createPDF(texFile);

        if (!xmlFile.delete()) System.err.print("File " + xmlFile.getName() + " can not be delete.");
        if (!texFile.delete()) System.err.print("File " + texFile.getName() + " can not be delete.");

        return new File(pdfFilePath);
    }
}

package cz.muni.fi.pb138.cvGeneration.service.entity;

import cz.muni.fi.pb138.cvGeneration.api.converter.JavaToXmlConverter;
import cz.muni.fi.pb138.cvGeneration.api.converter.TexToPdfConverter;
import cz.muni.fi.pb138.cvGeneration.api.converter.XmlToTexConverter;
import cz.muni.fi.pb138.cvGeneration.api.service.CvService;
import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.entity.User;
import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.io.File;


/**
 * Implementation for {@link CvService}.
 *
 * @author galbavyj
 */
@Component
public class CvServiceImpl implements CvService{

    @Autowired
    private JavaToXmlConverter converter;

    @Autowired
    private CvDaoImpl cvDao;

    @Autowired
    TexToPdfConverter texToPdfConv;

    @Autowired
    XmlToTexConverter xmlToTexConv;

    @Override
    public Person getCvInformation(String login) {
        return converter.createPerson(login.hashCode() + ".xml");
    }

    @Override
    public Person saveCvInformation(Person cv) throws ValidationException {

        File xmlFile = converter.createXML(cv);
        cvDao.saveResource(xmlFile);
        xmlFile.delete();
        return cv;
    }

    @Override
    public File createPdf(Person person, String lang) throws ValidationException {

        File xmlFile = converter.createXML(person);
        cvDao.saveResource(xmlFile);
        File texFile = xmlToTexConv.convertToTex(xmlFile, lang);
        xmlFile.delete();
        String texName = texFile.getName();
        String pdfFilePath = texToPdfConv.createPDF(new File(texName.replace(".tex","")));

        return new File(pdfFilePath);
    }
}

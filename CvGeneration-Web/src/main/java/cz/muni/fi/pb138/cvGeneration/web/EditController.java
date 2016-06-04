package cz.muni.fi.pb138.cvGeneration.web;


import cz.muni.fi.pb138.cvGeneration.api.service.CvService;
import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.entity.item.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import java.util.Map;

/**
 * Created by Marek Perichta on 01.06.2016.
 */
@Controller
public class EditController {

    @Autowired
    private CvService cvService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    public void saveCv(HttpServletRequest request, HttpServletResponse response) {
        Map htmlParams = request.getParameterMap();
        if(htmlParams != null){

            PersonalInfo personalInfo = new PersonalInfo(htmlParams);
            Person person = cvService.getCvInformation("admin");
            person.setPersonalInfo(personalInfo);

            //should be user login
            person.setUserLogin("admin");
            try {
                cvService.saveCvInformation(person);
            } catch (ValidationException ex) {
                System.err.println("Could not save CV: "+ ex.getMessage());

            }

        }

    }


}

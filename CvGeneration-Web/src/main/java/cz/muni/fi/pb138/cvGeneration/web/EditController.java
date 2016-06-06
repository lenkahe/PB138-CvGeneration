package cz.muni.fi.pb138.cvGeneration.web;


import cz.muni.fi.pb138.cvGeneration.api.service.CvService;
import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.entity.item.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by Marek Perichta on 01.06.2016.
 */
@Controller
public class EditController {

    @Autowired
    private CvService cvService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ModelAndView saveCv(HttpServletRequest request, HttpServletResponse response) {
        Map htmlParams = request.getParameterMap();
        String login = request.getParameter("login").toString();

        ModelAndView model = new ModelAndView("showCV");
        if(htmlParams != null){
            PersonalInfo personalInfo = new PersonalInfo(htmlParams);
            Person person = cvService.getCvInformation(login);
            person.setPersonalInfo(personalInfo);
            person.setAdditionalInfo(htmlParams);
            try {
                cvService.saveCvInformation(person);
            } catch (ValidationException ex) {
                System.err.println("Could not save CV: "+ ex.getMessage());

            }

            model.addObject("person", person);

        }

        return model;
    }

    @RequestMapping(value = "/download" , method = RequestMethod.POST)
    public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getSession().getServletContext();
        String login = request.getParameter("login").toString();
        String pdfLang = request.getParameter("pdfLang").toString();
        Person person = cvService.getCvInformation(login);
        File pdf;
        try {
            pdf = cvService.createPdf(person, pdfLang);
            FileInputStream inputStream = new FileInputStream(pdf);

            response.setContentType("application/pdf");

            // get output stream of the response
            OutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[1000];
            int bytesRead = -1;

            // write bytes read from the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }


    }
}

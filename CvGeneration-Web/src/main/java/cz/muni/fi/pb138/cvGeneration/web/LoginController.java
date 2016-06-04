package cz.muni.fi.pb138.cvGeneration.web;

import cz.muni.fi.pb138.cvGeneration.api.service.CvService;
import cz.muni.fi.pb138.cvGeneration.entity.Person;
import cz.muni.fi.pb138.cvGeneration.entity.User;
import cz.muni.fi.pb138.cvGeneration.entity.item.Address;
import cz.muni.fi.pb138.cvGeneration.entity.item.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Marek Perichta on 14.05.2016.
 */
@Controller

public class LoginController {

/*    @RequestMapping(value = "/index")
    public String root() {
        return "index";
    }*/

    @Autowired
    private LoginDelegate loginDelegate;
    @Autowired
    private CvService cvService;

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("index");
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);
        return model;
    }

    @RequestMapping(value="/editcv",method=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
    {
        ModelAndView model= null;
        try
        {
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            if(isValidUser)
            {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("showCV");
            }
            else
            {
                System.out.println("User Login Unsuccessful");
                model = new ModelAndView("index");
                model.addObject("loginBean", loginBean);
                request.setAttribute("messageLogIn", "Invalid credentials!!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return model;
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
    {
        ModelAndView model= null;
        try {
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            //if user not registered yet
            if (!isValidUser) {
                User user = new User();
                user.setLogin(loginBean.getUsername());
                user.setPassword(loginBean.getPassword());

                //create user
                loginDelegate.createNewUser(user);

                System.out.println("New user registered: " + user.getLogin());

                //create blank person/cv for the username
                Person person = new Person();

                //must be filled for restrictions from here
                PersonalInfo pi = new PersonalInfo();
                pi.setFirstName("Jano");
                pi.setLastName("Rochnyiak");
                pi.setPostTitle("bla");
                Address address = new Address ();
                address.setCity("kosice");
                address.setStreet("Masarykova");
                address.setPostalCode("97654");
                pi.setAddress(address);
                person.setPersonalInfo(pi);
                //to here

                person.setUserLogin(loginBean.getUsername());
                try {
                    cvService.saveCvInformation(person);
                } catch (ValidationException ex) {
                    System.err.println("Could not save CV: "+ ex.getMessage());
                }


                System.out.println("New user registered");

                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("showCV");
                model.addObject("person", person);
            } else {
                System.out.println("Registration unsuccessful");
                model = new ModelAndView("index");
                model.addObject("loginBean", loginBean);
                request.setAttribute("messageRegister", "This username is already in use.");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return model;

    }

}



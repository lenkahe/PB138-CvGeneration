package cz.muni.fi.pb138.cvGeneration.web;

import cz.muni.fi.pb138.cvGeneration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
                request.setAttribute("message", "Invalid credentials!!");
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
            if (!isValidUser) {
                User user = new User();
                user.setLogin(loginBean.getUsername());
                user.setPassword(loginBean.getPassword());
                loginDelegate.createNewUser(user);
                System.out.println("New user registered");
                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("showCV");
            } else {
                System.out.println("Registration unsuccessful");
                model = new ModelAndView("index");
                model.addObject("loginBean", loginBean);
                request.setAttribute("message", "This username is already in use.");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return model;

    }

}



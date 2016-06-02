package cz.muni.fi.pb138.cvGeneration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Marek Perichta on 01.06.2016.
 */
@Controller
public class EditController {

    @RequestMapping(value="/editcv/save",method= RequestMethod.POST)
    public void saveCv(HttpServletRequest request, HttpServletResponse response)
    {

    }


}

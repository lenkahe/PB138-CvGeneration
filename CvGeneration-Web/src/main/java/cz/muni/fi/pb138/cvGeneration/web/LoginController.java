package cz.muni.fi.pb138.cvGeneration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Marek Perichta on 14.05.2016.
 */
@Controller

public class LoginController {

    @RequestMapping(value = "/index")
    public String root() {
        return "index";
    }
}


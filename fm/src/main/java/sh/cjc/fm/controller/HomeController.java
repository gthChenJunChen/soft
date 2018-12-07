package sh.cjc.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/home/index")
    public String indexPage() {
        return "home/index";
    }


}

package sh.cjc.fm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @RequestMapping(value = "index")
    public ModelAndView index() {
        return new ModelAndView("test/index");
    }
}

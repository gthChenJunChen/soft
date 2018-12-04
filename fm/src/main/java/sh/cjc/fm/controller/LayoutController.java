package sh.cjc.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
    @RequestMapping(value = "layout")
    public String layout() {
        return "_layout";
    }
}

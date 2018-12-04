package sh.cjc.fm.controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/template/tips")
public class Tips {
    @RequestMapping(value = "/404")
    public String errorPage() {
        return "template/error";
    }
}

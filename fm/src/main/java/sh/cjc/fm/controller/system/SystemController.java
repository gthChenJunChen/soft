package sh.cjc.fm.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
    @RequestMapping(value = "/system/theme")
    public String theme() {
        return "/system/theme";
    }
}

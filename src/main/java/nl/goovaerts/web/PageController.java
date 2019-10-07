package nl.goovaerts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping
    public String catchAll(Model model) {
        model.addAttribute("language", "en");
        model.addAttribute("title", "Health Services");
        return "default";
    }
}

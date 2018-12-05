package io.anymobi.springbootwebmvcstater.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @GetMapping("/helloview")
    public String hello(Model model){
        model.addAttribute("name", "anymobi");
        return "helloview";
    }

}

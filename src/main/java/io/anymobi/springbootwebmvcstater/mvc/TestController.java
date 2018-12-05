package io.anymobi.springbootwebmvcstater.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    /*@Autowired
    TestService testService;*/

    @GetMapping("/hello")
    public String hello(){

        return "hello " /*+ testService.getName()*/;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {

        return user;
    }

}

package io.anymobi.springbootwebmvcstater.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exception")
    public String hello() throws SampleException {

        throw new SampleException();
    }

    @ExceptionHandler
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError error = new AppError();
        error.setMessage(e.toString());
        return error;
    }

}

package io.anymobi.springbootwebmvcstater;


import io.anymobi.springbootwebmvcstater.mvc.ViewController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ViewController.class)
public class SpringBootWebmvcStaterApplicationTests2 {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getView() throws Exception {

        mockMvc.perform(get("/helloview"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("helloview"))
                .andExpect(model().attribute("name", is("anymobi")))
                .andExpect(content().string(containsString("anymobi")));
    }

}

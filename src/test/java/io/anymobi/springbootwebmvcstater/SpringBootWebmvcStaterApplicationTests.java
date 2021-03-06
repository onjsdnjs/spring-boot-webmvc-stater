package io.anymobi.springbootwebmvcstater;

import io.anymobi.springbootwebmvcstater.mvc.TestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class SpringBootWebmvcStaterApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello anymobi"))
                .andDo(print());
    }

    @Test
    public void getView() throws Exception {

        mockMvc.perform(get("/helloview"))
                .andExpect(status().isOk())
                .andExpect(view().name("helloview"))
                .andExpect(model().attribute("name",is("anymobi")));
    }

    @Test
    public void createUser_JSON() throws Exception{

        String userJson = "{\"username\":\"anymobi\",\"password\":\"1234\"}";
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(equalTo("anymobi"))))
                .andExpect(jsonPath("$.password", is(equalTo("1234"))));

    }

    @Test
    public void createUser_XML() throws Exception{

        String userJson = "{\"username\":\"anymobi\",\"password\":\"1234\"}";
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath(("/User/username")).string("anymobi"))
                .andExpect(xpath(("/User/password")).string("1234"));

    }

}

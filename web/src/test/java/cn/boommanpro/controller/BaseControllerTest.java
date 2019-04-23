package cn.boommanpro.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = BaseController.class)
@RunWith(SpringRunner.class)
public class BaseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void queryMobile() {

        String mobile = "15735105106";
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/base/queryMobile").param("mobile",mobile))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void complexQuery() {
    }

    @Test
    public void login() {
    }
}
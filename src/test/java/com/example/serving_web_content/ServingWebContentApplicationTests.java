package com.example.serving_web_content;

import com.example.serving_web_content.controllers.GreetingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ServingWebContentApplicationTests {

    @Autowired
    private GreetingController greetingController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingControllerExists() throws Exception {
        assertThat(greetingController).isNotNull();
    }


    @Test
    void indexHtmlShouldLoad() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk());
    }

    @Test
    void rootShouldServeIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}

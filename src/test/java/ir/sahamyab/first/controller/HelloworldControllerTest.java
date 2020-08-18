package ir.sahamyab.first.controller;

import ir.sahamyab.first.controller.HelloWorldController;
import ir.sahamyab.first.entity.Helloworld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloworldControllerTest {

    @MockBean
    private HelloWorldController helloWorldController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void indexTest() throws Exception {

        Helloworld helloworld = new Helloworld(1L, "ali");


        given(helloWorldController.index()).willReturn(helloworld);

        mvc.perform(get("/hello")

                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(helloworld.getName())));

    }

}

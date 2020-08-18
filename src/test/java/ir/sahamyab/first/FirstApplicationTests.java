package ir.sahamyab.first;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FirstApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMethod() throws Exception {
        mvc.perform(get("/hello")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
//        Assert.assertEquals(true, true);
    }

}

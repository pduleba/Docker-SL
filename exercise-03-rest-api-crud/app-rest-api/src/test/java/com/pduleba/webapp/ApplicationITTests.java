package com.pduleba.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApplicationITTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void When_findAll_Expect_allUsers() throws Exception {

        // given

        // when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all/")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        // then
        assertNotNull(mvcResult);
        assertEquals(200, mvcResult.getResponse().getStatus());
    }


    @Test
    public void When_create_Expect_allUsers() throws Exception {

        // given

        // when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all/create")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        // then
        assertNotNull(mvcResult);
        assertEquals(200, mvcResult.getResponse().getStatus());
    }
}

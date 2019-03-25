package com.pduleba.webapp;

import com.pduleba.webapp.dao.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepository playerRepository;

    @Test
    public void When_findAll_Expect_allUsers() throws Exception {

        // given
        when(playerRepository.findAll()).thenReturn(
                Collections.emptyList()
        );

        // when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all/")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        // then
        assertNotNull(mvcResult);
        verify(playerRepository).findAll();
    }


    @Test
    public void When_create_Expect_allUsers() throws Exception {

        // given
        when(playerRepository.findAll()).thenReturn(
                Collections.emptyList()
        );

        // when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all/create/")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        // then
        assertNotNull(mvcResult);
        verify(playerRepository).findAll();
    }
}

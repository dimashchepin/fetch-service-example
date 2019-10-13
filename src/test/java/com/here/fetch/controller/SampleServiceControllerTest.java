package com.here.fetch.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.here.fetch.service.SampleServiceForWeb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Integration tests for Sample service controller.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleServiceControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void testMainPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(SampleServiceForWeb.DISPLAY_INFO)));
    }

    @Test
    public void testIsWordRight() throws Exception {
        String inputWord = "sssell";
        mvc.perform(MockMvcRequestBuilders.get("/pyramid/" + inputWord).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("true")));
    }

    @Test
    public void testIsWordWrong() throws Exception {
        String inputWord = "abba";
        mvc.perform(MockMvcRequestBuilders.get("/pyramid/" + inputWord).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("false")));
    }

    @Test
    public void testWhenWordIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/pyramid/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testWhenWordIsOneLetter() throws Exception {
        String inputWord = "a";
        mvc.perform(MockMvcRequestBuilders.get("/pyramid/" + inputWord).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("true")));
    }
}

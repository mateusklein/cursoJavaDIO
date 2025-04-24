package com.dio.springboot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TestIntController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testInt() throws Exception{
        RequestBuilder requisicao = get("/test");
        MvcResult result = mockMvc.perform(requisicao).andReturn();
        Assertions.assertEquals("Saudacao: DIO", result.getResponse().getContentAsString());
    }

    @Test
    public void testIntArgument() throws Exception{
        mockMvc.perform(get("/test?nome=Mateus"))
                .andExpect(content().string("Saudacao: Mateus"));
    }

}

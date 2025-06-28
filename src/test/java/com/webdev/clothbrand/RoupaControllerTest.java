package com.webdev.clothbrand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.clothbrand.dto.RoupaDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoupaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveAdicionarERetornarRoupa() throws Exception {
        RoupaDTO dto = new RoupaDTO();
        dto.setNome("Camisa Polo");
        dto.setTamanho("M");
        dto.setPreco(79.90);
        dto.setTipoId(1); // CAMISA, baseado em TipoRoupa.CAMISA = 1

        mockMvc.perform(post("/api/roupas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Camisa Polo"))
                .andExpect(jsonPath("$.tipo").value(1)); // Verifica ID do enum
    }

    @Test
    public void deveListarRoupas() throws Exception {
        mockMvc.perform(get("/api/roupas"))
                .andExpect(status().isOk());
    }
}
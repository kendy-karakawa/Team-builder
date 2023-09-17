package br.com.criarTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import br.com.criarTime.entity.PlayerEntity;

@AutoConfigureMockMvc
@SpringBootTest
public class PlayerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createPlayerTest() throws Exception{
        PlayerEntity player = new PlayerEntity();
        player.setNome("kendy");
        String json = new Gson().toJson(player);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/jogador")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String textResult = result.getResponse().getContentAsString();
        assert(textResult.equals(""));
                                    
    }

    @Test
    public void deleteAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/jogador/all"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

package com.example.card;

import com.example.card.interfaces.CardController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CardServiceApplication.class)
class CardServiceApplicationTests {

    @Autowired
    CardController controller;

    @Test
    void contextLoads() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }

}

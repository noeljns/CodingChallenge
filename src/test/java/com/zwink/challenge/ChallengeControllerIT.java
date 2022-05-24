package com.zwink.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Integration Test for ChallengeController. Currently this test only passes if the test server runs locally so the
 * numbers can be fetched.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ChallengeControllerIT {

    // TODO: mock WebClient located in FetchNumbersServiceImpl

    @Autowired
    public MockMvc mockMvc;

    @Test
    void getNumbers() throws Exception {
        // When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .get("http://127.0.0.1:8080/numbers")
                .queryParam("u", "http://127.0.0.1:8090/primes")
                .queryParam("u", "http://127.0.0.1:8090/fibo")
                .queryParam("u", "http://127.0.0.1:8090/rand"));

        // Then
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.numbers").isArray());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.numbers[0]").isNumber());
    }
}

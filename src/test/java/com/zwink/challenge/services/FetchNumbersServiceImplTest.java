package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

/**
 * Unit Test for FetchNumbersServiceImpl. Currently this test only passes if the test server runs locally so the numbers
 * can be fetched.
 */
@ExtendWith(MockitoExtension.class)
class FetchNumbersServiceImplTest {
    // TODO: initialize WebClient with mockBandEnd.getPort();
    private static FetchNumbersServiceImpl fetchNumbersService;

    // TODO: mock WebClient
    private static MockWebServer mockNumbersServer;

    @BeforeAll
    static void setUp() {
        fetchNumbersService = new FetchNumbersServiceImpl();

        // TODO:prepare mocking WebClient
        // mockNumbersServer = new MockWebServer();
        // mockNumbersServer.start();
    }

    @AfterAll
    static void tearDown() {
        // TODO: clean up mocking WebClient
        // mockNumbersServer.shutdown();
    }

    @Test
    void givenUrls_whenGetNumbersByUrls_thenReturnNumbers() {
        // TODO: mock WebClient

        // Given
        String urlOne = "http://127.0.0.1:8090/primes";
        String urlTwo = "http://127.0.0.1:8090/fibo";
        String urlThree = "http://127.0.0.1:8090/rand";
        List<String> urls = Arrays.asList(urlOne, urlTwo, urlThree);

        // When
        List<Numbers> numbers = fetchNumbersService.getNumbersByUrls(urls);

        // Then
        Assertions.assertNotNull(numbers);
        for(Numbers numbersElement : numbers) {
            Assertions.assertNotNull(numbersElement.getNumbers());
            Assertions.assertNotNull(numbersElement.getStrings());
        }
    }
}
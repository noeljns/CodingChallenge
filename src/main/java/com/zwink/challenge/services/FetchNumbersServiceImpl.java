package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchNumbersServiceImpl implements FetchNumbersService {

    private WebClient numbersApiClient;

    public FetchNumbersServiceImpl() {
        numbersApiClient = WebClient.create("http://127.0.0.1:8090/");
    }

    public List<Numbers> getNumbersByUrls(List<String> urls) {
        List<Numbers> numbers = new ArrayList<>();

        for (String url : urls) {
            String urlSuffix = extractSuffixFromUrl(url);
            numbers.add(fetchNumbersFromApi(urlSuffix));
        }

        return numbers;
    }

    private String extractSuffixFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    private Numbers fetchNumbersFromApi(String urlSuffix) {
        return numbersApiClient
                .get()
                .uri(urlSuffix)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Numbers.class)
                // retry in case of failed requests
                .retryWhen(Retry.fixedDelay(4, Duration.ofSeconds(5)))
                .block();
    }
}












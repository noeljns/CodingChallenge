package com.zwink.challenge.controller;

import com.zwink.challenge.models.Numbers;
import com.zwink.challenge.models.ResponseNumbers;
import com.zwink.challenge.services.FetchNumbersService;
import com.zwink.challenge.services.FetchNumbersServiceImpl;
import com.zwink.challenge.services.ProcessNumbersService;
import com.zwink.challenge.services.ProcessNumbersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {
    private final FetchNumbersService fetchNumbersService;

    private final ProcessNumbersService processNumbersService;

    @Autowired
    public ChallengeController(FetchNumbersServiceImpl numbersService, ProcessNumbersServiceImpl processNumbersService) {
        this.fetchNumbersService = numbersService;
        this.processNumbersService = processNumbersService;
    }

    @GetMapping("/numbers")
    public ResponseEntity<ResponseNumbers> getNumbers(@RequestParam(name = "u") List<String> urls) {
        List<Numbers> numbers = fetchNumbersService.getNumbersByUrls(urls);
        ResponseNumbers responseNumbers = processNumbersService.processNumbers(numbers);

        return new ResponseEntity<>(responseNumbers, HttpStatus.OK);
    }
}

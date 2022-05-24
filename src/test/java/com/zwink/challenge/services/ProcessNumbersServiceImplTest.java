package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;
import com.zwink.challenge.models.ResponseNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Unit Test for ProcessNumbersServiceImpl.
 */
class ProcessNumbersServiceImplTest {

    private ProcessNumbersServiceImpl processNumbersService;

    @BeforeEach
    public void setUp() {
        processNumbersService = new ProcessNumbersServiceImpl();
    }

    @Test
    public void givenNumbers_whenProcessNumbers_thenReturnProcessedNumbers() {
        // Given
        Numbers numbersOne = new Numbers();
        numbersOne.setNumbers(Arrays.asList(5, 33, 900));
        Numbers numbersTwo = new Numbers();
        numbersTwo.setNumbers(Arrays.asList(4, 53, 3));
        Numbers numbersThree = new Numbers();
        numbersThree.setNumbers(Arrays.asList(900, 79, 4));

        List<Numbers> numbers = new ArrayList<>();
        numbers.add(numbersOne);
        numbers.add(numbersTwo);
        numbers.add(numbersThree);

        // When
        ResponseNumbers responseNumbers = processNumbersService.processNumbers(numbers);

        // Then
        List<Integer> expected = Arrays.asList(3, 4, 5, 33, 53, 79, 900);
        Assertions.assertEquals(expected, responseNumbers.getNumbers());
    }

    @Test
    public void givenEmptyNumbers_whenProcessNumbers_thenReturnProcessedNumbers() {
        // Given
        Numbers numbersOne = new Numbers();
        numbersOne.setNumbers(Collections.emptyList());
        Numbers numbersTwo = new Numbers();
        numbersTwo.setNumbers(Collections.emptyList());
        Numbers numbersThree = new Numbers();
        numbersThree.setNumbers(Collections.emptyList());

        List<Numbers> numbers = new ArrayList<>();
        numbers.add(numbersOne);
        numbers.add(numbersTwo);
        numbers.add(numbersThree);

        // When
        ResponseNumbers responseNumbers = processNumbersService.processNumbers(numbers);

        // Then
        List<Integer> expected = Collections.emptyList();
        Assertions.assertEquals(expected, responseNumbers.getNumbers());
    }


}
package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;
import com.zwink.challenge.models.ResponseNumbers;

import java.util.List;

public interface ProcessNumbersService {
    /**
     * Method that processes a given list of Numbers by merging them into one list, removing duplicates from the list
     * and sorting the list.
     * @param numbers Numbers that shall be processed.
     * @return Processed list of numbers is returned.
     */
    ResponseNumbers processNumbers(List<Numbers> numbers);
}

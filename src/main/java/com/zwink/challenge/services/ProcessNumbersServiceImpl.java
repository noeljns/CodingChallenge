package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;
import com.zwink.challenge.models.ResponseNumbers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProcessNumbersServiceImpl implements ProcessNumbersService {

    public ResponseNumbers processNumbers(List<Numbers> numbers) {
        List<Integer> mergedNumbers = mergeNumbers(numbers);
        List<Integer> numbersWithoutDuplicates = removeDuplicates(mergedNumbers);
        Collections.sort(numbersWithoutDuplicates);

        ResponseNumbers responseNumbers = new ResponseNumbers();
        responseNumbers.setNumbers(numbersWithoutDuplicates);
        return responseNumbers;
    }

    private List<Integer> mergeNumbers(List<Numbers> numbers) {
        List<Integer> mergedNumbers = new ArrayList<>();

        for (Numbers number : numbers) {
            mergedNumbers.addAll((number.getNumbers()));
        }
        return mergedNumbers;
    }

    private List<Integer> removeDuplicates(List<Integer> numbers) {
        Set<Integer> tmpSet = new HashSet<>(numbers);
        return new ArrayList<>(tmpSet);
    }


}

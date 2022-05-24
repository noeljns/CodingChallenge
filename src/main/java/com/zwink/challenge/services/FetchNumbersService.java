package com.zwink.challenge.services;

import com.zwink.challenge.models.Numbers;

import java.util.List;

public interface FetchNumbersService {
    /**
     * Method that fetches numbers by executing request calls based on specified urls.
     * @param urls Specified requests that are executed.
     * @return Numbers that have been fetched from a remote server.
     */
    List<Numbers> getNumbersByUrls(List<String> urls);
}

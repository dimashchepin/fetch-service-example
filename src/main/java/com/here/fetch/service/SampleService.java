package com.here.fetch.service;


/**
 * Interface for Service methods.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
public interface SampleService {

    /**
     * Determines if word is "right" (has letter frequency numbers, when sorted, in sequence.
     *
     * @param word word to be analyzed
     * @return true if word is "right" else false
     */
    boolean isWordRight(String word);
}

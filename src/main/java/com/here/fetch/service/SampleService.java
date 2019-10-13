package com.here.fetch.service;


/**
 * Interface for Service methods.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
public interface SampleService {

    /**
     * Determines if word is "pyramid" (has letter frequency numbers increasing, when sorted).
     *
     * @param word word to be analyzed
     * @return true if word is a "pyramid" else false
     */
    boolean isWordAPyramid(String word);

    /**
     * Displays main page information.
     *
     * @return info text
     */
    String displayInfo();

}

package com.here.fetch.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementation of Sample service interface.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
@Service
public class SampleServiceForWeb implements SampleService {

    /** Main page info */
    public static String DISPLAY_INFO = "This service is only to determine if the word is a pyramid - use [main-url]/pyramid/[word] to use it.";

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWordAPyramid(String word) {
        // split word into letters
        String[] arrayOfLetters = word.split("");
        // get map of letter frequencies
        Map<String, Integer> frequencies = generateWordFrequencies(arrayOfLetters);
        // list of frequency numbers - sorted
        ArrayList<Integer> frequencyList = new ArrayList<>(frequencies.values());
        Collections.sort(frequencyList);

        // if at least one difference in letter frequencies is not one -
        // - the word is not a pyramid. Consider word with one letter always a pyramid
        boolean wordRight = true;
        for(int i = 0;i < frequencyList.size();i++) {
            if (i > 0 && frequencyList.get(i) - frequencyList.get(i - 1) != 1) {
                wordRight = false;
            }
        }
        // if empty, not a pyramid word!
        return !word.isEmpty() && wordRight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String displayInfo() {
        return DISPLAY_INFO;
    }

    /**
     * Generate letter frequencies map.
     *
     * @param rt array of letters in the word
     * @return frequencies
     */
    private Map<String, Integer> generateWordFrequencies(String[] rt) {
        Map<String, Integer> freqs = new HashMap<>();
        for(String r : rt) {
            if (freqs.containsKey(r)){
                freqs.put(r, 1 + freqs.get(r));
            } else {
                freqs.put(r, 1);
            }
        }
        return freqs;
    }
}

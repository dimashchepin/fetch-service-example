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


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWordAPyramid(String word) {
        String[] rt = word.split("");
        Map<String, Integer> freqs = generateWordFrequencies(rt);
        ArrayList<Integer> freqLst = new ArrayList<>(freqs.values());
        Collections.sort(freqLst);
        boolean wordRight = true;
        for(int i = 0;i < freqLst.size();i++) {
            if (i > 0 && freqLst.get(i) - freqLst.get(i - 1) != 1) {
                wordRight = false;
            }
        }
        // if empty, not a pyramid word!
        return !word.isEmpty() && wordRight;
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

package com.here.fetch.controller;

import com.here.fetch.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Service controller.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
@RestController
public class SampleServiceController {

    @Autowired
    SampleService productService;

    /**
     * Service to analyze word letter frequency.
     *
     * @param word word to be analyzed
     * @return get response - "true" if word is "right" else "false"
     */
    @RequestMapping(value = "/letters/{word}")
    public ResponseEntity<Object> getRightWord(@PathVariable("word") String word) {
        return new ResponseEntity<>(productService.isWordRight(word), HttpStatus.OK);
    }

}
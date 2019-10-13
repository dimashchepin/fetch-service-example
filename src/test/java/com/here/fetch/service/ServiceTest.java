package com.here.fetch.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for sampleService class.
 *
 * @author Dmitriy Shternberg <dimashchepin@gmail.com>
 */
public class ServiceTest {

    private SampleServiceForWeb instance = new SampleServiceForWeb();

    @Test
    public void testIfNotPyramidWord() throws Exception {
        Boolean result = instance.isWordAPyramid("abba");
        Assert.assertEquals(result, false);
    }

    @Test
    public void testIfNotPyramidWordWhenEmpty() throws Exception {
        Boolean result = instance.isWordAPyramid("");
        Assert.assertEquals(result, false);
    }

    @Test
    public void testIfNotPyramidWordSecond() throws Exception {
        Boolean result = instance.isWordAPyramid("bandana");
        Assert.assertEquals(result, false);
    }

    @Test
    public void testIfPyramidWordSmall() throws Exception {
        Boolean result = instance.isWordAPyramid("ill");
        Assert.assertEquals(result, true);
    }

    @Test
    public void testIfPyramidWordMiddle() throws Exception {
        Boolean result = instance.isWordAPyramid("banana");
        Assert.assertEquals(result, true);
    }

}

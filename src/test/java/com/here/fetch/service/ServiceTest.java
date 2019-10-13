package com.here.fetch.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for sampleService class.
 *
 * @author Dmitriy Shternberg <dmitriy.shternberg@here.com>
 */
public class ServiceTest {

    private SampleServiceForWeb instance = new SampleServiceForWeb();

    @Test
    public void testLettersOutputWrong() throws Exception {
        Boolean result = instance.isWordRight("abba");
        Assert.assertEquals(result, false);
    }

    @Test
    public void testLettersOutputRight() throws Exception {
        Boolean result = instance.isWordRight("ill");
        Assert.assertEquals(result, true);
    }

}

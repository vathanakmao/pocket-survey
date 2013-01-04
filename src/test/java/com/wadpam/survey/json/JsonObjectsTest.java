/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadpam.survey.json;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 *
 * @author os
 */
public class JsonObjectsTest {
    
    HttpMessageConverter jackson = new MappingJacksonHttpMessageConverter();
    HttpMessageConverter form = new FormHttpMessageConverter();
    
    public JsonObjectsTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCanReadAnswer() {
        assertTrue("JAnswer", jackson.canRead(JAnswer.class, MediaType.APPLICATION_JSON));
//        assertTrue("String", form.canRead(String.class, MediaType.APPLICATION_FORM_URLENCODED));
//        assertTrue("Long", form.canRead(Long.class, MediaType.APPLICATION_FORM_URLENCODED));
//        assertTrue("JAnswer", form.canRead(JAnswer.class, null));
    }

    @Test
    public void testCanReadResponse() {
        assertTrue("JResponse", jackson.canRead(JResponse.class, MediaType.APPLICATION_JSON));
//        assertTrue("JResponse", form.canRead(JResponse.class, MediaType.APPLICATION_FORM_URLENCODED));
    }

}

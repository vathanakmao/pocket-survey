package com.goldengekko.wbt.web;

import com.wadpam.survey.json.JAnswer;
import java.net.URI;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class AnswerITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/response/v10/49548/";

    RestTemplate                         template;
    public AnswerITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        template = new RestTemplate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("answer", "MyAnswer");
        
        URI uri = template.postForLocation(BASE_URL + "answer/v10", 
                requestEntity);
        assertNotNull("createAnswer", uri);
        System.out.println("created answer URI is " + uri);
        
        JAnswer actual = template.getForObject(uri, JAnswer.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", Long.valueOf(4242), actual.getSurveyId());
    }

}

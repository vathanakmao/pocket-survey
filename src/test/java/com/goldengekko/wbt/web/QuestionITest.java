package com.goldengekko.wbt.web;

import com.wadpam.open.json.JMonitor;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import java.net.URI;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class QuestionITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/";
    static final String                  BASE_URL_SURVEY       = "http://localhost:8943/api/apidocs/survey/v10";

    RestTemplate                         template;
    public QuestionITest() {
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
    public void testCreateNotFound() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();

        try {
            URI uri = template.postForLocation(BASE_URL + "question/v10", 
                requestEntity);
            fail("Expected 404 Not Found");
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test
    public void testCreate() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.add("title", "Survey Title");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        
        requestEntity.clear();
        URI uri = template.postForLocation(BASE_URL_SURVEY + String.format("/%s/", survey.getId()) + "question/v10", 
                requestEntity);
        assertNotNull("createQuestion", uri);
        System.out.println("created question, URI is " + uri);
        
        JResponse actual = template.getForObject(uri, JResponse.class);
        assertNotNull("createdQuestion", actual);
        assertEquals("surveyId", survey.getId(), actual.getSurveyId().toString());
    }

}

package com.goldengekko.wbt.web;

import com.wadpam.survey.json.JOption;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import java.net.URI;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class OptionITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/question/v10/49548/";
    static final String                  BASE_URL_SURVEY       = "http://localhost:8943/api/apidocs/survey/v10";

    RestTemplate                         template;
    public OptionITest() {
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
        template.delete("http://localhost:8943/api/_admin/apidocs/deleteAllSurveyEntities");
    }

    @Test
    public void test1CreateNotFound() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("questionId", "1938424");
        requestEntity.set("label", "MyOptionLabel");
        
        try {
            URI uri = template.postForLocation(BASE_URL + "option/v10", 
                requestEntity);
            fail("Expected 404 Not Found");
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test
    public void test2CreateNoSuchQuestion() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        
        // now, POST an option
        requestEntity.set("questionId", "1938424");
        requestEntity.set("answer", "MyAnswer");
        try {
            URI uri = template.postForLocation(String.format("%s/question/v10/1938424/option/v10", surveyURI),
                requestEntity);
            fail("Expected 404 Not Found");
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test
    public void test3Create() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        
        // create a question
        requestEntity.clear();
        String baseUrlQuestion = BASE_URL_SURVEY + String.format("/%s/question/v10", survey.getId());
        URI questionURI = template.postForLocation(
                baseUrlQuestion,
                requestEntity);
        JQuestion question = template.getForObject(questionURI, JQuestion.class);

        // now, POST an option
        requestEntity.set("questionId", question.getId());
        requestEntity.set("label", "MyOptionLabel");
        URI uri = template.postForLocation(String.format("%s/option/v10", questionURI),
                requestEntity);
        assertNotNull("createOption", uri);
        System.out.println("created option URI is " + uri);
        
        JOption actual = template.getForObject(uri, JOption.class);
        assertNotNull("createdOption", actual);
        assertEquals("surveyId", Long.valueOf(survey.getId()), actual.getSurveyId());
        assertEquals("questionId", Long.valueOf(question.getId()), actual.getQuestionId());
    }

}

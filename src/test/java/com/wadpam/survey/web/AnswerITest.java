package com.wadpam.survey.web;

import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.json.JVersion;
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
public class AnswerITest {

    static final String                  BASE_URL_HOST = "http://localhost:8943";
    static final String                  BASE_URL_SURVEY = BASE_URL_HOST + "/api/apidocs/survey/v10";
    static final String                  BASE_URL = BASE_URL_SURVEY + "/4242/version/v10/5656/response/v10/49548/";

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
        System.out.println("========================= AnswerITest.setUp() ======");
    }

    @After
    public void tearDown() {
        template.delete("http://localhost:8943/api/_admin/apidocs/deleteAllSurveyEntities");
    }

    @Test
    public void testCreateNotFound() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("questionId", "1938424");
        requestEntity.set("answer", "MyAnswer");
        
        try {
            URI uri = template.postForLocation(BASE_URL + "answer/v10", 
                requestEntity);
            fail("Expected 404 Not Found");
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test
    public void testCreate() {
        System.out.println("====================== testCreate() ================");
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        final JVersion version = survey.getVersions().iterator().next();
        
        // and create a response
        requestEntity.clear();
        URI responseURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10", 
                requestEntity,
                survey.getId(), version.getId()
                );
        JResponse response = template.getForObject(responseURI, JResponse.class);

        // finally, create a question
        requestEntity.clear();
        URI questionURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10", 
                requestEntity,
                survey.getId(), version.getId()
                );
        JQuestion question = template.getForObject(questionURI, JQuestion.class);

        // now, POST an answer
        requestEntity.set("questionId", question.getId());
        requestEntity.set("answer", "MyAnswer");
        URI uri = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10",
                requestEntity,
                survey.getId(), version.getId(), response.getId());
        assertNotNull("createAnswer", uri);
        System.out.println("created answer URI is " + uri);
        
        JAnswer actual = template.getForObject(uri, JAnswer.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", Long.valueOf(survey.getId()), actual.getSurveyId());
        assertEquals("responseId", Long.valueOf(response.getId()), actual.getResponseId());
        assertEquals("questionId", Long.valueOf(question.getId()), actual.getQuestionId());
    }

    @Test
    public void testCreateNoSuchQuestion() {
        System.out.println("============= AnswerITest.testCreateNoSuchQuestion() ======");
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        final JVersion version = survey.getVersions().iterator().next();
        
        // and create a response
        requestEntity.clear();
        URI responseURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10",
                requestEntity,
                survey.getId(), version.getId());
        JResponse response = template.getForObject(responseURI, JResponse.class);

        System.out.println("------------- AnswerITest.testCreateNoSuchQuestion() ---------");
        // now, POST an answer
        requestEntity.set("questionId", "1938424");
        requestEntity.set("answer", "MyAnswer");
        try {
            URI uri = template.postForLocation(
                    BASE_URL_HOST + responseURI.getPath() + "/answer/v10",
                requestEntity,
                response.getId());
            fail();
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

}

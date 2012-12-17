package com.goldengekko.wbt.web;

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
public class ResponseITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/version/v10/5454/";
    static final String                  BASE_URL_SURVEY       = "http://localhost:8943/api/apidocs/survey/v10";

    RestTemplate                         template;
    public ResponseITest() {
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
    public void testCreateNotFound() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();

        try {
            URI uri = template.postForLocation(BASE_URL + "response/v10", 
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
        JVersion version = survey.getVersions().iterator().next();
        
        requestEntity.clear();
        
        URI uri = template.postForLocation(BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10", 
                requestEntity, survey.getId(), version.getId());
        assertNotNull("createResponse", uri);
        System.out.println("created response, URI is " + uri);
        
        JResponse actual = template.getForObject(uri, JResponse.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", survey.getId(), actual.getSurveyId().toString());
    }

    @Test
    public void testCreateWithAnswers() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.add("title", "Survey Title");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        JVersion version = survey.getVersions().iterator().next();
        
        // and, create a question
        requestEntity.clear();
        URI questionURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10", 
                requestEntity,
                survey.getId(), version.getId()
                );
        JQuestion question = template.getForObject(questionURI, JQuestion.class);

        requestEntity.clear();
        requestEntity.add("questionIds", question.getId());
        requestEntity.add("formAnswers", "MyInnerAnswer");
        URI uri = template.postForLocation(BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10", 
                requestEntity, survey.getId(), version.getId());
        assertNotNull("createResponse", uri);
        System.out.println("created response, URI is " + uri);
        
        JResponse actual = template.getForObject(uri, JResponse.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", survey.getId(), actual.getSurveyId().toString());
        assertNotNull("createdInnerAnswers", actual.getAnswers());
    }

}

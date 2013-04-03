package com.wadpam.survey.web;

import com.wadpam.survey.json.JOption;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.json.JVersion;
import java.net.URI;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class OptionITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/survey/v10/4242/version/v10/5252/question/v10/49548/";
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
        System.out.println("====================== setUp() =====================");
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
        JVersion version = survey.getVersions().iterator().next();
        
        // now, POST an option
//        requestEntity.set("questionId", "1938424");
        requestEntity.set("answer", "MyAnswer");
        try {
            URI uri = template.postForLocation(String.format("%s/version/v10/{versionId}/question/v10/1938424/option/v10", surveyURI),
                requestEntity, version.getId());
            fail("Expected 404 Not Found");
        }
        catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test
    public void test3Create() {
        System.out.println("- test3Create()");
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        JVersion version = survey.getVersions().iterator().next();
        
        // create a question
        requestEntity.clear();
        requestEntity.set("question", "What is the correct answer?");
        URI questionURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10",
                requestEntity,
                survey.getId(), version.getId());
        JQuestion question = template.getForObject(questionURI, JQuestion.class);

        // now, POST an option
        requestEntity.set("questionId", question.getId());
        requestEntity.set("label", "MyOptionLabel");
        URI uri = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10",
                requestEntity, survey.getId(), version.getId(), question.getId());
        assertNotNull("createOption", uri);
        System.out.println("created option URI is " + uri);
        
        JOption actual = template.getForObject(uri, JOption.class);
        assertNotNull("createdOption", actual);
        assertEquals("surveyId", Long.valueOf(survey.getId()), actual.getSurveyId());
        assertEquals("questionId", Long.valueOf(question.getId()), actual.getQuestionId());
    }

    @Test
    public void testCreateBatch() {
        System.out.println("- testCreateBatch()");
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "Survey Title for answer");
        
        // create a survey first
        URI surveyURI = template.postForLocation(BASE_URL_SURVEY, requestEntity);
        JSurvey survey = template.getForObject(surveyURI, JSurvey.class);
        assertNotNull(survey);
        JVersion version = survey.getVersions().iterator().next();
        
        // create a question
        requestEntity.clear();
        requestEntity.set("question", "What is the correct answer?");
        URI questionURI = template.postForLocation(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10",
                requestEntity,
                survey.getId(), version.getId());
        JQuestion question = template.getForObject(questionURI, JQuestion.class);

        // now, POST some options
        ArrayList<JOption> options = new ArrayList<JOption>();
        JOption jo;
        for (int i = 0; i < 10; i++) {
            jo = new JOption();
            jo.setQuestionId(Long.parseLong(question.getId()));
            jo.setLabel("Option #" + i);
            options.add(jo);
        }
        requestEntity.clear();
        requestEntity.set("jEntities", options);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(options, headers); //requestEntity, headers);
        
        ResponseEntity<Long[]> response = template.exchange(
                BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10/_batch",
                HttpMethod.POST,
                httpEntity, Long[].class, survey.getId(), version.getId(), question.getId());
        Long[] ids = response.getBody();
        assertNotNull("createOptions", ids);
        for (Long l : ids) {
            System.out.println("Batch-created option id is " + l);
        }
        
//        JOption actual = template.getForObject(uri, JOption.class);
//        assertNotNull("createdOption", actual);
//        assertEquals("surveyId", Long.valueOf(survey.getId()), actual.getSurveyId());
//        assertEquals("questionId", Long.valueOf(question.getId()), actual.getQuestionId());
    }

}

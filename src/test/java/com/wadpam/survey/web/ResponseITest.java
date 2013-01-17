package com.wadpam.survey.web;

import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.json.JVersion;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import org.codehaus.jackson.map.ObjectMapper;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
        System.out.println("----------------------------------- setUp() --------------------------");
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
        System.out.println("------------- testCreateWithAnswers() --------------");
        
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
        assertEquals("versionId", version.getId(), actual.getVersionId().toString());
        assertNotNull("createdInnerAnswers", actual.getAnswers());
        assertEquals("createdInnerAnswers", 1, actual.getAnswers().size());
    }

    @Test
    public void testCreateWithAnswersJSON() throws IOException {
        
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

        JResponse body = new JResponse();
        body.setExtProductId("myProduct");
        JAnswer answer = new JAnswer();
        answer.setQuestionId(Long.parseLong(question.getId()));
        answer.setAnswer("MyInnerAnswerJSON");
        body.setAnswers(Arrays.asList(answer));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("JResponse is " + mapper.writeValueAsString(body));
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<JResponse> requestBody = new HttpEntity<JResponse>(body, headers);
        URI uri = template.postForLocation(BASE_URL_SURVEY + "/{surveyId}/version/v10/{versionId}/response/v10", 
                requestBody, survey.getId(), version.getId());
        assertNotNull("createResponse", uri);
        System.out.println("created response, URI is " + uri);
        
        JResponse actual = template.getForObject(uri, JResponse.class);
        assertNotNull("createdResponse", actual);
        assertEquals("surveyId", survey.getId(), actual.getSurveyId().toString());
        assertEquals("versionId", version.getId(), actual.getVersionId().toString());
        assertNotNull("createdInnerAnswers", actual.getAnswers());
        assertEquals("createdInnerAnswers", 1, actual.getAnswers().size());
    }

}

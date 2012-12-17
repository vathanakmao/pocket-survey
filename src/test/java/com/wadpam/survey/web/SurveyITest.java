package com.wadpam.survey.web;

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
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author os
 */
public class SurveyITest {

    static final String                  BASE_URL       = "http://localhost:8943/api/apidocs/";

    RestTemplate                         template;
    public SurveyITest() {
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
    public void testCreate() {
        
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
        requestEntity.set("title", "MyTitle");
        
        URI uri = template.postForLocation(BASE_URL + "survey/v10", 
                requestEntity);
        assertNotNull("createSurvey", uri);
        
        JSurvey actual = template.getForObject(uri, JSurvey.class);
        assertNotNull("createdSurvey", actual);
        assertEquals("survey.title", "MyTitle", actual.getTitle());
        
    }

}

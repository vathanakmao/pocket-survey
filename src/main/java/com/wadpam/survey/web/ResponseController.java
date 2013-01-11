package com.wadpam.survey.web;

import com.wadpam.survey.service.SurveyService;
import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.exceptions.NotFoundException;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.mardao.core.CursorPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author os
 */
@RestReturn(value=JResponse.class)
@Controller
@RequestMapping("{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response")
public class ResponseController {
    public static final int ERR_RESPONSE_GET_NOT_FOUND = SurveyService.ERR_RESPONSE + 1;
    public static final int ERR_CREATE_NOT_FOUND = SurveyService.ERR_RESPONSE + 2;
    public static final int ERR_CREATE_CONFLICT = SurveyService.ERR_RESPONSE + 3;
    
    public static final String NAME_LOCATION = "Location";
    public static final String NAME_X_REQUESTED_WITH = "X-Requested-With";
    public static final String VALUE_X_REQUESTED_WITH_AJAX = "XMLHttpRequest";
    
    static final Logger LOG = LoggerFactory.getLogger(ResponseController.class);
    
    static final Converter CONVERTER = new Converter();
    
    private SurveyService service;
    
    /**
     * Creates an entity, from a form-encoded POST
     * @param jResponse the JResponse body 
     * @param formAnswers if form-encoded, these are the inner answers
     * @param questionIds if form-encoded, these are the inner questionIds to answers
     * @return a redirect to the created entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=201, description="The entity was created by AJAX", message="Created"),
        @RestCode(code=302, description="The entity was created", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public RedirectView createFromForm(
            @RequestHeader(value=ResponseController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @ModelAttribute JResponse jResponse,
            @RequestParam(required=false) String[] formAnswers,
            @RequestParam(required=false) Long[] questionIds
            ) {
        patchJResponse(jResponse, surveyId, versionId, formAnswers, questionIds);
        
        final DResponse dEntity = service.upsertResponse(jResponse);

        // AJAX request? Respond with 201 Created + Location header.
        if (ResponseController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.CREATED.value());
            final String path = String.format("v10/%d", 
                    dEntity.getId());
            response.addHeader(NAME_LOCATION, path);
            return null;
        }
        
        final String relative = String.format("v10/%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
    }
        
    /**
     * Creates an entity, from a json POST
     * @param jResponse the JResponse body 
     * @return a redirect to the created entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=201, description="The entity was created by AJAX", message="Created"),
        @RestCode(code=302, description="The entity was created", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.POST, consumes="application/json")
    public RedirectView createFromJSON(
            @RequestHeader(value=ResponseController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @RequestBody JResponse jResponse
            ) {
        return createFromForm(xRequestedWith, response, domain, surveyId, versionId, jResponse, null, null);
    }
        
    /**
     * Deletes an entity (cross-domain)
     * @param id
     * @return No Content, only the HTTP response code
     */
    @RestReturn(value=JSurvey.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteResponse(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /**
     * Deletes an entity (jsonp)
     * @param id
     * @return No Content, only the HTTP response code
     */
    @RestReturn(value=JSurvey.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.GET, params={"_method=DELETE"})
    public ResponseEntity deleteJsonp(@PathVariable Long id) {
        return delete(id);
    }
    
    /**
     * Loads the specified entity.
     * @param id the id of the entity to retrieve
     * @return the loaded JSON object
     */
    @RestReturn(value=JResponse.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.GET)
    @ResponseBody
    public JResponse get(
            @PathVariable Long id) {
        final DResponse entity = service.getResponse(id);
        if (null == entity) {
            throw new NotFoundException(ERR_RESPONSE_GET_NOT_FOUND, 
                    "Not a server error, perhaps a client one",
                    null, 
                    String.format("There is no Entity with id %d", id));
        }
        final JResponse body = Converter.convert(entity);
        
        // inner answers to include?
        if (null != body) {
            Iterable<DAnswer> dAnswers = service.getAnswersByResponse(id);
            List<JAnswer> jAnswers = (List<JAnswer>) CONVERTER.convert(dAnswers);
            body.setAnswers(jAnswers);
        }
        
        return body;
    }
    
    /**
     * Queries for a (next) page of entities
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JCursorPage.class, entity=JResponse.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JResponse> getPage(
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        final CursorPage<DResponse, Long> page = service.getResponsesPage(pageSize, cursorKey);
        final JCursorPage body = CONVERTER.convertPage(page);

        return body;
    }
    
    /**
     * Queries for a (next) page of entities, all related to specified meeting.
     * @param extMeetingId the specified meeting's external id
     * @param answers set to true to get inner answers
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JCursorPage.class, entity=JResponse.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET, params="extMeetingId")
    @ResponseBody
    public JCursorPage<JResponse> getPageByExtMeetingId(
            @RequestParam String extMeetingId,
            @RequestParam(defaultValue="false") boolean answers, 
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        final CursorPage<DResponse, Long> page = service.getResponsesPageByExtMeetingId(
                extMeetingId, pageSize, cursorKey);
        final JCursorPage<JResponse> body = (JCursorPage<JResponse>) CONVERTER.convertPage(page);

        // inner answers to include?
        if (answers) {
            HashMap<Long, JResponse> ids = new HashMap<Long, JResponse>();
            for (JResponse j : body.getItems()) {
                ids.put(Long.parseLong(j.getId()), j);
            }
            
            if (!ids.isEmpty()) {
                Iterable<DAnswer> dAnswers = service.getAnswersByResponseIds(ids.keySet());
                List<JAnswer> jAnswers = (List<JAnswer>) CONVERTER.convert(dAnswers);
                
                // distribute all answers to correct JResponse
                JResponse jResponse;
                List<JAnswer> inner;
                for (JAnswer da : jAnswers) {
                    jResponse = ids.get(da.getResponseId());
                    inner = jResponse.getAnswers();
                    if (null == inner) {
                        inner = new ArrayList<JAnswer>();
                        jResponse.setAnswers(inner);
                    }
                    inner.add(da);
                }
            }
        }
        
        return body;
    }
    
    protected void patchJResponse(JResponse jResponse, Long surveyId, Long versionId,
            String[] formAnswers, Long[] questionIds) {
        if (null == jResponse.getSurveyId() && null != surveyId) {
            jResponse.setSurveyId(surveyId);
        }
        if (null == jResponse.getVersionId() && null != versionId) {
            jResponse.setVersionId(versionId);
        }
        if (null == jResponse.getAnswers() && null != formAnswers && null != questionIds) {
            ArrayList<JAnswer> answers = new ArrayList<JAnswer>();
            int i = 0;
            for (Long id : questionIds) {
                JAnswer a = new JAnswer();
                a.setAnswer(formAnswers[i]);
                a.setQuestionId(id);
                a.setSurveyId(jResponse.getSurveyId());
                a.setVersionId(jResponse.getVersionId());
                
                answers.add(a);
                
                i++;
            }
            
            jResponse.setAnswers(answers);
        }
    }

    /**
     * Updates an entity.
     * @param id the id of the entity to updateFromForm
     * @param jEntity the JSON object for this updated entity
     * @param formAnswers if form-encoded, these are the inner answers
     * @param questionIds if form-encoded, these are the inner questionIds to answers
     * @return a redirect to the updated entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=204, description="The entity was updated by AJAX", message="No Content"),
        @RestCode(code=302, description="The entity was updated", message="OK")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public RedirectView updateFromForm(
            @RequestHeader(value=ResponseController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @PathVariable Long id,
            @ModelAttribute JResponse jEntity,
            @RequestParam(required=false) String[] formAnswers,
            @RequestParam(required=false) Long[] questionIds
            ) {
        patchJResponse(jEntity, surveyId, versionId, formAnswers, questionIds);
        
        final DResponse dEntity = service.upsertResponse(jEntity);
        
        // AJAX request? Respond with 204 No Content.
        if (ResponseController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return null;
        }
        
        final String relative = String.format("%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
    }

    /**
     * Updates an entity.
     * @param id the id of the entity to updateFromForm
     * @param jEntity the JSON object for this updated entity
     * @param formAnswers if form-encoded, these are the inner answers
     * @param questionIds if form-encoded, these are the inner questionIds to answers
     * @return a redirect to the updated entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=204, description="The entity was updated by AJAX", message="No Content"),
        @RestCode(code=302, description="The entity was updated", message="OK")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.POST, consumes="application/json")
    public RedirectView updateFromJSON(
            @RequestHeader(value=ResponseController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @PathVariable Long id,
            @RequestBody JResponse jEntity
            ) {
        return updateFromForm(xRequestedWith, response, surveyId, versionId, id, jEntity, null, null);
    }

    public void setService(SurveyService service) {
        this.service = service;
    }

}

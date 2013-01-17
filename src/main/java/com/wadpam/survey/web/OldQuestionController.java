package com.wadpam.survey.web;

import com.wadpam.survey.service.SurveyService;
import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.exceptions.NotFoundException;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.json.JQuestion;
import java.io.Serializable;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;
import net.sf.mardao.core.CursorPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RestReturn(value=JQuestion.class)
@Controller
@RequestMapping("{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question")
public class OldQuestionController {
    public static final int ERR_GET_NOT_FOUND = SurveyService.ERR_QUESTION + 1;
    public static final int ERR_CREATE_NOT_FOUND = SurveyService.ERR_QUESTION + 2;
    public static final int ERR_CREATE_CONFLICT = SurveyService.ERR_QUESTION + 3;
    
    public static final String NAME_LOCATION = "Location";
    public static final String NAME_X_REQUESTED_WITH = "X-Requested-With";
    public static final String VALUE_X_REQUESTED_WITH_AJAX = "XMLHttpRequest";
    
    static final Logger LOG = LoggerFactory.getLogger(OldQuestionController.class);
    
    static final Converter CONVERTER = new Converter();
    
    private SurveyService service;
    
    /**
     * Creates an entity.
     * @param domain the domain (used for Multi-tenancy)
     * @param surveyId the survey's id
     * @return a redirect to the created entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=201, description="The entity was created by AJAX", message="Created"),
        @RestCode(code=302, description="The entity was created", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.POST)
    public RedirectView create(
                        @RequestHeader(value=OldQuestionController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @ModelAttribute JQuestion jEntity
            ) {
        
        final DQuestion dEntity = service.createQuestion(Converter.convert(jEntity));

        // AJAX request? Respond with 201 Created + Location header.
        if (OldQuestionController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
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
     * Loads the specified entity.
     * @param domain the domain (used for Multi-tenancy)
     * @param surveyId the survey's id
     * @param versionId the version's id
     * @param id the id of the entity to retrieve
     * @return the loaded JSON object
     */
    @RestReturn(value=JQuestion.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.GET)
    @ResponseBody
    public JQuestion get(
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @PathVariable Long id) {
        final DQuestion entity = service.getQuestion(id);
        if (null == entity) {
            throw new NotFoundException(ERR_GET_NOT_FOUND, 
                    "Not a server error, perhaps a client one",
                    null, 
                    String.format("There is no Entity with id %d", id));
        }
        final JQuestion body = Converter.convert(entity);
        
        return body;
    }
    
    /**
     * Queries for a (next) page of entities
     * @param domain the domain (used for Multi-tenancy)
     * @param surveyId the survey's id
     * @param versionId the version's id
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JCursorPage.class, entity=JQuestion.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JQuestion> getPage(
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        final CursorPage<DQuestion, Long> page = service.getQuestionsPage( 
                versionId, pageSize, cursorKey);
        LOG.info("getQuestionsPage(queried {})", page.getItems().size());
        final JCursorPage body = CONVERTER.convertPage(page);

        return body;
    }
    
    /**
     * Updates an entity.
     * @param domain the domain (used for Multi-tenancy)
     * @param surveyId the survey's id
     * @param versionId the version's id
     * @param id the id of the entity to update
     * @param jEntity the JSON object for this updated entity
     * @return a redirect to the updated entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=204, description="The entity was updated by AJAX", message="No Content"),
        @RestCode(code=302, description="The entity was updated", message="OK")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.POST)
    public RedirectView update(
                        @RequestHeader(value=OldQuestionController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @PathVariable Long versionId,
            @PathVariable Long id,
            @ModelAttribute JQuestion jEntity
            ) {
        
        final DQuestion dEntity = service.updateQuestion(Converter.convert(jEntity));
        
        // AJAX request? Respond with 204 No Content.
        if (OldQuestionController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return null;
        }
        
        final String relative = String.format("%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
    }

    public void setService(SurveyService service) {
        this.service = service;
    }

}

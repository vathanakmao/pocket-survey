package com.wadpam.survey.web;

import com.wadpam.survey.service.SurveyService;
import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.exceptions.BadRequestException;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.exceptions.NotFoundException;
import com.wadpam.survey.domain.DOption;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JOption;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.json.JVersion;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.mardao.core.CursorPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestReturn(value=JSurvey.class)
@Controller
@RequestMapping("{domain}/survey")
public class OldSurveyController {
    public static final int ERR_SURVEY_GET_NOT_FOUND = SurveyService.ERR_SURVEY + 1;
    public static final int ERR_CREATE_CONFLICT = SurveyService.ERR_SURVEY + 2;
    
    public static final String NAME_LOCATION = "Location";
    public static final String NAME_X_REQUESTED_WITH = "X-Requested-With";
    public static final String VALUE_X_REQUESTED_WITH_AJAX = "XMLHttpRequest";
    
    static final Logger LOG = LoggerFactory.getLogger(OldSurveyController.class);
    
    static final Converter CONVERTER = new Converter();
    
    private SurveyService service;
    
    /**
     * Creates an entity.
     * @return a redirect to the created entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=201, description="The entity was created by AJAX", message="Created"),
        @RestCode(code=302, description="The entity was created", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.POST)
    public RedirectView create(
                                                @RequestHeader(value=OldSurveyController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @ModelAttribute JSurvey survey
            ) {
        
        final DSurvey dEntity = service.createSurvey(Converter.convert(survey));

        // AJAX request? Respond with 201 Created + Location header.
        if (OldSurveyController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.CREATED.value());
            final String path = String.format("/api/%s/location/v10/%d", 
                    domain, dEntity.getId());
            response.addHeader(NAME_LOCATION, path);
            return null;
        }
        
        final String relative = String.format("v10/%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
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
        service.deleteSurvey(id);
        
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
    @RestReturn(value=JSurvey.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.GET)
    @ResponseBody
    public JSurvey get(
            @PathVariable Long id) {
        final DSurvey entity = service.getSurvey(id);
        if (null == entity) {
            throw new NotFoundException(ERR_SURVEY_GET_NOT_FOUND, 
                    "Not a server error, perhaps a client one",
                    null, 
                    String.format("There is no Entity with id %d", id));
        }
        final JSurvey body = Converter.convert(entity);
        
        // fetch all options, map QuestionId -> jOption
        final Map<Long, Collection<JOption>> optMap = new HashMap<Long, Collection<JOption>>();
        Collection<JOption> opts;
        JOption jo;
        final Iterable<DOption> options = service.getOptionsBySurvey(id);
        for (DOption d : options) {
            jo = Converter.convert(d);
            opts = optMap.get(jo.getQuestionId());
            if (null == opts) {
                opts = new ArrayList<JOption>();
                optMap.put(jo.getQuestionId(), opts);
            }
            opts.add(jo);
        }
        
        // fetch all questions, map VersionId -> jQuestion
        final Map<Long, Collection<JQuestion>> questMap = new HashMap<Long, Collection<JQuestion>>();
        Collection<JQuestion> quests;
        JQuestion jq;
        final Iterable<DQuestion> questions = service.getQuestionsBySurvey(id);
        for (DQuestion q : questions) {
            jq = Converter.convert(q);
            jq.setOptions(optMap.get(jq.getId()));
            quests = questMap.get(jq.getVersionId());
            if (null == quests) {
                quests = new ArrayList<JQuestion>();
                questMap.put(jq.getVersionId(), quests);
            }
            quests.add(jq);
        }
        
        final Collection<JVersion> jVersions = new ArrayList<JVersion>();
        JVersion jv;
        final Iterable<DVersion> versions = service.getVersionsBySurvey(id);
        for (DVersion d : versions) {
            jv = Converter.convert(d);
            // pick up the mapped questions for this version
            jv.setQuestions(questMap.get(d.getId()));
            jVersions.add(jv);
        }
        body.setVersions(jVersions);
        
        return body;
    }
    
    /**
     * Queries for a (next) page of entities
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JCursorPage.class, entity=JSurvey.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JSurvey> getPage(
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        try {
        final CursorPage<DSurvey, Long> page = service.getSurveysPage(pageSize, cursorKey);
        final JCursorPage body = CONVERTER.convertPage(page);

        return body;
        }
        catch (Exception e) {
            LOG.error("This is it", e);
        }
        throw new BadRequestException(-1, "getPage");
    }
    
    /**
     * Updates an entity.
     * @param id the id of the entity to update
     * @param jEntity the JSON object for this updated entity
     * @return a redirect to the updated entity
     */
    @RestReturn(value=URL.class, code={
        @RestCode(code=204, description="The entity was updated by AJAX", message="No Content"),
        @RestCode(code=302, description="The entity was updated", message="OK")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.POST)
    public RedirectView update(
                                                @RequestHeader(value=OldSurveyController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable Long id,
            @ModelAttribute JSurvey jEntity
            ) {
        
        final DSurvey dEntity = service.updateSurvey(Converter.convert(jEntity));
        
        // AJAX request? Respond with 204 No Content.
        if (OldSurveyController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
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

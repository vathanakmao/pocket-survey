package com.wadpam.survey.web;

import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.exceptions.NotFoundException;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DOption;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JOption;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JVersion;
import com.wadpam.survey.service.SurveyService;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
@RestReturn(value=JVersion.class)
@Controller
@RequestMapping("{domain}/survey/v10/{surveyId}/version")
public class VersionController {
    public static final int ERR_SURVEY_GET_NOT_FOUND = SurveyService.ERR_SURVEY + 1;
    public static final int ERR_CREATE_CONFLICT = SurveyService.ERR_SURVEY + 2;
    
    public static final String NAME_LOCATION = "Location";
    public static final String NAME_X_REQUESTED_WITH = "X-Requested-With";
    public static final String VALUE_X_REQUESTED_WITH_AJAX = "XMLHttpRequest";
    
    static final Logger LOG = LoggerFactory.getLogger(VersionController.class);
    
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
            @RequestHeader(value=VersionController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable String domain,
            @PathVariable Long surveyId,
            @RequestParam Long fromVersionId,
            @RequestParam String description
            ) {
        
        final DVersion dEntity = service.createVersion(surveyId, fromVersionId, description);

        // AJAX request? Respond with 201 Created + Location header.
        if (VersionController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.CREATED.value());
            final String path = String.format("/api/%s/survey/v10/%d/version/v10/%d", 
                    domain, surveyId, dEntity.getId());
            response.addHeader(NAME_LOCATION, path);
            return null;
        }
        
        final String relative = String.format("v10/%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
    }
    
    /**
     * Loads the specified entity.
     * @param id the id of the entity to retrieve
     * @return the loaded JSON object
     */
    @RestReturn(value=JVersion.class, code={
        @RestCode(code=200, description="The entity was found", message="OK"),
        @RestCode(code=404, description="The entity was not found", message="Not Found")})
    @RequestMapping(value="v10/{id}", method= RequestMethod.GET)
    @ResponseBody
    public JVersion get(
            @PathVariable Long id) {
        final DVersion entity = service.getVersion(id);
        if (null == entity) {
            throw new NotFoundException(ERR_SURVEY_GET_NOT_FOUND, 
                    "Not a server error, perhaps a client one",
                    null, 
                    String.format("There is no Entity with id %d", id));
        }
        final JVersion body = Converter.convert(entity);
        
        // fetch all questions
        final Iterable<DQuestion> questions = service.getQuestionsByVersion(id);
        final Collection<JQuestion> jQuestions = new ArrayList<JQuestion>();
        body.setQuestions(jQuestions);
        
        // fetch all options
        final Iterable<DOption> options = service.getOptionsByVersion(id);
        final Map<Long, Collection<JOption>> optMap = new HashMap<Long, Collection<JOption>>();
        Collection<JOption> opts;
        JOption jo;
        for (DOption d : options) {
            jo = Converter.convert(d);
            opts = optMap.get(jo.getQuestionId());
            if (null == opts) {
                opts = new ArrayList<JOption>();
                optMap.put(jo.getQuestionId(), opts);
            }
            opts.add(jo);
        }
        
        JQuestion jq;
        for (DQuestion d : questions) {
            jq = Converter.convert(d);
            jQuestions.add(jq);
            jq.setOptions(optMap.get(d.getId()));
        }
        
        return body;
    }
    
    /**
     * Queries for a (next) page of entities
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JAnswer.class, entity=JAnswer.class, code={
        @RestCode(code=200, description="A CSV with JSON entities", message="OK")})
    @RequestMapping(value="v10/{versionId}/csv", method= RequestMethod.GET)
    public void getCsv(HttpServletResponse response,
            @PathVariable String domain, 
            @PathVariable Long versionId) throws IOException {
        // get the full JVersion definition
        final JVersion jVersion = get(versionId);
        
        final Iterable<DAnswer> answers = service.getAnswersByVersion(versionId);
        
        response.setContentType("text/csv");
        PrintWriter pw = response.getWriter();
        
        writeAnswersAsCsv(pw, answers, jVersion);
        
        pw.close();
    }
    
    /**
     * Queries for a (next) page of entities
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @RestReturn(value=JCursorPage.class, entity=JVersion.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JVersion> getPage(
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        final CursorPage<DVersion, Long> page = service.getVersionsPage(pageSize, cursorKey);
        final JCursorPage body = CONVERTER.convertPage(page);

        return body;
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
                                                @RequestHeader(value=VersionController.NAME_X_REQUESTED_WITH, required=false) String xRequestedWith,
            HttpServletResponse response,
            @PathVariable Long id,
            @ModelAttribute JVersion jEntity
            ) {
        
        final DVersion dEntity = service.updateVersion(Converter.convert(jEntity));
        
        // AJAX request? Respond with 204 No Content.
        if (VersionController.VALUE_X_REQUESTED_WITH_AJAX.equals(xRequestedWith)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return null;
        }
        
        final String relative = String.format("%d", dEntity.getId());
        final RedirectView returnValue = new RedirectView(relative, true);
        return returnValue;
    }

    protected static void writeAnswersAsCsv(PrintWriter pw, Iterable<DAnswer> answers, JVersion jVersion) {
        
        final Map<String, JQuestion> questionsMap = new HashMap<String, JQuestion>();
        final Map<String, JOption> optionsMap = new HashMap<String, JOption>();
        for (JQuestion q : jVersion.getQuestions()) {
            questionsMap.put(q.getId(), q);
            if (null != q.getOptions()) {
                for (JOption o : q.getOptions()) {
                    optionsMap.put(o.getId(), o);
                }
            }
        }
        
        final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        final String FORMAT = "%s,%s,%s,%s,%s,%s,%s,%s";
        
        pw.println(String.format(FORMAT, "versionId", "responseId", "questionId", 
                "user", "lastUpdated", "answerType", "answer", "label"));
        
        JQuestion q;
        JOption o;
        for (DAnswer a : answers) {
            q = questionsMap.get(a.getQuestion().getId().toString());
            o = optionsMap.get(a.getAnswer().toString());
            pw.println(String.format(FORMAT, 
                    a.getVersion().getId(), a.getResponse().getId(), a.getQuestion().getId(),
                    a.getUpdatedBy(), SDF.format(a.getUpdatedDate()), 
                    q.getType(), a.getAnswer(), null != o ? o.getLabel() : ""));
        }
    }

    public void setService(SurveyService service) {
        this.service = service;
    }

}

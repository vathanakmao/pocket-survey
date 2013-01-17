/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.web;

import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.service.QuestionService;
import com.wadpam.survey.service.SurveyService;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import net.sf.mardao.core.CursorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sosandstrom
 */
@Controller
@RequestMapping("{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question")
public class QuestionController extends CrudController<JQuestion, 
        DQuestion, 
        Long, 
        QuestionService> {

    @Autowired
    protected SurveyService surveyService;
    
    
    /**
     * Queries for a (next) page of entities
     * @param pageSize default is 10
     * @param cursorKey null to get first page
     * @return a page of entities
     */
    @Override
    @RestReturn(value=JCursorPage.class, code={
        @RestCode(code=200, description="A CursorPage with JSON entities", message="OK")})
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JQuestion> getPage(HttpServletRequest request, 
            @PathVariable String surveyId, 
            @PathVariable Long versionId, 
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        CursorPage<DQuestion, Long> page = surveyService.getQuestionsPage(versionId, pageSize, cursorKey);
        return convertPage(page);
    }
    
    // ---------------- Converter and setters ------------------------------

    @Override
    public JQuestion convertDomain(DQuestion from) {
        if (null == from) {
            return null;
        }
        
        final JQuestion to = new JQuestion();
        convertLongEntity(from, to);

        to.setOrdering(from.getOrdering());
        to.setQuestion(from.getQuestion());
        to.setRequired(from.getRequired());
        to.setType(from.getType());
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        to.setVersionId(null != from.getVersion() ? from.getVersion().getId() : null);
        
        return to;
    }

    @Override
    public DQuestion convertJson(JQuestion from) {
        if (null == from) {
            return null;
        }
        
        final DQuestion to = new DQuestion();
        convertJLong(from, to);

        to.setOrdering(from.getOrdering());
        to.setQuestion(from.getQuestion());
        to.setRequired(from.getRequired());
        to.setType(from.getType());
        if (null != from.getSurveyId()) {
            final DSurvey survey = new DSurvey();
            survey.setId(from.getSurveyId());
            to.setSurvey(survey);
        }
        if (null != from.getVersionId()) {
            final DVersion version = new DVersion();
            version.setId(from.getVersionId());
            to.setVersion(version);
        }
        
        return to;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.service = questionService;
    }
}

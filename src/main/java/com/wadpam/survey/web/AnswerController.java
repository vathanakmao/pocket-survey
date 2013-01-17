/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.web;

import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.service.AnswerService;
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
@RequestMapping("{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer")
public class AnswerController extends CrudController<JAnswer, 
        DAnswer, 
        Long, 
        AnswerService> {
    
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
    public JCursorPage<JAnswer> getPage(
            HttpServletRequest request,
            @PathVariable String versionId,
            @PathVariable Long responseId,
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        final CursorPage<DAnswer, Long> page = surveyService.getAnswersPage(responseId, pageSize, cursorKey);
        final JCursorPage<JAnswer> body = convertPage(page);

        return body;
    }
    
    // ------------------------- Converter and setters -------------------------

    @Override
    public JAnswer convertDomain(DAnswer from) {
        if (null == from) {
            return null;
        }
        
        final JAnswer to = new JAnswer();
        convertLongEntity(from, to);
        
        to.setAnswer(from.getAnswer());
        to.setQuestionId(null != from.getQuestion() ? from.getQuestion().getId() : null);
        to.setResponseId(null != from.getResponse() ? from.getResponse().getId() : null);
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        to.setVersionId(null != from.getVersion() ? from.getVersion().getId() : null);
        
        return to;
    }

    @Override
    public DAnswer convertJson(JAnswer from) {
        if (null == from) {
            return null;
        }
        
        final DAnswer to = new DAnswer();
        convertJLong(from, to);

        to.setAnswer(from.getAnswer());
        if (null != from.getQuestionId()) {
            final DQuestion foreign = new DQuestion();
            foreign.setId(from.getQuestionId());
            to.setQuestion(foreign);
        }
        if (null != from.getResponseId()) {
            final DResponse foreign = new DResponse();
            foreign.setId(from.getResponseId());
            to.setResponse(foreign);
        }
        if (null != from.getSurveyId()) {
            final DSurvey foreign = new DSurvey();
            foreign.setId(from.getSurveyId());
            to.setSurvey(foreign);
        }
        if (null != from.getVersionId()) {
            final DVersion version = new DVersion();
            version.setId(from.getVersionId());
            to.setVersion(version);
        }
        
        return to;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.service = answerService;
    }
}

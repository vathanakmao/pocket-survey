/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DQuestionDao;
import com.wadpam.survey.domain.DQuestion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosandstrom
 */
public class QuestionService extends MardaoCrudService<DQuestion, Long, DQuestionDao> {

    protected SurveyService surveyService;
    
    @Override
    public Long create(DQuestion domain) {
        surveyService.createQuestion(domain);
        return domain.getId();
    }
    
    @Autowired
    public void setDQuestionDao(DQuestionDao dQuestionDao) {
        this.dao = dQuestionDao;
    }

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}

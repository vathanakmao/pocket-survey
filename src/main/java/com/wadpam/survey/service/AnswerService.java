/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DAnswerDao;
import com.wadpam.survey.domain.DAnswer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosandstrom
 */
public class AnswerService extends MardaoCrudService<DAnswer, Long, DAnswerDao> {
    
    protected SurveyService surveyService;

    @Override
    public Long create(DAnswer domain) {
        surveyService.createAnswer(domain);
        return domain.getId();
    }
    
    @Autowired
    public void setDAnswerDao(DAnswerDao dAnswerDao) {
        this.dao = dAnswerDao;
    }

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}

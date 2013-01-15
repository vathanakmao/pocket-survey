package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.domain.DSurvey;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author os
 */
public class SurveyCrudService extends MardaoCrudService<DSurvey, Long, DSurveyDao> {
    
    /** For business logic */
    @Autowired
    private SurveyService surveyService;

    /**
     * surveyService also creates a first version.
     */
    @Override
    public Long create(DSurvey domain) {
        surveyService.createSurvey(domain);
        return domain.getId();
    }
    
    @Autowired
    public void setDSurveyDao(DSurveyDao dSurveyDao) {
        this.dao = dSurveyDao;
    }
}

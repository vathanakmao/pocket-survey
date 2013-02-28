package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author os
 */
public class SurveyCrudService extends MardaoCrudService<DSurvey, Long, DSurveyDao> {
    
    /** For business logic */
    private SurveyService surveyService;

    /**
     * surveyService also creates a first version.
     */
    @Override
    public Long create(DSurvey domain) {
        surveyService.createSurvey(domain);
        return domain.getId();
    }
    
    public DVersion cloneVersion(Long surveyId, Long fromVersionId, String description) {
        return surveyService.cloneVersion(surveyId, fromVersionId, description);
    }

    @Autowired
    public void setDSurveyDao(DSurveyDao dSurveyDao) {
        this.dao = dSurveyDao;
    }

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}

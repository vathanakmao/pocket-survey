package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DVersionDao;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author os
 */
public class VersionService extends MardaoCrudService<DVersion, Long, DVersionDao> {
    /** For business logic */
    private SurveyService surveyService;

    public Iterable<DVersion> queryBySurveyId(Long surveyId) {
        final DSurvey survey = new DSurvey();
        survey.setId(surveyId);
        return dao.queryBySurvey(survey);
    }

    @Autowired
    public void setDVersionDao(DVersionDao dVersionDao) {
        this.dao = dVersionDao;
    }

    @Override
    public void delete(String parentKeyString, Long id) {
        surveyService.deleteVersion(id);
    }

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}

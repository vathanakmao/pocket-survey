package com.wadpam.survey.service;

import com.wadpam.survey.dao.DAnswerDao;
import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.dao.DResponseDao;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.domain.DSurvey;
import java.io.Serializable;
import net.sf.mardao.core.CursorPage;

/**
 *
 * @author os
 */
public class SurveyService {

    public static final String DOMAIN_APIDOCS = "apidocs";
    
    /** Base offset for survey resource errors (101000) */
    public static final int ERR_SURVEY = 101000;
    /** Base offset for response resource errors (102000) */
    public static final int ERR_RESPONSE = 102000;
    
    private DAnswerDao answerDao;
    private DResponseDao responseDao;
    private DSurveyDao surveyDao;
    
    public void init() {
    }
    
    public DAnswer createAnswer(Long responseId, Long surveyId, DAnswer dEntity) {
        answerDao.persist(dEntity);
        return dEntity;
    }
    
    public DResponse createResponse(Long surveyId, DResponse dEntity) {
        responseDao.persist(dEntity);
        return dEntity;
    }
    
    public DSurvey createSurvey(DSurvey dEntity) {
        surveyDao.persist(dEntity);
        return dEntity;
    }
    
    public DAnswer getAnswer(Long id) {
        final DAnswer entity = answerDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DAnswer, Long> getAnswersPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DAnswer, Long> page = answerDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DResponse getResponse(Long id) {
        final DResponse entity = responseDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DResponse, Long> getResponsesPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DResponse, Long> page = responseDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DSurvey getSurvey(Long id) {
        final DSurvey entity = surveyDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DSurvey, Long> getSurveysPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DSurvey, Long> page = surveyDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DAnswer updateAnswer(DAnswer dEntity) {
        answerDao.update(dEntity);
        return dEntity;
    }

    public DResponse updateResponse(DResponse dEntity) {
        responseDao.update(dEntity);
        return dEntity;
    }

    public DSurvey updateSurvey(DSurvey dEntity) {
        surveyDao.update(dEntity);
        return dEntity;
    }

    public void setAnswerDao(DAnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public void setResponseDao(DResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    public void setSurveyDao(DSurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

}

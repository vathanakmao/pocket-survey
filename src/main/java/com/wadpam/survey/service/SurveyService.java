package com.wadpam.survey.service;

import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.domain.DSurvey;
import java.io.Serializable;
import net.sf.mardao.core.CursorPage;

/**
 *
 * @author os
 */
public class SurveyService {

    public static final String DOMAIN_APIDOCS = "apidocs";
    
    /** Base offset for survey resource errors (1000) */
    public static final int ERR_SURVEY = 1000;
    /** Base offset for profile resource errors (2000) */
    public static final int ERR_PROFILE = 2000;
    /** Base offset for store resource errors (3000) */
    public static final int ERR_LOCATION = 3000;
    /** Base offset for product resource errors (4000) */
    public static final int ERR_PRODUCT = 4000;
    
    private DSurveyDao surveyDao;
    
    public void init() {
    }
    
    public DSurvey createSurvey(DSurvey dEntity) {
        surveyDao.persist(dEntity);
        return dEntity;
    }
    
    public DSurvey getSurvey(Long id) {
        final DSurvey entity = surveyDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DSurvey, Long> getSurveysPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DSurvey, Long> page = surveyDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DSurvey updateSurvey(DSurvey dEntity) {
        surveyDao.update(dEntity);
        return dEntity;
    }

    public void setSurveyDao(DSurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

}

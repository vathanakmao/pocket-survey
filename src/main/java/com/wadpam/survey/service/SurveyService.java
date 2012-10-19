package com.wadpam.survey.service;

import com.wadpam.server.exceptions.ConflictException;
import com.wadpam.server.exceptions.NotFoundException;
import com.wadpam.survey.dao.DAnswerDao;
import com.wadpam.survey.dao.DQuestionDao;
import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.dao.DResponseDao;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.web.AnswerController;
import com.wadpam.survey.web.QuestionController;
import com.wadpam.survey.web.ResponseController;
import com.wadpam.survey.web.SurveyController;
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
    /** Base offset for answer resource errors (103000) */
    public static final int ERR_ANSWER = 103000;
    /** Base offset for question resource errors (104000) */
    public static final int ERR_QUESTION = 104000;
    
    private DAnswerDao answerDao;
    private DQuestionDao questionDao;
    private DResponseDao responseDao;
    private DSurveyDao surveyDao;
    
    public void init() {
    }
    
    public DAnswer createAnswer(DAnswer dEntity) {

        // id must be generated
        if (null != dEntity.getId()) {
            throw new ConflictException(AnswerController.ERR_CREATE_CONFLICT,
                    String.format("id {} must not be specified", dEntity.getId()),
                    null,
                    "id must be generated");
        }
        
        // check that question exists
        final DQuestion question = questionDao.findByPrimaryKey(dEntity.getQuestion().getId());
        if (null == question) {
            throw new NotFoundException(ResponseController.ERR_CREATE_NOT_FOUND, 
                    String.format("Question {} not found",  dEntity.getQuestion().getId()), 
                    null, 
                    "Cannot answer non-existing question");
        }
        
        answerDao.persist(dEntity);
        return dEntity;
    }
    
    public DQuestion createQuestion(DQuestion dEntity) {
        
        // id must be generated
        if (null != dEntity.getId()) {
            throw new ConflictException(QuestionController.ERR_CREATE_CONFLICT,
                    String.format("id {} must not be specified", dEntity.getId()),
                    null,
                    "id must be generated");
        }
        
        
        // check that survey exists
        final DSurvey survey = surveyDao.findByPrimaryKey(dEntity.getSurvey().getId());
        if (null == survey) {
            throw new NotFoundException(QuestionController.ERR_CREATE_NOT_FOUND, 
                    String.format("Survey {} not found",  dEntity.getSurvey().getId()), 
                    null, 
                    "Cannot respond to non-existing survey");
        }
        
        questionDao.persist(dEntity);
        return dEntity;
    }
    
    public DResponse createResponse(DResponse dEntity) {
        
        // id must be generated
        if (null != dEntity.getId()) {
            throw new ConflictException(ResponseController.ERR_CREATE_CONFLICT,
                    String.format("id {} must not be specified", dEntity.getId()),
                    null,
                    "id must be generated");
        }
        
        
        // check that survey exists
        final DSurvey survey = surveyDao.findByPrimaryKey(dEntity.getSurvey().getId());
        if (null == survey) {
            throw new NotFoundException(ResponseController.ERR_CREATE_NOT_FOUND, 
                    String.format("Survey {} not found",  dEntity.getSurvey().getId()), 
                    null, 
                    "Cannot respond to non-existing survey");
        }
        
        // patch state if missing
        if (null == dEntity.getState()) {
            dEntity.setState(JResponse.STATE_ACTIVE);
        }
        
        responseDao.persist(dEntity);
        return dEntity;
    }
    
    public DSurvey createSurvey(DSurvey dEntity) {
        
        // id must be generated
        if (null != dEntity.getId()) {
            throw new ConflictException(SurveyController.ERR_CREATE_CONFLICT,
                    String.format("id {} must not be specified", dEntity.getId()),
                    null,
                    "id must be generated");
        }
        
        // patch state if missing
        if (null == dEntity.getState()) {
            dEntity.setState(JSurvey.STATE_IN_DESIGN);
        }
        
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
    
    public DQuestion getQuestion(Long id) {
    final DQuestion entity = questionDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DQuestion, Long> getQuestionsPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DQuestion, Long> page = questionDao.queryPage(pageSize, cursorKey);
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

    public DQuestion updateQuestion(DQuestion dEntity) {
        questionDao.update(dEntity);
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

    public void setQuestionDao(DQuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void setResponseDao(DResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    public void setSurveyDao(DSurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

}

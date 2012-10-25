package com.wadpam.survey.service;

import com.wadpam.server.exceptions.ConflictException;
import com.wadpam.server.exceptions.NotFoundException;
import com.wadpam.survey.dao.DAnswerDao;
import com.wadpam.survey.dao.DOptionDao;
import com.wadpam.survey.dao.DQuestionDao;
import com.wadpam.survey.dao.DSurveyDao;
import com.wadpam.survey.dao.DResponseDao;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DOption;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.web.AnswerController;
import com.wadpam.survey.web.Converter;
import com.wadpam.survey.web.OptionController;
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
    /** Base offset for option resource errors (105000) */
    public static final int ERR_OPTION = 105000;
    
    private DAnswerDao answerDao;
    private DOptionDao optionDao;
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
            throw new NotFoundException(AnswerController.ERR_CREATE_NOT_FOUND, 
                    String.format("Question {} not found",  dEntity.getQuestion().getId()), 
                    null, 
                    "Cannot answer non-existing question");
        }
        
        answerDao.persist(dEntity);
        return dEntity;
    }
    
    public DOption createOption(DOption dEntity) {
        
        // id must be generated
        if (null != dEntity.getId()) {
            throw new ConflictException(OptionController.ERR_CREATE_CONFLICT,
                    String.format("id {} must not be specified", dEntity.getId()),
                    null,
                    "id must be generated");
        }
        
        // check that question exists
        final DQuestion question = questionDao.findByPrimaryKey(dEntity.getQuestion().getId());
        if (null == question) {
            throw new NotFoundException(OptionController.ERR_CREATE_NOT_FOUND, 
                    String.format("Question {} not found",  dEntity.getQuestion().getId()), 
                    null, 
                    "Cannot answer non-existing question");
        }
        
        optionDao.persist(dEntity);
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
    
    public Integer deleteAll() {
        Iterable<Long> simpleKeys = answerDao.queryAllKeys();
        int count = answerDao.delete(null, simpleKeys);
        simpleKeys = optionDao.queryAllKeys();
        count += optionDao.delete(null, simpleKeys);
        simpleKeys = responseDao.queryAllKeys();
        count += responseDao.delete(null, simpleKeys);
        simpleKeys = questionDao.queryAllKeys();
        count += questionDao.delete(null, simpleKeys);
        simpleKeys = surveyDao.queryAllKeys();
        count += surveyDao.delete(null, simpleKeys);
        
        return count;
    }

    public DAnswer getAnswer(Long id) {
        final DAnswer entity = answerDao.findByPrimaryKey(id);
        return entity;
    }
    
    public CursorPage<DAnswer, Long> getAnswersPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DAnswer, Long> page = answerDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DOption getOption(Long id) {
    final DOption entity = optionDao.findByPrimaryKey(id);
        return entity;
    }
    
    public Iterable<DOption> getOptionsBySurvey(Long surveyId) {
        DSurvey survey = new DSurvey();
        survey.setId(surveyId);
        return optionDao.queryBySurvey(survey);
    }
    
    public CursorPage<DOption, Long> getOptionsPage(int pageSize, Serializable cursorKey) {
        final CursorPage<DOption, Long> page = optionDao.queryPage(pageSize, cursorKey);
        return page;
    }
    
    public DQuestion getQuestion(Long id) {
    final DQuestion entity = questionDao.findByPrimaryKey(id);
        return entity;
    }
    
    public Iterable<DQuestion> getQuestionsBySurvey(Long surveyId) {
        DSurvey survey = new DSurvey();
        survey.setId(surveyId);
        return questionDao.queryBySurvey(survey);
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
    
    public DOption updateOption(DOption dEntity) {
        optionDao.update(dEntity);
        return dEntity;
    }

    public DQuestion updateQuestion(DQuestion dEntity) {
        questionDao.update(dEntity);
        return dEntity;
    }

    public DSurvey updateSurvey(DSurvey dEntity) {
        surveyDao.update(dEntity);
        return dEntity;
    }

    public DAnswer upsertAnswer(DAnswer dEntity, Iterable<DAnswer> existing) {
        boolean existed = null != dEntity.getId();
        
        // check if found by Question and Response
        if (!existed && null != existing) {
            for (DAnswer da : existing) {
                if (dEntity.getQuestion().getId().equals(
                        da.getQuestion().getId())) {
                    da.setAnswer(dEntity.getAnswer());
                    dEntity = da;
                    existed = true;
                    break;
                }
            }
        }
        
        if (existed) {
            answerDao.update(dEntity);
        }
        else {
            answerDao.persist(dEntity);
        }
        return dEntity;
    }

    public DResponse upsertResponse(JResponse jResponse) {
        final DResponse dEntity = Converter.convert(jResponse);
        
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
        
        final boolean existed = null != jResponse.getId();
        if (existed) {
            responseDao.update(dEntity);
        }
        else {
            responseDao.persist(dEntity);
        }

        // inner Answers to this response?
        if (null != jResponse.getAnswers()) {
            final Iterable<DAnswer> existing = answerDao.queryByResponse(dEntity);
            for (JAnswer answer : jResponse.getAnswers()) {
                upsertAnswer(Converter.convert(answer), existing);
            }
        }
        
        return dEntity;
    }

    public void setAnswerDao(DAnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public void setOptionDao(DOptionDao optionDao) {
        this.optionDao = optionDao;
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

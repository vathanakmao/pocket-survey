package com.wadpam.survey.web;

import com.wadpam.open.json.JBaseObject;
import com.wadpam.open.web.BaseConverter;
import com.wadpam.survey.domain.DAnswer;
import com.wadpam.survey.domain.DQuestion;
import com.wadpam.survey.domain.DResponse;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.json.JAnswer;
import com.wadpam.survey.json.JQuestion;
import com.wadpam.survey.json.JResponse;
import com.wadpam.survey.json.JSurvey;

/**
 *
 * @author os
 */
public class Converter extends BaseConverter {
    
    public JBaseObject convertBase(Object d) {
        JBaseObject returnValue = null;
        
        if (d instanceof DSurvey) {
            returnValue = convert((DSurvey) d);
        }
        else if (d instanceof DQuestion) {
            returnValue = convert((DQuestion) d);
        }
        else if (d instanceof DResponse) {
            returnValue = convert((DResponse) d);
        }
        else if (d instanceof DAnswer) {
            returnValue = convert((DAnswer) d);
        }
        
        return returnValue;
    }

    public static JAnswer convert(DAnswer from) {
        if (null == from) {
            return null;
        }
        
        final JAnswer to = new JAnswer();
        convert(from, to);
        
        to.setAnswer(from.getAnswer());
        to.setQuestionId(null != from.getQuestion() ? from.getQuestion().getId() : null);
        to.setResponseId(null != from.getResponse() ? from.getResponse().getId() : null);
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        
        return to;
    }

    public static DAnswer convert(JAnswer from) {
        if (null == from) {
            return null;
        }
        
        final DAnswer to = new DAnswer();
        convert(from, to);

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
        
        return to;
    }
    
    public static JQuestion convert(DQuestion from) {
        if (null == from) {
            return null;
        }
        
        final JQuestion to = new JQuestion();
        convert(from, to);

        to.setOrder(from.getOrder());
        to.setQuestion(from.getQuestion());
        to.setRequired(from.getRequired());
        to.setType(from.getType());
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        
        return to;
    }

    public static DQuestion convert(JQuestion from) {
        if (null == from) {
            return null;
        }
        
        final DQuestion to = new DQuestion();
        convert(from, to);

        to.setOrder(from.getOrder());
        to.setQuestion(from.getQuestion());
        to.setRequired(from.getRequired());
        to.setType(from.getType());
        if (null != from.getSurveyId()) {
            final DSurvey survey = new DSurvey();
            survey.setId(from.getSurveyId());
            to.setSurvey(survey);
        }
        
        return to;
    }
    
    public static JResponse convert(DResponse from) {
        if (null == from) {
            return null;
        }
        
        final JResponse to = new JResponse();
        convert(from, to);
        
        to.setState(from.getState());
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        
        return to;
    }

    public static DResponse convert(JResponse from) {
        if (null == from) {
            return null;
        }
        
        final DResponse to = new DResponse();
        convert(from, to);

        to.setState(from.getState());
        if (null != from.getSurveyId()) {
            final DSurvey survey = new DSurvey();
            survey.setId(from.getSurveyId());
            to.setSurvey(survey);
        }
        
        return to;
    }
    
    public static JSurvey convert(DSurvey from) {
        if (null == from) {
            return null;
        }
        
        final JSurvey to = new JSurvey();
        convert(from, to);
        
        to.setState(from.getState());
        to.setTitle(from.getTitle());
        
        return to;
    }

    public static DSurvey convert(JSurvey from) {
        if (null == from) {
            return null;
        }
        
        final DSurvey to = new DSurvey();
        convert(from, to);

        to.setState(from.getState());
        to.setTitle(from.getTitle());
        
        return to;
    }

}

package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;

/**
 *
 * @author os
 */
public class JResponse extends JBaseObject {
    
    /** The survey this response is for */
    private Long surveyId;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
    
    @Override
    protected String subString() {
        return String.format("surveyId:%d", surveyId);
    }

}

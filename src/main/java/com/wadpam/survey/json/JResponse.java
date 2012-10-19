package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;

/**
 *
 * @author os
 */
public class JResponse extends JBaseObject {

    public static final long STATE_DELETED = -1;
    public static final long STATE_ACTIVE = 0;
    public static final long STATE_CLOSED = 1;
    
    
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

package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.util.List;

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
    
    /** The survey version this response is for */
    private Long versionId;
    
    /** The answers for this response */
    private List<JAnswer> answers;

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

    public List<JAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<JAnswer> answers) {
        this.answers = answers;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

}

package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;

/**
 *
 * @author os
 */
public class JOption extends JBaseObject {
    
    /** The question this answer is for */
    private Long questionId;

    /** The survey this answer is for */
    private Long surveyId;

    /** The survey version this answer is for */
    private Long versionId;

    /** The text label for this option*/
    private String label;
    
    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
    
    @Override
    protected String subString() {
        return String.format("questionId:%d, label:%s", questionId, label);
    }

}

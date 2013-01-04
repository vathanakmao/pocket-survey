package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.io.Serializable;

/**
 *
 * @author os
 */
public class JAnswer extends JBaseObject implements Serializable {
    
    /** The question this answer is for */
    private Long questionId;

    /** The response this answer is for */
    private Long responseId;

    /** The survey this answer is for */
    private Long surveyId;

    /** The survey version this answer is for */
    private Long versionId;

    /** The type of the answer is given by the question */
    private String answer;
    
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

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
    
    @Override
    protected String subString() {
        return String.format("questionId:%d, answer:%s", questionId, answer);
    }

}

package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;

/**
 *
 * @author os
 */
public class JAnswer extends JBaseObject {
    
    /** The question this answer is for */
    private Long questionId;

    /** The response this answer is for */
    private Long responseId;

    /** The survey this answer is for */
    private Long surveyId;

    /** The type of the answer is given by the question */
    private Object answer;
    
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

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }
    
    @Override
    protected String subString() {
        return String.format("questionId:%d, answer:%s", questionId, answer);
    }

}

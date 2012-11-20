package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.util.Collection;

/**
 *
 * @author os
 */
public class JVersion extends JBaseObject {

    public static final long STATE_DELETED = -1;
    public static final long STATE_DRAFT = 0;
    public static final long STATE_PUBLISHED = 1;
    
    /** The description of this survey version */
    private String description;
    
    /** The survey relation */
    private Long surveyId;

    /** The Questions configured for this survey */
    private Collection<JQuestion> questions;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Collection<JQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<JQuestion> questions) {
        this.questions = questions;
    }

}
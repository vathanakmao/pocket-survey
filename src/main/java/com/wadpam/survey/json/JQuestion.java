package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.util.Collection;

/**
 *
 * @author os
 */
public class JQuestion extends JBaseObject {

    /** An answer is optional */
    public static final long REQUIRED_OPTIONAL = 0;
    
    /** An answer is required */
    public static final long REQUIRED_REQUIRED = 1;
    
    /** Remind user if not answered */
    public static final long REQUIRED_REMINDER = 2;
    
    /** Free-text input */
    public static final long TYPE_TEXT = 1;
    
    /** Numeric input */
    public static final long TYPE_NUMBER = 2;
    
    /** 0-100 integer input */
    public static final long TYPE_PERCENT = 3;
    
    /** true or false (checkbox) input */
    public static final long TYPE_BOOLEAN = 4;
    
    /** Acquire an image with camera, and upload */
    public static final long TYPE_IMAGE = 5;
    
    /** Any file to upload */
    public static final long TYPE_FILE = 6;
    
    /** Radio buttons (single select) */
    public static final long TYPE_RADIO = 7;
    
    /** Multi-select input */
    public static final long TYPE_MULTI = 8;
    
    /** Drop-down select input */
    public static final long TYPE_DROPDOWN = 9;
    
    /** Date (and time) input */
    public static final long TYPE_DATE = 10;
    
    /** The survey this question is for */
    private Long surveyId;

    /** The version this question is for */
    private Long versionId;

    /** The order of this question within the Survey */
    private Long ordering;

    /** The default localization of the question */
    private String question;
    
    /** Indicates if an answer is required: REQUIRED, OPTIONAL, REMINDER. */
    private Long required;
    
    /** The answer type: TEXT, NUMBER, IMAGE, ... */
    private Long type;
    
    /** The options configured for this question */
    private Collection<JOption> options;
    
    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getOrdering() {
        return ordering;
    }

    public void setOrdering(Long order) {
        this.ordering = order;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getRequired() {
        return required;
    }

    public void setRequired(Long required) {
        this.required = required;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Collection<JOption> getOptions() {
        return options;
    }

    public void setOptions(Collection<JOption> options) {
        this.options = options;
    }

    @Override
    protected String subString() {
        return String.format("surveyId:%d, versionId:%d, order:%d, type:%d, question:%s", 
                surveyId, versionId, ordering, type, question);
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

}

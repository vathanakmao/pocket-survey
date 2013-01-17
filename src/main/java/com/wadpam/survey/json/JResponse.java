package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.util.Collection;

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
    
    /** ID of related location (external system) */
    private String extLocationId;
    
    /** ID of related meeting (external system) */
    private String extMeetingId;
    
    /** ID of related product (external system) */
    private String extProductId;
    
    /** ID of related user (external system) */
    private String extUserId;
    
    /** The answers for this response */
    private Collection<JAnswer> answers;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
    
    @Override
    protected String subString() {
        return String.format("surveyId:%d, versionId:%d, answers:%s, extProductId:%s", 
                surveyId, versionId, answers, extProductId);
    }

    public Collection<JAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<JAnswer> answers) {
        this.answers = answers;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getExtLocationId() {
        return extLocationId;
    }

    public void setExtLocationId(String extLocationId) {
        this.extLocationId = extLocationId;
    }

    public String getExtMeetingId() {
        return extMeetingId;
    }

    public void setExtMeetingId(String extMeetingId) {
        this.extMeetingId = extMeetingId;
    }

    public String getExtProductId() {
        return extProductId;
    }

    public void setExtProductId(String extProductId) {
        this.extProductId = extProductId;
    }

    public String getExtUserId() {
        return extUserId;
    }

    public void setExtUserId(String extUserId) {
        this.extUserId = extUserId;
    }

}

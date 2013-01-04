package com.wadpam.survey.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import net.sf.mardao.core.domain.AbstractLongEntity;

/**
 *
 * @author os
 */
@Entity
public class DResponse extends AbstractLongEntity {
    
    /** In progress, Closed, Deleted */
    @Basic
    private Long state;

    /** The survey this response is for */
    @ManyToOne
    private DSurvey survey;
    
    /** The survey this response is for */
    @ManyToOne
    private DVersion version;
    
    /** ID of related location (external system) */
    @Basic
    private String extLocationId;
    
    /** ID of related meeting (external system) */
    @Basic
    private String extMeetingId;
    
    /** ID of related product (external system) */
    @Basic
    private String extProductId;
    
    /** ID of related user (external system) */
    @Basic
    private String extUserId;
    
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public DSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(DSurvey survey) {
        this.survey = survey;
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

    public DVersion getVersion() {
        return version;
    }

    public void setVersion(DVersion version) {
        this.version = version;
    }

}

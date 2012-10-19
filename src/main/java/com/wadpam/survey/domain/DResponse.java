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

}

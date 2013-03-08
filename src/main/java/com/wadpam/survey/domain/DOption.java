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
public class DOption extends AbstractLongEntity {
    
    /** The label text for this option */
    @Basic
    private String label;

    /** The question this option is for */
    @ManyToOne
    private DQuestion question;
    
    /** The survey this option is related to */
    @ManyToOne
    private DSurvey survey;

    /** The survey version this option is related to */
    @ManyToOne
    private DVersion version;

    /** Application-specific attribute */
    @Basic
    private String appArg0;

    public String getAppArg0() {
        return appArg0;
    }

    public void setAppArg0(String appArg0) {
        this.appArg0 = appArg0;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public DSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(DSurvey survey) {
        this.survey = survey;
    }

    public DQuestion getQuestion() {
        return question;
    }

    public void setQuestion(DQuestion question) {
        this.question = question;
    }

    public DVersion getVersion() {
        return version;
    }

    public void setVersion(DVersion version) {
        this.version = version;
    }

}

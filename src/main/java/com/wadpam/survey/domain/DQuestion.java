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
public class DQuestion extends AbstractLongEntity {
    
    /** The order of this question within the Survey */
    @Basic
    private Long order;

    /** The default localization of the question */
    @Basic
    private String question;
    
    /** Indicates if an answer is required: REQUIRED, OPTIONAL, REMINDER. */
    @Basic
    private Long required;
    
    /** The answer type: TEXT, NUMBER, IMAGE, ... */
    @Basic
    private Long type;

    /** The survey this response is for */
    @ManyToOne
    private DSurvey survey;
    
    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }
    
    public DSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(DSurvey survey) {
        this.survey = survey;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getRequired() {
        return required;
    }

    public void setRequired(Long required) {
        this.required = required;
    }

}

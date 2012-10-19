package com.wadpam.survey.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import net.sf.mardao.core.Parent;
import net.sf.mardao.core.domain.AbstractCreatedUpdatedEntity;

/**
 *
 * @author os
 */
@Entity
public class Di18n extends AbstractCreatedUpdatedEntity {

    /** The generic parent key, can reference DSurvey, DQuestion or DOption */
    @Parent(kind="DQuestion")
    private Object parentKey;
    
    /** The langCode for this translation */
    @Id
    private String langCode;
    
    /** The translated value */
    @Basic
    private String trans;

    public Object getParentKey() {
        return parentKey;
    }

    public void setParentKey(Object parentKey) {
        this.parentKey = parentKey;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    
}

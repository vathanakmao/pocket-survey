package com.wadpam.survey.json;

import com.wadpam.open.json.JBaseObject;
import java.util.Collection;

/**
 *
 * @author os
 */
public class JSurvey extends JBaseObject {

    public static final long STATE_DELETED = -1;
    public static final long STATE_IN_DESIGN = 0;
    public static final long STATE_ACTIVE = 1;
    public static final long STATE_CLOSED = 2;
    
    /** The title of this survey */
    private String title;
    
    /** The Questions configured for this survey */
    private Collection<JQuestion> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected String subString() {
        return String.format("title:%s", title);
    }

    public Collection<JQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<JQuestion> questions) {
        this.questions = questions;
    }

}
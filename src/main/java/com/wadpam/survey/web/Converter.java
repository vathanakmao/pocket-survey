package com.wadpam.survey.web;

import com.wadpam.open.json.JBaseObject;
import com.wadpam.open.web.BaseConverter;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.json.JSurvey;

/**
 *
 * @author os
 */
public class Converter extends BaseConverter {
    
    public JBaseObject convertBase(Object d) {
        JBaseObject returnValue = null;
        
        if (d instanceof DSurvey) {
            returnValue = convert((DSurvey) d);
        }
//        else if (d instanceof DmLocation) {
//            returnValue = convert((DmLocation) d);
//        }
        
        return returnValue;
    }
    
    public static JSurvey convert(DSurvey from) {
        if (null == from) {
            return null;
        }
        
        final JSurvey to = new JSurvey();
        convert(from, to);
        
        return to;
    }

    public static DSurvey convert(JSurvey from) {
        if (null == from) {
            return null;
        }
        
        final DSurvey to = new DSurvey();
        convert(from, to);
        
        return to;
    }
}

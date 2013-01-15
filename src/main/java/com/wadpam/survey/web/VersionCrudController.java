package com.wadpam.survey.web;

import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JVersion;
import com.wadpam.survey.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author os
 */
@Controller
@RequestMapping("{domain}/crudsurvey/{surveyVersion}/{surveyId}/version")
public class VersionCrudController extends CrudController<JVersion, DVersion, Long, VersionService> {
    
    @Autowired
    private VersionService versionService;
    
    

    // --------------------- Converter and setters -----------------------------

    @Override
    public JVersion convertDomain(DVersion from) {
        if (null == from) {
            return null;
        }
        
        final JVersion to = new JVersion();
        convertLongEntity(from, to);

        to.setDescription(from.getDescription());
        to.setState(from.getState());
        to.setSurveyId(null != from.getSurvey() ? from.getSurvey().getId() : null);
        
        return to;
    }

    @Override
    public DVersion convertJson(JVersion from) {
        if (null == from) {
            return null;
        }
        
        final DVersion to = new DVersion();
        convertJLong(from, to);

        to.setDescription(from.getDescription());
        to.setState(from.getState());
        if (null != from.getSurveyId()) {
            final DSurvey survey = new DSurvey();
            survey.setId(from.getSurveyId());
            to.setSurvey(survey);
        }
        
        return to;
    }
    
    @Autowired
    public void setVersionCrudService(VersionService versionCrudService) {
        this.service = versionCrudService;
    }
}

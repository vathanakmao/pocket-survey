package com.wadpam.survey.web;

import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
import com.wadpam.survey.json.JVersion;
import com.wadpam.survey.service.SurveyService;
import com.wadpam.survey.service.VersionService;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import net.sf.mardao.core.CursorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author os
 */
@Controller
@RequestMapping("{domain}/survey/{surveyVersion}/{surveyId}/version")
public class VersionController extends CrudController<JVersion, DVersion, Long, VersionService> {
    
    @Autowired
    private SurveyService surveyService;
    
    @Override
    @RequestMapping(value="v10", method= RequestMethod.GET)
    @ResponseBody
    public JCursorPage<JVersion> getPage(
            HttpServletRequest request,
            @PathVariable String surveyVersion,
            @PathVariable Long surveyId,
            @RequestParam(defaultValue="10") int pageSize, 
            @RequestParam(required=false) Serializable cursorKey) {
        
        final CursorPage<DVersion, Long> page = surveyService.getVersionsPage(surveyId, pageSize, cursorKey);
        final JCursorPage body = convertPage(page);

        return body;
    }
    
    

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
    public void setVersionService(VersionService versionService) {
        this.service = versionService;
    }
}

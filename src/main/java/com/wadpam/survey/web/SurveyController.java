package com.wadpam.survey.web;

import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.json.JSurvey;
import com.wadpam.survey.json.JVersion;
import com.wadpam.survey.service.SurveyCrudService;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author os
 */
@Controller
@RequestMapping("{domain}/survey")
public class SurveyController extends CrudController<JSurvey, DSurvey, Long, SurveyCrudService> {
    
    public static final String NAME_INNER_VERSIONS = "versions";
    
    @Autowired
    private VersionController versionController;

    @Override
    public JSurvey addInnerObjects(HttpServletRequest request, 
            HttpServletResponse response,
            String domain,
            Model model,
            JSurvey jSurvey) {
        LOG.debug("addInnerObjects for {}...", jSurvey);
        if (null != jSurvey && 
                (null != request.getParameter(NAME_INNER_VERSIONS) || 
                 null != request.getAttribute(NAME_INNER_VERSIONS))) {
            // add versions
            Long surveyId = Long.parseLong(jSurvey.getId());
            model.addAttribute("surveyId", surveyId);
            final JCursorPage<JVersion> versions = versionController.getPage(request, 
                    response, domain, model, 5, null);
            LOG.debug("found versions {}", versions.getItems());
            jSurvey.setVersions(versions.getItems());
        }
        
        return jSurvey;
    }

    @Override
    protected Collection<String> getInnerParameterNames() {
        return Arrays.asList(NAME_INNER_VERSIONS);
    }
    
    // ----------------------- Converter and setters ---------------------------

    public SurveyController() {
        super(JSurvey.class);
    }
    
    @Override
    public void convertDomain(DSurvey from, JSurvey to) {
        convertLongEntity(from, to);
        
        to.setState(from.getState());
        to.setTitle(from.getTitle());
    }

    @Override
    public void convertJson(JSurvey from, DSurvey to) {
        convertJLong(from, to);

        to.setState(from.getState());
        to.setTitle(from.getTitle());
    }
    
    @Autowired
    public void setSurveyCrudService(SurveyCrudService surveyCrudService) {
        this.service = surveyCrudService;
    }
}

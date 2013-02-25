package com.wadpam.survey.web;

import com.wadpam.docrest.domain.RestCode;
import com.wadpam.docrest.domain.RestReturn;
import com.wadpam.open.json.JCursorPage;
import com.wadpam.open.mvc.CrudController;
import com.wadpam.survey.domain.DSurvey;
import com.wadpam.survey.domain.DVersion;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    /**
     * Deep-clone a survey version.
     * @param surveyId
     * @param fromVersionId the version we would like to clone
     * @param description Description of the new version
     * @return the new JVersion object
     */
    @RestReturn(value=JVersion.class, code={
        @RestCode(code=200, description="Version successfully cloned.")
    })
    @RequestMapping(value="v10/{surveyId}", method= RequestMethod.POST)
    public JVersion cloneVersion(
            @PathVariable Long surveyId,
            @RequestParam Long fromVersionId,
            @RequestParam String description
            ) {
        DVersion to = service.cloneVersion(surveyId, fromVersionId, description);
        return versionController.convertDomain(to);
    }

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

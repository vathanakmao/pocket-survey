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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public JSurvey addInnerObjects(HttpServletRequest request, JSurvey jSurvey) {
        LOG.debug("addInnerObjects for {}...", jSurvey);
        if (null != jSurvey && 
                (null != request.getParameter(NAME_INNER_VERSIONS) || 
                 null != request.getAttribute(NAME_INNER_VERSIONS))) {
            // add versions
            Long surveyId = Long.parseLong(jSurvey.getId());
            final JCursorPage<JVersion> versions = versionController.getPage(request, "", surveyId, 5, null);
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
    
    @Override
    public JSurvey convertDomain(DSurvey from) {
        if (null == from) {
            return null;
        }
        
        final JSurvey to = new JSurvey();
        convertLongEntity(from, to);
        
        to.setState(from.getState());
        to.setTitle(from.getTitle());
        
        return to;
    }

    @Override
    public DSurvey convertJson(JSurvey from) {
        if (null == from) {
            return null;
        }
        
        final DSurvey to = new DSurvey();
        convertJLong(from, to);

        to.setState(from.getState());
        to.setTitle(from.getTitle());
        
        return to;
    }
    
    @Autowired
    public void setSurveyCrudService(SurveyCrudService surveyCrudService) {
        this.service = surveyCrudService;
    }
}

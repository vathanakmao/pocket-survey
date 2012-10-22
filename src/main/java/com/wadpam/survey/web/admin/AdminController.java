package com.wadpam.survey.web.admin;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.wadpam.survey.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author os
 */
@Controller
@RequestMapping("_admin/{domain}")
public class AdminController {
    
    static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    
    private final BlobstoreService BLOB_SERVICE = BlobstoreServiceFactory.getBlobstoreService();
    private final UserService USER_SERVICE = UserServiceFactory.getUserService();
    
    private SurveyService service;
    
    @RequestMapping(value="deleteAllSurveyEntities", method= RequestMethod.DELETE)
    @ResponseBody
    public Integer deleteAll() {
        return service.deleteAll();
    }

    public void setService(SurveyService service) {
        this.service = service;
    }
    
}

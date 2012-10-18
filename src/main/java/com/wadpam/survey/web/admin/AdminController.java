package com.wadpam.survey.web.admin;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
    
}

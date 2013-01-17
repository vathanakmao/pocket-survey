/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DResponseDao;
import com.wadpam.survey.domain.DResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosandstrom
 */
public class ResponseService extends MardaoCrudService<
        DResponse, 
        Long, 
        DResponseDao> {

    @Autowired
    public void setDResponseDao(DResponseDao dResponseDao) {
        this.dao = dResponseDao;
    }
}

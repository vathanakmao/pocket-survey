/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.survey.service;

import com.wadpam.open.mvc.MardaoCrudService;
import com.wadpam.survey.dao.DOptionDao;
import com.wadpam.survey.domain.DOption;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosandstrom
 */
public class OptionService extends MardaoCrudService<DOption, Long, DOptionDao> {
    
    @Autowired
    protected SurveyService surveyService;

    @Override
    public Long create(DOption domain) {
        surveyService.createOption(domain);
        return domain.getId();
    }
    
    @Autowired
    public void setDOptionDao(DOptionDao dOptionDao) {
        this.dao = dOptionDao;
    }
}

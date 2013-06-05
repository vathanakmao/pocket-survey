package com.wadpam.survey.dao;

import net.sf.mardao.core.Filter;

/**
 * Implementation of Business Methods related to entity DQuestion. This (empty) class is generated by mardao, but edited by
 * developers. It is not overwritten by the generator once it exists.
 * 
 * Generated on 2012-10-19T08:40:22.845+0700.
 * 
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DQuestionDaoBean extends GeneratedDQuestionDaoImpl implements DQuestionDao {

    @Override
    public void setMemCacheEntities(boolean memCacheEntities) {
        this.memCacheEntities = memCacheEntities;
    }

    @Override
    public Iterable<Long> queryKeysBySurvey(Object surveyKey) {
        Filter filter = createEqualsFilter(COLUMN_NAME_SURVEY, surveyKey);
        return queryIterableKeys(0, -1, null, null, null, false, null, false, filter);
    }

    @Override
    public Iterable<Long> queryKeysByVersion(Object versionKey) {
        Filter filter = createEqualsFilter(COLUMN_NAME_VERSION, versionKey);
        return queryIterableKeys(0, -1, null, null, null, false, null, false, filter);
    }
}

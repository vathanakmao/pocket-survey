package com.wadpam.survey.dao;


/**
 * Business Methods interface for entity DOption.
 * This interface is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2012-10-22T13:08:12.502+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface DOptionDao extends GeneratedDOptionDao {
    
    void setMemCacheEntities(boolean memCacheEntities);

    Iterable<Long> queryKeysBySurvey(Object surveyKey);

    Iterable<Long> queryKeysByVersion(Object versionKey);

    Iterable<Long> queryKeysByQuestion(Object questionKey);
    
}

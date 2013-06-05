package com.wadpam.survey.dao;

import java.util.Collection;

import com.wadpam.survey.domain.DAnswer;

/**
 * Business Methods interface for entity DAnswer.
 * This interface is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2012-10-19T08:40:22.845+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface DAnswerDao extends GeneratedDAnswerDao {

    Iterable<DAnswer> queryByResponseIds(Collection<Long> ids);

    Iterable<Long> queryKeysByQuestion(Object questionKey);

    Iterable<Long> queryKeysByVersion(Object versionKey);

    Iterable<Long> queryKeysByResponse(Object responseKey);

    Iterable<Long> queryKeysBySurvey(Object surveyKey);

}

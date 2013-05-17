package com.wadpam.survey.dao;

import net.sf.mardao.core.CursorPage;

import com.wadpam.survey.domain.DResponse;

/**
 * Business Methods interface for entity DResponse.
 * This interface is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2012-10-19T08:40:22.845+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface DResponseDao extends GeneratedDResponseDao {

	// TODO: declare your Business Methods here
	
    /**
     * Get page of responses by survey ID, version ID, and external meeting ID.
     * 
     * @param survey
     * @param version
     * @param extMeetingId
     * @param pageSize
     * @param cursorKey
     * @return page of responses
     */
    public CursorPage<DResponse, Long> queryPageBySurveyIdVersionIdAndExtMeetingId(Long surveyId, Long versionId, String extMeetingId, int pageSize, String cursorKey);

    public CursorPage<DResponse, Long> queryPageByVersionIdCreatedBy(Long versionId, String createdById, int pageSize,
            String cursorKey);
}

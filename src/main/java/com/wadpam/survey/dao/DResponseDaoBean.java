package com.wadpam.survey.dao;

import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.Filter;

import com.wadpam.survey.domain.DResponse;

/**
 * Implementation of Business Methods related to entity DResponse.
 * This (empty) class is generated by mardao, but edited by developers.
 * It is not overwritten by the generator once it exists.
 *
 * Generated on 2012-10-19T08:40:22.845+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DResponseDaoBean 
	extends GeneratedDResponseDaoImpl
		implements DResponseDao 
{
    
    @Override
    public CursorPage<DResponse, Long> queryPageBySurveyIdVersionIdAndExtMeetingId(Long surveyId, Long versionId, String extMeetingId, int pageSize, String cursorKey) {
        final Object surveyForeignKey = getSurveyDao().getPrimaryKey(null, surveyId);
        final Filter surveyFilter = createEqualsFilter(COLUMN_NAME_SURVEY, surveyForeignKey);
        
        final Object versionForeignKey = getVersionDao().getPrimaryKey(null, versionId);
        final Filter versionFilter = createEqualsFilter(COLUMN_NAME_VERSION, versionForeignKey);
        
        final Filter meetingFilter = createEqualsFilter(COLUMN_NAME_EXTMEETINGID, extMeetingId);

        return queryPage(false, pageSize, null, null, null, false, null, false, cursorKey, surveyFilter, versionFilter, meetingFilter);
    }

}

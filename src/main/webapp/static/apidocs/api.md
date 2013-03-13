<!-- Table of Contents ---------------------------------------------------->
Contents
========
1. com.wadpam.survey.web.OldAnswerController
  * [create()](#create)
  * [get()](#get)
  * [getPage()](#getpage)
  * [update()](#update)
1. com.wadpam.survey.web.OldOptionController
  * [create()](#create)
  * [get()](#get)
  * [getPage()](#getpage)
  * [update()](#update)
1. com.wadpam.survey.web.OldQuestionController
  * [create()](#create)
  * [get()](#get)
  * [getPage()](#getpage)
  * [update()](#update)
1. com.wadpam.survey.web.OldResponseController
  * [createFromForm()](#createfromform)
  * [createFromJSON()](#createfromjson)
  * [delete()](#delete)
  * [deleteJsonp()](#deletejsonp)
  * [get()](#get)
  * [getPage()](#getpage)
  * [getPageByExtMeetingId()](#getpagebyextmeetingid)
  * [updateFromForm()](#updatefromform)
  * [updateFromJSON()](#updatefromjson)
1. com.wadpam.survey.web.OldSurveyController
  * [create()](#create)
  * [delete()](#delete)
  * [deleteJsonp()](#deletejsonp)
  * [get()](#get)
  * [getPage()](#getpage)
  * [update()](#update)
1. com.wadpam.survey.web.OldVersionController
  * [create()](#create)
  * [get()](#get)
  * [getCsv()](#getcsv)
  * [getPage()](#getpage)
  * [update()](#update)

<!-- Resource: /person ---------------------------------------------------->
/{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldAnswerController

<!-- Method: findByName() ---------------------------------------------------->		

create()
----------------

**Description**: Creates an entity.

**Implementing Class**: com.wadpam.survey.web.OldAnswerController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| path | responseId | [Long](#long) |  |
| query | answers | [java.lang.String[]](#javalangstring[]) |  |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JAnswer" class="link">com.wadpam.survey.json.JAnswer</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"answer"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"questionid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"responseid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldAnswerController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| path | responseId | [Long](#long) | the response's id |
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JAnswer](#comwadpamsurveyjsonjanswer)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldAnswerController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| path | responseId | [Long](#long) |  |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

update()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldAnswerController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to update |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JAnswer" class="link">com.wadpam.survey.json.JAnswer</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"answer"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"questionid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"responseid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Resource: /person ---------------------------------------------------->
/{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldOptionController

<!-- Method: findByName() ---------------------------------------------------->		

create()
----------------

**Description**: Creates an entity.

**Implementing Class**: com.wadpam.survey.web.OldOptionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| path | questionId | [Long](#long) | the question's id |
| query | expects | [Integer](#integer) |  |
| body (properties separately) | com.wadpam.survey.json.JOption | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"label"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"questionid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldOptionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| path | questionId | [Long](#long) | the question's id |
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JOption](#comwadpamsurveyjsonjoption)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldOptionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| path | questionId | [Long](#long) | the question's id |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

update()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldOptionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{questionId}/option/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| path | questionId | [Long](#long) | the question's id |
| path | id | [Long](#long) | the id of the entity to update |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JOption" class="link">com.wadpam.survey.json.JOption</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"label"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"questionid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"label"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Resource: /person ---------------------------------------------------->
/{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldQuestionController

<!-- Method: findByName() ---------------------------------------------------->		

create()
----------------

**Description**: Creates an entity.

**Implementing Class**: com.wadpam.survey.web.OldQuestionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) |  |
| body (properties separately) | com.wadpam.survey.json.JQuestion | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"options"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"question"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"required"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"type"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldQuestionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) | the version's id |
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JQuestion](#comwadpamsurveyjsonjquestion)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldQuestionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) | the version's id |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

update()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldQuestionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/question/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) | the domain (used for Multi-tenancy) |
| path | surveyId | [Long](#long) | the survey's id |
| path | versionId | [Long](#long) | the version's id |
| path | id | [Long](#long) | the id of the entity to update |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JQuestion" class="link">com.wadpam.survey.json.JQuestion</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"options"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"question"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"required"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"type"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"options"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"ordering"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"question"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"required"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"type"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Resource: /person ---------------------------------------------------->
/{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldResponseController

<!-- Method: findByName() ---------------------------------------------------->		

createFromForm()
----------------

**Description**: Creates an entity, from a form-encoded POST

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| query | formAnswers | [java.lang.String[]](#javalangstring[]) | if form-encoded, these are the inner answers |
| query | questionIds | [java.lang.Long[]](#javalanglong[]) | if form-encoded, these are the inner questionIds to answers |
| body (properties separately) | com.wadpam.survey.json.JResponse | [{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"answers"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"extlocationid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extmeetingid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extproductid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extuserid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) | the JResponse body |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

createFromJSON()
----------------

**Description**: Creates an entity, from a json POST

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| body | jResponse | [JResponse](#jresponse) | the JResponse body |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

delete()
----------------

**Description**: Deletes an entity (cross-domain)

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: DELETE     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JSurvey](#comwadpamsurveyjsonjsurvey)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

deleteJsonp()
----------------

**Description**: Deletes an entity (jsonp)

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JSurvey](#comwadpamsurveyjsonjsurvey)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JResponse](#comwadpamsurveyjsonjresponse)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPageByExtMeetingId()
----------------

**Description**: Queries for a (next) page of entities, all related to specified meeting.

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| query | extMeetingId | [String](#string) | the specified meeting's external id |
| query | answers | [boolean](#boolean) | set to true to get inner answers |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

updateFromForm()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| path | id | [Long](#long) | the id of the entity to updateFromForm |
| query | formAnswers | [java.lang.String[]](#javalangstring[]) | if form-encoded, these are the inner answers |
| query | questionIds | [java.lang.Long[]](#javalanglong[]) | if form-encoded, these are the inner questionIds to answers |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JResponse" class="link">com.wadpam.survey.json.JResponse</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"answers"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"extlocationid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extmeetingid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extproductid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"extuserid"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versionid"<b>&nbsp;:&nbsp;long,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

updateFromJSON()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldResponseController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |
| path | id | [Long](#long) | the id of the entity to updateFromForm |
| body | jEntity | [JResponse](#jresponse) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answers"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"extLocationId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extMeetingId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extProductId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"extUserId"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Resource: /person ---------------------------------------------------->
/{domain}/oldsurvey
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldSurveyController

<!-- Method: findByName() ---------------------------------------------------->		

create()
----------------

**Description**: Creates an entity.

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: POST     /{domain}/oldsurvey/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| body (properties separately) | com.wadpam.survey.json.JSurvey | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"title"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versions"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div>) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

delete()
----------------

**Description**: Deletes an entity (cross-domain)

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: DELETE     /{domain}/oldsurvey/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JSurvey](#comwadpamsurveyjsonjsurvey)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

deleteJsonp()
----------------

**Description**: Deletes an entity (jsonp)

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: GET     /{domain}/oldsurvey/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JSurvey](#comwadpamsurveyjsonjsurvey)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: GET     /{domain}/oldsurvey/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JSurvey](#comwadpamsurveyjsonjsurvey)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: GET     /{domain}/oldsurvey/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

update()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldSurveyController

**REST path**: POST     /{domain}/oldsurvey/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to update |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JSurvey" class="link">com.wadpam.survey.json.JSurvey</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"title"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"versions"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"title"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div>}
				
<!-- Resource: /person ---------------------------------------------------->
/{domain}/survey/v10/{surveyId}/oldversion
============

**Description**: 

**Concrete class**: com.wadpam.survey.web.OldVersionController

<!-- Method: findByName() ---------------------------------------------------->		

create()
----------------

**Description**: Creates an entity.

**Implementing Class**: com.wadpam.survey.web.OldVersionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/oldversion/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| path | surveyId | [Long](#long) |  |
| query | fromVersionId | [Long](#long) |  |
| query | description | [String](#string) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 201 | Created | The entity was created by AJAX |
| 302 | OK | The entity was created |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"description"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

get()
----------------

**Description**: Loads the specified entity.

**Implementing Class**: com.wadpam.survey.web.OldVersionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/oldversion/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to retrieve |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | The entity was found |
| 404 | Not Found | The entity was not found |

**Response Type**: [com.wadpam.survey.json.JVersion](#comwadpamsurveyjsonjversion)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"description"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getCsv()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldVersionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/oldversion/v10/{versionId}/csv

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | domain | [String](#string) |  |
| path | surveyId | [Long](#long) |  |
| path | versionId | [Long](#long) |  |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CSV with JSON entities |

**Response Type**: [com.wadpam.survey.json.JAnswer](#comwadpamsurveyjsonjanswer)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"answer"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questionId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"responseId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"versionId"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

getPage()
----------------

**Description**: Queries for a (next) page of entities

**Implementing Class**: com.wadpam.survey.web.OldVersionController

**REST path**: GET     /{domain}/survey/v10/{surveyId}/oldversion/v10

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | surveyId | [Long](#long) |  |
| query | pageSize | [int](#int) | default is 10 |
| query | cursorKey | [Serializable](#serializable) | null to get first page |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 200 | OK | A CursorPage with JSON entities |

**Response Type**: [com.wadpam.open.json.JCursorPage](#comwadpamopenjsonjcursorpage)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"description"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div>}
				
<!-- Method: findByName() ---------------------------------------------------->		

update()
----------------

**Description**: Updates an entity.

**Implementing Class**: com.wadpam.survey.web.OldVersionController

**REST path**: POST     /{domain}/survey/v10/{surveyId}/oldversion/v10/{id}

**Request parameters**:

| Where | Name | Type | Description |
|-------|------|------|-------------|
| path | id | [Long](#long) | the id of the entity to update |
| body (properties separately) | <a href="api.html#com.wadpam.survey.json.JVersion" class="link">com.wadpam.survey.json.JVersion</a> | [{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"description"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div>}](#<div>&nbsp;&nbsp;&nbsp;<b>"apparg0"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createdby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"createddate"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"description"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"id"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"questions"<b>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;,<div><div>&nbsp;&nbsp;&nbsp;<b>"state"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"surveyid"<b>&nbsp;:&nbsp;long,<div><div>&nbsp;&nbsp;&nbsp;<b>"updatedby"<b>&nbsp;:&nbsp;string,<div><div>&nbsp;&nbsp;&nbsp;<b>"updateddate"<b>&nbsp;:&nbsp;long,<div>) | the JSON object for this updated entity |


**Response Codes**:

| HTTP Response Code | Message | Description |
|--------------------|---------|-------------|
| 204 | No Content | The entity was updated by AJAX |
| 302 | OK | The entity was updated |

**Response Type**: [java.net.URL](#javaneturl)

**Response Example**:
{<div>&nbsp;&nbsp;&nbsp;<b>"appArg0"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"createdDate"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"description"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"id"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"questions"</b>&nbsp;:&nbsp;{&nbsp;&nbsp;&nbsp;},</div><div>&nbsp;&nbsp;&nbsp;<b>"state"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"surveyId"</b>&nbsp;:&nbsp;Long,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedBy"</b>&nbsp;:&nbsp;String,</div><div>&nbsp;&nbsp;&nbsp;<b>"updatedDate"</b>&nbsp;:&nbsp;Long,</div>}
				

JSON Objects
============

<!-- JSON object: com.wadpam.open.json.JCursorPage ---------------------------------------------------->		
com.wadpam.open.json.JCursorPage
------------

| Name | Type | Description |
|------|------|-------------|
| cursorKey | [java.lang.String](#javalangstring) | 
 |
| items | [java.util.Collection](#javautilcollection) | 
 |
| pageSize | [int](#int) | 
 |
<!-- JSON object: com.wadpam.survey.json.JAnswer ---------------------------------------------------->		
com.wadpam.survey.json.JAnswer
------------

| Name | Type | Description |
|------|------|-------------|
| surveyId | [java.lang.Long](#javalanglong) | The survey this answer is for
 |
| questionId | [java.lang.Long](#javalanglong) | The question this answer is for
 |
| responseId | [java.lang.Long](#javalanglong) | The response this answer is for
 |
| answer | [java.lang.String](#javalangstring) | The type of the answer is given by the question
 |
| versionId | [java.lang.Long](#javalanglong) | The survey version this answer is for
 |
<!-- JSON object: com.wadpam.survey.json.JOption ---------------------------------------------------->		
com.wadpam.survey.json.JOption
------------

| Name | Type | Description |
|------|------|-------------|
| appArg0 | [java.lang.String](#javalangstring) | Application-specific attribute
 |
| surveyId | [java.lang.Long](#javalanglong) | The survey this answer is for
 |
| questionId | [java.lang.Long](#javalanglong) | The question this answer is for
 |
| label | [java.lang.String](#javalangstring) | The text label for this option
 |
| versionId | [java.lang.Long](#javalanglong) | The survey version this answer is for
 |
<!-- JSON object: com.wadpam.survey.json.JQuestion ---------------------------------------------------->		
com.wadpam.survey.json.JQuestion
------------

| Name | Type | Description |
|------|------|-------------|
| appArg0 | [java.lang.String](#javalangstring) | Application-specific attribute
 |
| surveyId | [java.lang.Long](#javalanglong) | The survey this question is for
 |
| ordering | [java.lang.Long](#javalanglong) | The order of this question within the Survey
 |
| question | [java.lang.String](#javalangstring) | The default localization of the question
 |
| required | [java.lang.Long](#javalanglong) | Indicates if an answer is required: REQUIRED, OPTIONAL, REMINDER.
 |
| type | [java.lang.Long](#javalanglong) | The answer type: TEXT, NUMBER, IMAGE, ...
 |
| options | [java.util.Collection](#javautilcollection) | The options configured for this question
 |
| versionId | [java.lang.Long](#javalanglong) | The version this question is for
 |
<!-- JSON object: com.wadpam.survey.json.JResponse ---------------------------------------------------->		
com.wadpam.survey.json.JResponse
------------

| Name | Type | Description |
|------|------|-------------|
| surveyId | [java.lang.Long](#javalanglong) | The survey this response is for
 |
| answers | [java.util.Collection](#javautilcollection) | The answers for this response
 |
| versionId | [java.lang.Long](#javalanglong) | The survey version this response is for
 |
| extLocationId | [java.lang.String](#javalangstring) | ID of related location (external system)
 |
| extMeetingId | [java.lang.String](#javalangstring) | ID of related meeting (external system)
 |
| extProductId | [java.lang.String](#javalangstring) | ID of related product (external system)
 |
| extUserId | [java.lang.String](#javalangstring) | ID of related user (external system)
 |
<!-- JSON object: com.wadpam.survey.json.JSurvey ---------------------------------------------------->		
com.wadpam.survey.json.JSurvey
------------

| Name | Type | Description |
|------|------|-------------|
| appArg0 | [java.lang.String](#javalangstring) | Application-specific attribute
 |
| title | [java.lang.String](#javalangstring) | The title of this survey
 |
| versions | [java.util.Collection](#javautilcollection) | The Versions configured for this survey
 |
<!-- JSON object: com.wadpam.survey.json.JVersion ---------------------------------------------------->		
com.wadpam.survey.json.JVersion
------------

| Name | Type | Description |
|------|------|-------------|
| appArg0 | [java.lang.String](#javalangstring) | Application-specific attribute
 |
| description | [java.lang.String](#javalangstring) | The description of this survey version
 |
| surveyId | [java.lang.Long](#javalanglong) | The survey relation
 |
| questions | [java.util.Collection](#javautilcollection) | The Questions configured for this survey
 |
<!-- JSON object: java.lang.Long ---------------------------------------------------->		
java.lang.Long
------------

| Name | Type | Description |
|------|------|-------------|
| chars | [void](#void) |  |
| long | [java.lang.Long](#javalanglong) |  |
| long | [java.lang.Long](#javalanglong) |  |
| long | [java.lang.Long](#javalanglong) |  |
<!-- JSON object: java.lang.Object ---------------------------------------------------->		
java.lang.Object
------------

| Name | Type | Description |
|------|------|-------------|
| class | [java.lang.Class](#javalangclass) |  |
<!-- JSON object: java.lang.String ---------------------------------------------------->		
java.lang.String
------------

| Name | Type | Description |
|------|------|-------------|
| empty | [boolean](#boolean) |  |
| chars | [void](#void) |  |
| chars | [void](#void) |  |
| bytes | [void](#void) |  |
| bytes | [byte](#byte) |  |
| bytes | [byte](#byte) |  |
| bytes | [byte](#byte) |  |
<!-- JSON object: java.net.URI ---------------------------------------------------->		
java.net.URI
------------

| Name | Type | Description |
|------|------|-------------|
| scheme | [java.lang.String](#javalangstring) | 
 |
| absolute | [boolean](#boolean) |  |
| opaque | [boolean](#boolean) |  |
| rawSchemeSpecificPart | [java.lang.String](#javalangstring) |  |
| schemeSpecificPart | [java.lang.String](#javalangstring) | 
 |
| rawAuthority | [java.lang.String](#javalangstring) |  |
| authority | [java.lang.String](#javalangstring) | 
 |
| rawUserInfo | [java.lang.String](#javalangstring) |  |
| userInfo | [java.lang.String](#javalangstring) | 
 |
| host | [java.lang.String](#javalangstring) | 
 |
| port | [int](#int) | 
 |
| rawPath | [java.lang.String](#javalangstring) |  |
| path | [java.lang.String](#javalangstring) | 
 |
| rawQuery | [java.lang.String](#javalangstring) |  |
| query | [java.lang.String](#javalangstring) | 
 |
| rawFragment | [java.lang.String](#javalangstring) |  |
| fragment | [java.lang.String](#javalangstring) | 
 |
<!-- JSON object: java.util.Collection ---------------------------------------------------->		
java.util.Collection
------------

| Name | Type | Description |
|------|------|-------------|
| empty | [boolean](#boolean) |  |
<!-- JSON object: org.springframework.http.ResponseEntity ---------------------------------------------------->		
org.springframework.http.ResponseEntity
------------

| Name | Type | Description |
|------|------|-------------|
| statusCode | [org.springframework.http.HttpStatus](#orgspringframeworkhttphttpstatus) | 
 |


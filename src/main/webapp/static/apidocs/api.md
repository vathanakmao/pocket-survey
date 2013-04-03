<!-- Table of Contents ---------------------------------------------------->
Contents
========


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
| totalSize | [java.lang.Integer](#javalanginteger) | 
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
<!-- JSON object: java.lang.Integer ---------------------------------------------------->		
java.lang.Integer
------------

| Name | Type | Description |
|------|------|-------------|
| chars | [void](#void) |  |
| integer | [java.lang.Integer](#javalanginteger) |  |
| integer | [java.lang.Integer](#javalanginteger) |  |
| integer | [java.lang.Integer](#javalanginteger) |  |
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


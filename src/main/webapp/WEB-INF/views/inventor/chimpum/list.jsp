<%@page language="java"%> 
 
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%> 
 
<acme:list> 
	<acme:list-column code="patron.chimpum.list.label.code" path="code"/> 
	<acme:list-column code="patron.chimpum.list.label.title" path="title"/>
	<acme:list-column code="patron.chimpum.list.label.budget" path="budget"/>
	<acme:list-column code="patron.chimpum.list.label.start_date" path="startDate"/>	 
	<acme:list-column code="patron.chimpum.list.label.end_date" path="endDate"/>
	<acme:list-column code="patron.chimpum.list.label.creationMoment" path="creationMoment"/>
</acme:list>  
<acme:button code="patron.chimpum.list.button.create-chimpum" action="/inventor/chimpum/create"/>
<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="inventor.chimpum.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.chimpum.form.label.title" path="title"/>
	<acme:input-textarea code="inventor.chimpum.form.label.description" path="description"/>
	<jstl:if test="${command != 'create'}">	
	<acme:input-moment code="inventor.chimpum.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:input-moment code="inventor.chimpum.form.label.startDate" path="startDate"/>
	<acme:input-moment code="inventor.chimpum.form.label.endDate" path="endDate" />
	<acme:input-money code="inventor.chimpum.form.label.budget" path="budget"/>
	<acme:input-url code="inventor.chimpum.form.label.link" path="link"/>
	<jstl:choose>
		<jstl:when test="${(acme:anyOf(command,'show, update, delete') &&  itemPublished == false) || command=='create'}">
	        <acme:input-select code="inventor.chimpum.form.label.item" path="itemId">
	   			<jstl:forEach items="${items}" var="item">
					<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ itemId ==item.getId() }"/>
				</jstl:forEach>
			</acme:input-select>
		</jstl:when>
	</jstl:choose>
		
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command,'show, update, delete')}">
			<acme:input-textbox code="inventor.item.form.label.tipo" path="item.tipo" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.name" path="item.name" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.code" path="item.code" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.technology" path="item.technology" readonly="true"/>
			<acme:input-textarea code="inventor.item.form.label.description" path="item.description" readonly="true"/>
			<acme:input-money code="inventor.item.form.label.retail-price" path="item.retailPrice" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.optional-link" path="item.optionalLink" readonly="true"/>
		</jstl:when>
		
	</jstl:choose>	
	

	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command,'show, update, delete') && itemPublished == false}">
				<acme:submit code="inventor.chimpum.form.button.update" action="/inventor/chimpum/update"/> 
				<acme:submit code="inventor.chimpum.form.button.delete" action="/inventor/chimpum/delete"/>

		</jstl:when>
		<jstl:when test="${command=='create'}">
			<acme:submit code="inventor.chimpum.form.button.create" action="/inventor/chimpum/create"/>
		</jstl:when>
		
	</jstl:choose>	
	
</acme:form>



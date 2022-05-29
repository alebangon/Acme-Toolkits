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

	<acme:input-textbox code="patron.chimpum.form.label.code" path="code"/>
	<acme:input-textbox code="patron.chimpum.form.label.title" path="title"/>
	<acme:input-textarea code="patron.chimpum.form.label.description" path="description"/>
	<acme:input-moment code="patron.chimpum.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.chimpum.form.label.endDate" path="endDate" />
	<acme:input-money code="patron.chimpum.form.label.budget" path="budget"/>
	<acme:input-url code="patron.chimpum.form.label.link" path="link"/>
		<jstl:if test="${command == 'create' or command == 'update'}">	
	        <acme:input-select code="patron.chimpum.form.label.item" path="itemId">
	   			<jstl:forEach items="${items}" var="item">
					<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ item.getId() == itemId }"/>
				</jstl:forEach>
			</acme:input-select>
		</jstl:if>	
	<jstl:if test="${command == 'show'}">
	 <acme:input-select code="patron.chimpum.form.label.item" path="item">
 		<jstl:forEach items="${items}" var="item">
			<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ item.getId() == itemId }"/>
		</jstl:forEach>
	</acme:input-select>
	<acme:input-select code="inventor.item.form.label.tipo" path="tipo">
		<acme:input-option code="TOOL" value="TOOL"
			selected="${tipo == 'TOOL'}" />
		<acme:input-option code="COMPONENT" value="COMPONENT"
			selected="${tipo == 'COMPONENT'}" />
	</acme:input-select>
	<acme:input-textbox code="inventor.item.form.label.name" path="item.name" />
	<acme:input-textbox code="inventor.item.form.label.code" path="item.code" />
	<acme:input-textbox code="inventor.item.form.label.technology"
		path="item.technology" />
	<acme:input-textarea code="inventor.item.form.label.description"
		path="item.description" />
	<acme:input-money code="inventor.item.form.label.retail-price"
		path="item.retailPrice" />
	<acme:input-textbox code="inventor.item.form.label.technology"
		path="item.optionalLink" />
	</jstl:if>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command,'show, update, delete')}">
			
			<acme:submit code="patron.chimpum.form.button.update" action="/patron/chimpum/update"/> 
			<acme:submit code="patron.chimpum.form.button.delete" action="/patron/chimpum/delete"/>
			                                                                                             
		</jstl:when>
		
		<jstl:when test="${command=='create'}">
			<acme:submit code="patron.chimpum.form.button.create" action="/patron/chimpum/create"/>
		</jstl:when>
		
	</jstl:choose>	
	
</acme:form>



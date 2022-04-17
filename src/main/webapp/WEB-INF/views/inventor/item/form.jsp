<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-select code="inventor.item.form.label.tipo" path="tipo">
		<acme:input-option code="TOOL" value="TOOL" selected="${tipo == 'TOOL'}"/>
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${tipo == 'COMPONENT'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.item.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.item.form.label.code" path="code"/>	
	<acme:input-textbox code="inventor.item.form.label.technology" path="technology"/>
	<acme:input-textarea code="inventor.item.form.label.description" path="description"/>	
	<acme:input-money code="inventor.item.form.label.retail-price" path="retailPrice"/>
	<acme:input-url code="inventor.item.form.label.optional-link" path="optionalLink"/>	
	<acme:input-textbox code="inventor.item.form.label.inventor" path="inventor.userAccount.username"/>
	<acme:input-textbox code="inventor.item.form.label.published" path="published"/>
</acme:form>
<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
	
		<acme:menu-option code="master.menu.any">
			<acme:menu-suboption code="master.menu.any.published-items" action="/any/item/list"/>
			<acme:menu-suboption code="master.menu.any.all-chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.any.published-toolkits" action="/any/toolkit/list"/>
			<acme:menu-suboption code="master.menu.any.enabled-userAccounts" action="/any/user-account/list"/>		
		</acme:menu-option>
	
	
	
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-julia" action="https://this-person-does-not-exist.com/es"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-pablo" action="https://www.marca.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-javier" action="https://www.nintendo.es/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-jesus" action="http://www.vamosmisevilla.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-alejandro" action="https://www.youtube.com/watch?v=IfAcrSwaeU0"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-roman" action="https://www.youtube.com/watch?v=gdsUKphmB3Y&ab_channel=NFL"/>
			
		</acme:menu-option>
		
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated">
      		<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.system-configuration" action="/authenticated/system-configuration/show"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create"/>	
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>	
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.system-configuration" action="/administrator/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.administrator-dashboard" action="/administrator/administrator-dashboard/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
			<acme:menu-separator/>
			
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.list-patronages" action="/patron/patronage/list"/>
      		<acme:menu-suboption code="master.menu.patron.list-patronage-reports" action="/patron/patronage-report/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.patron.patron-dashboard" action="/patron/patron-dashboard/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.patron.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
			<acme:menu-suboption code="master.menu.inventor.item.list" action="/inventor/item/list"/>
			<acme:menu-suboption code="master.menu.inventor.toolkits.list" action="/inventor/toolkit/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.patron.chimpum" action="/inventor/chimpum/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.inventor.list-patronages" action="/inventor/patronage/list"/>
			<acme:menu-suboption code="master.menu.inventor.list-proposed-patronages" action="/inventor/patronage/list-proposed"/>
      		<acme:menu-suboption code="master.menu.inventor.patronage-reports" action="/inventor/patronage-report/list"/>
			<acme:menu-suboption code="master.menu.inventor.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')"/>		
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>


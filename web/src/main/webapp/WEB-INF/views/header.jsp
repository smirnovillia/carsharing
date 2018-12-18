<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}" />
<header>
	<ul id="data" class="dropdown-content">
		<li><a href="${baseUrl}/data/brand">brand</a></li>
		<li><a href="${baseUrl}/data/model">model</a></li>
		<li><a href="${baseUrl}/data/color">color</a></li>
		<li><a href="${baseUrl}/data/tracking">tracking</a></li>
	</ul>
	<nav>
		<div class="nav-wrapper container">

			<ul class="left hide-on-med-and-down">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="${baseUrl}/car">Cars</a></li>
					<li><a href="${baseUrl}/user">Users</a></li>
					<li><a class="dropdown-trigger" data-target="data">Data<i class="material-icons right">arrow_drop_down</i></a></li>
					<a class="right" href="${baseUrl}/execute_logout" title="logout"><i
						class="material-icons">arrow_forward</i></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_CUSTOMER')">
					<li><a href="${baseUrl}/car">Order</a></li>
					<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
					<a class="right" href="${baseUrl}/execute_logout" title="logout"><i
						class="material-icons">arrow_forward</i></a>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</header>
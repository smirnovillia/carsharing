<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}" />
<header>
	<ul id="data" class="dropdown-content">

	</ul>
	<nav>
		<div class="nav-wrapper container">

			<ul class="left hide-on-med-and-down">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="${baseUrl}/car">Cars</a></li>
					<li><a href="${baseUrl}/user">Users</a></li>


					<li><a href="${baseUrl}/data/brand">Brand</a></li>
					<li><a href="${baseUrl}/data/model">Model</a></li>
					<li><a href="${baseUrl}/data/color">Color</a></li>
					<li><a href="${baseUrl}/data/tracking">Tracking</a></li>



				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_CUSTOMER')">
					<li><a href="${baseUrl}/car">Order</a></li>
					<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
				</sec:authorize>
			</ul>
			<ul class="right">
				<sec:authorize access="!isAnonymous()">
					<a href="${baseUrl}/execute_logout" title="logout"><i
						class="material-icons">arrow_forward</i></a>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</header>
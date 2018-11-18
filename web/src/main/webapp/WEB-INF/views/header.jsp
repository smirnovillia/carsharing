<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}" />
<header>
	<nav>
		<div class="nav-wrapper container">
			<ul class="left hide-on-med-and-down">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="${baseUrl}/car">Cars</a></li>
					<li><a href="${baseUrl}/customer">Customers</a></li>
					<a class="right" href="${baseUrl}/execute_logout" title="logout"><i
						class="material-icons">arrow_forward</i></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="${baseUrl}/">Home</a></li>
					<li><a href="${baseUrl}/search">Search</a></li>
					<a class="right" href="${baseUrl}/execute_logout" title="logout"><i
						class="material-icons">arrow_forward</i></a>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</header>
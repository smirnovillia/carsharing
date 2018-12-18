<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<h4 class="header">Cars</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="model">model</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}"
					column="releaseDate">release date</mytaglib:sort-link></th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="vin">vin</mytaglib:sort-link></th>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="color">color</mytaglib:sort-link></th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="mileage">mileage</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="condition">condition</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="created">created</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="updated">updated</mytaglib:sort-link></th>
			</sec:authorize>
			<th></th>
		</tr>
		<c:forEach var="car" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
					<td><c:out value="${car.id}" /></td>
					<td><c:out value="${car.modelName}" /></td>
					<td><c:out value="${car.releaseDate}" /></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><c:out value="${car.vin}" /></td>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
					<td><c:out value="${car.colorName}" /></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><c:out value="${car.mileage}" /></td>
					<td><c:out value="${car.condition}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${car.created}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${car.updated}" /></td>
				</sec:authorize>
				<td class="right">
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')">
					<a class="btn-floating" href="${pagesCar}/${car.id}"><i class="material-icons">info</i></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_CUSTOMER')">
					<a class="btn-floating" href="${pagesCar}/${car.id}/order"><i class="material-icons">attach_money</i></a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="btn-floating blue" href="${pagesTracking}/add?carId=${car.id}"><i class="material-icons">track_changes</i></a>
					<a class="btn-floating" href="${pagesCar}/${car.id}/edit"><i class="material-icons">edit</i></a>
					<a class="btn-floating red" href="${pagesCar}/${car.id}/delete"><i class="material-icons">delete</i></a>
				</sec:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />

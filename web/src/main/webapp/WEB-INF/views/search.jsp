<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Search</h4>
<div class="row">
		<div class="card-panel blue lighten-5">
			<div class="row">
				<form:form method="POST" action="${pagesSearch}"modelAttribute="searchFormModel">
					<div class="row">
						<div class="input-field col s12">
							<form:select path="body" disabled="${readonly}">
								<form:options items="${bodyChoices}" />
							</form:select>
							<form:errors path="body" cssClass="red-text" />
							<label for="body">body</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:select path="fuel" disabled="${readonly}">
								<form:options items="${fuelChoices}" />
							</form:select>
							<form:errors path="fuel" cssClass="red-text" />
							<label for="fuel">fuel</label>
						</div>
					</div>
						<div class="row">
						<div class="input-field col s12">
							<form:select path="drive" disabled="${readonly}">
								<form:options items="${driveChoices}" />
							</form:select>
							<form:errors path="drive" cssClass="red-text" />
							<label for="drive">drive</label>
						</div>
					</div>
						<div class="row">
						<div class="input-field col s12">
							<form:select path="gearbox" disabled="${readonly}">
								<form:options items="${gearboxChoices}" />
							</form:select>
							<form:errors path="gearbox" cssClass="red-text" />
							<label for="gearbox">gearbox</label>
						</div>
					</div>
					<div class="col s4">
						<button class="btn waves-effect waves-light right" type="submit">search</button>
					</div>
				</form:form>
			</div>
		</div>
</div>
<table class="bordered highlight">
	<tbody>
			<tr>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="model">model</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}"
					column="releaseDate">release date</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="color">color</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesCar}" column="mileage">mileage</mytaglib:sort-link></th>
			<th></th>
		</tr>
		<c:forEach var="car" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${car.id}" /></td>
				<td><c:out value="${car.modelName}" /></td>
				<td><c:out value="${car.colorName}" /></td>
				<td><c:out value="${car.mileage}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
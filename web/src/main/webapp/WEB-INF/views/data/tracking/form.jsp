<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Add tracking</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesTracking}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<form:input path="carId" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="latitude" type="number" step="any" disabled="${readonly}" />
				<form:errors path="latitude" cssClass="red-text" />
				<label for="latitude">latitude</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="longitude" type="number" step="any" disabled="${readonly}" />
				<form:errors path="longitude" cssClass="red-text" />
				<label for="longitude">longitude</label>
			</div>
		</div>
		<div class="row">
			<div class="col s12 center">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light " type="submit">save</button>
				</c:if>
				<a class="btn waves-effect waves-light red" href="${pagesTracking}">back<i
					class="material-icons "></i>
				</a>
			</div>
		</div>
	</form:form>
</div>



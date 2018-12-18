<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit car</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesCar}/add"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<form:input path="modelId" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">Model</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="releaseDate" disabled="${readonly}">
					<form:options items="${releaseDateChoices}" />
				</form:select>
				
				<form:errors path="releaseDate" cssClass="red-text" />
				<label for="releaseDate">Release date</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="vin" type="text" disabled="${readonly}" />
				<form:errors path="vin" cssClass="red-text" />
				<label for="vin">VIN</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="colorId" disabled="${readonly}">
					<form:options items="${colorChoices}" />
				</form:select>
				<form:errors path="colorId" cssClass="red-text" />
				<label for="colorId">Color</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="mileage" type="number" disabled="${readonly}" />
				<form:errors path="mileage" cssClass="red-text" />
				<label for="mileage">Mileage</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="condition" disabled="${readonly}">
					<form:options items="${conditionChoices}" />
				</form:select>
				<form:errors path="condition" cssClass="red-text" />
				<label for="condition">Condition</label>
			</div>
		</div>
		<div class="row">
			<div class="col s12 center">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light" type="submit">save</button>
				</c:if>
				<a class="btn waves-effect waves-light red" href="${pagesCar}">back<i
					class="material-icons "></i>
				</a>
			</div>
		</div>
	</form:form>
</div>

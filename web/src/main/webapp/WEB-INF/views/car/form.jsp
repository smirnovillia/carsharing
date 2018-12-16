<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit car</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesCar}/add"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />

		<div class="row">
			<div class="input-field col s12">
				<form:select path="modelId" disabled="${readonly}">
					<form:options items="${modelChoices}" />
				</form:select>
				<form:errors path="modelId" cssClass="red-text" />
				<label for="modelId">model</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modification.body" disabled="${readonly}">
					<form:options items="${bodyChoices}" />
				</form:select>
				<form:errors path="modification.body" cssClass="red-text" />
				<label for="modification.body">body</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modification.fuel" disabled="${readonly}">
					<form:options items="${fuelChoices}" />
				</form:select>
				<form:errors path="modification.fuel" cssClass="red-text" />
				<label for="modification.fuel">fuel</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modification.drive" disabled="${readonly}">
					<form:options items="${driveChoices}" />
				</form:select>
				<form:errors path="modification.drive" cssClass="red-text" />
				<label for="modification.body">drive</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modification.gearbox" disabled="${readonly}">
					<form:options items="${gearboxChoices}" />
				</form:select>
				<form:errors path="modification.gearbox" cssClass="red-text" />
				<label for="modification.gearbox">gearbox</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:input path="releaseDate" type="text" disabled="${readonly}" />
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
				<label for="colorId">color</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:input path="mileage" type="text" disabled="${readonly}" />
				<form:errors path="mileage" cssClass="red-text" />
				<label for="mileage">mileage</label>
			</div>
		</div>
			<div class="row">
			<div class="input-field col s12">
				<form:select path="condition" disabled="${readonly}">
					<form:options items="${conditionChoices}" />
				</form:select>
				<form:errors path="condition" cssClass="red-text" />
				<label for="condition">condition</label>
			</div>
		</div>	
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">saveå</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${pagesCar}">back<i
					class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>

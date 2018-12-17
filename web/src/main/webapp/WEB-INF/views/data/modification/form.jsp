<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit model modification</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesModification}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<form:input path="modelId" type="hidden" />
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

		<div class="row">
			<div class="input-field col s12">
				<form:input path="engineCapacity" type="number"
					disabled="${readonly}" />
				<form:errors path="engineCapacity" cssClass="red-text" />
				<label for="engineCapacity">engineCapacity</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="tankCapacity" type="number" disabled="${readonly}" />
				<form:errors path="tankCapacity" cssClass="red-text" />
				<label for="tankCapacity">tankCapacity</label>
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

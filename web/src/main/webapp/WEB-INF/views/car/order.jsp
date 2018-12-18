<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Order</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesCar}/order"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<form:input path="modelId" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">model</label>
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
		<form:input path="vin" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:select path="colorId" disabled="${readonly}">
					<form:options items="${colorChoices}" />
				</form:select>
				<form:errors path="colorId" cssClass="red-text" />
				<label for="colorId">color</label>
			</div>
		</div>
		<form:input path="mileage" type="hidden" />
		<form:input path="condition" type="hidden" value='ORDERED' />
		<div class="row">
			<div class="col s12 center">
				<button class="btn waves-effect waves-light" type="submit">order</button>
				<a class="btn waves-effect waves-light red" href="${pagesCar}">back<i
					class="material-icons "></i>
				</a>
			</div>
		</div>
	</form:form>
</div>


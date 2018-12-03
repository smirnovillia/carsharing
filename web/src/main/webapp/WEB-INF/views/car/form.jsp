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
					<form:options items="${modelsChoices}" />
				</form:select>
				<form:errors path="modelId" cssClass="red-text" />
				<label for="modelId">model</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">modification</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="releaseDate" disabled="${readonly}">
					<form:options items="${releaseChoices}" />
				</form:select>
				<form:errors path="releaseDate" cssClass="red-text" />
				<label for="releaseDate">release date</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">modification</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">modification</label>
			</div>
		</div>	
		<div class="row">
			<div class="input-field col s12">
				<form:select path="modificationId" disabled="${readonly}">
					<form:options items="${modificationsChoices}" />
				</form:select>
				<form:errors path="modificationId" cssClass="red-text" />
				<label for="modificationId">modification</label>
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

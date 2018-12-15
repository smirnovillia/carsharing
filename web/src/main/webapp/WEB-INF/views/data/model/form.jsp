<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit model</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesModel}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name">name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="brandName" disabled="${readonly}">
					<form:options items="${brandChoices}" />
				</form:select>
				<form:errors path="brandName" cssClass="red-text" />
				<label for="brandName">brand</label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">save</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${pagesModel}">list<i
					class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>



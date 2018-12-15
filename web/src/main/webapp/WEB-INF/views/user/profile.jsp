<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Profile</h4>
<div class="row">
	<form:form class="col s12" method="GET" action="${pagesUser}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="customer.firstName" type="text" disabled="${readonly}" />
				<form:errors path="customer.firstName" cssClass="red-text" />
				<label for="customer.firstName">First name</label>
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
				<a class="btn waves-effect waves-light right" href="${pagesUser}">list<i
					class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
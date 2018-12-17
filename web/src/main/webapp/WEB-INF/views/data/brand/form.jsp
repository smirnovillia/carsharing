<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit brand</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${pagesBrand}"
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
			<div class="col s12 center">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light " type="submit">save</button>
				</c:if>
				<a class="btn waves-effect waves-light red" href="${pagesBrand}">back<i
					class="material-icons "></i>
				</a>
			</div>
		</div>
	</form:form>
</div>



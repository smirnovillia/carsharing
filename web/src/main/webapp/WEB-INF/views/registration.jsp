<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Registration Form</h3>
<div class="row">
	<form:form class="col s12" method="POST" modelAttribute="formUser">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="login" type="text" disabled="${readonly}" />
				<form:errors path="login" cssClass="red-text" />
				<label for="login">Login</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="password" type="password" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="name">Password</label>
			</div>
		</div>
	</form:form>
	<form:form class="col s12" method="POST" modelAttribute="formCustomer">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="firstName" type="text" disabled="${readonly}" />
				<form:errors path="firstName" cssClass="red-text" />
				<label for="firstName">First Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="lastName" type="text" disabled="${readonly}" />
				<form:errors path="lastName" cssClass="red-text" />
				<label for="lastName">Last Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="birthday" type="text" disabled="${readonly}"
					cssClass="datepicker" />
				<form:errors path="birthday" cssClass="red-text" />
				<label for="birthday">Birthday</label>
			</div>
		</div>
		<div class="row">
			<form method="POST" enctype="multipart/form-data">
				<div class="file-field input-field col s12 center">
					<div class="btn">
						<span>File</span> <input type="file">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path validate" type="text" name="driverLicense"
							placeholder="Driver license">
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<form method="POST" enctype="multipart/form-data">
				<div class="file-field input-field col s12 center">
					<div class="btn">
						<span>File</span> <input type="file" name="f1">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path validate" type="text" name="passport"
							placeholder="Passport">
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<form method="POST" enctype="multipart/form-data">
				<div class="file-field input-field col s12 center">
					<div class="btn">
						<span>File</span> <input type="file" name="f2">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path validate" type="text" name="image"
							placeholder="Image">
					</div>
				</div>
			</form>
		</div>
	</form:form>
	<div class="row">
		<div class="col s10">
			<a class="btn waves-effect waves-light right" href="${contextPath}">back<i
				class="material-icons right"></i>
			</a>
		</div>
		<div class="col s2">
			<c:if test="${!readonly}">
				<button class="btn waves-effect waves-light right" type="submit">
					<i class="material-icons right">save</i>save
				</button>
			</c:if>
		</div>
	</div>
</div>

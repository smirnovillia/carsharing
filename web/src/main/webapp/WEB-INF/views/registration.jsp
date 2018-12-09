<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Registration Form</h3>
<div class="row">
	<form:form class="col s12" method="POST" modelAttribute="formModel"
		enctype="multipart/form-data">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="login" type="text" disabled="${readonly}" />
				<br>
				<form:errors path="login" cssClass="red-text" />
				<label for="login">Login</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="password" type="password"
					disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="name">Password</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="customer.firstName" type="text" disabled="${readonly}" />
				<form:errors path="customer.firstName" cssClass="red-text" />
				<label for="firstName">First Name</label>
			</div>
		</div>
		<form:input path="userRole" type="hidden" value='1' />
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="customer.lastName" type="text" disabled="${readonly}" />
				<form:errors path="customer.lastName" cssClass="red-text" />
				<label for="lastName">Last Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="customer.birthday" type="text" disabled="${readonly}"
					cssClass="datepicker" />
				<form:errors path="customer.birthday" cssClass="red-text" />
				<label for="birthday">Birthday</label>
			</div>
		</div>
		<div class="row">
			<div class="file-field input-field">
				<div class="btn">
					<span>File</span> <input type="file" name = "file">
				</div>
				<div class="file-path-wrapper">
					<input class="file-path validate" type="text">
				</div>
			</div>
		</div>
		<form:input path="customer.driverLicenseStatus" type="hidden" value='true' />
		<div class="row">
			<div class="col s10">
				<a class="btn waves-effect waves-light right" href="${contextPath}">back<i
					class="material-icons right"></i>
				</a>
			</div>
			<div class="col s2">
				<button class="btn waves-effect waves-light right" type="submit">
					<i class="material-icons right">save</i>save
				</button>
			</div>
		</div>
	</form:form>
</div>



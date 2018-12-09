<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Registration Form</h3>
<div class="row">
	<form:form class="col s12" method="POST" modelAttribute="formModel"
		enctype="multipart/form-data">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="user.login" type="text" disabled="${readonly}" />
				<br>
				<form:errors path="user.login" cssClass="red-text" />
				<label for="login">Login</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 center">
				<form:input path="user.password" type="password"
					disabled="${readonly}" />
				<form:errors path="user.password" cssClass="red-text" />
				<label for="name">Password</label>
			</div>
		</div>
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
			<div class="file-field input-field">
				<div class="btn">
					<span>File</span> <input type="file" name = "file">
				</div>
				<div class="file-path-wrapper">
					<input class="file-path validate" type="text">
				</div>
			</div>
		</div>
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



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Registration Form</h3>
<div class="row">
	<form:form class="col s12" method="POST" modelAttribute="formUser">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="login" type="text" disabled="${readonly}" />
				<form:errors path="login" cssClass="red-text" />
				<label for="login">login</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="password" type="password" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="name">password</label>
			</div>
		</div>
	</form:form>
	<form:form class="col s12" method="POST" modelAttribute="formCustomer">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="firstName" type="text" disabled="${readonly}" />
				<form:errors path="firstName" cssClass="red-text" />
				<label for="firstName">First Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="lastName" type="text" disabled="${readonly}" />
				<form:errors path="lastName" cssClass="red-text" />
				<label for="lastName">Last Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<form:input path="birthday" type="text" disabled="${readonly}"
					cssClass="datepicker" />
				<form:errors path="birthday" cssClass="red-text" />
				<label for="birthday">Birthday</label>
			</div>
		</div>
		<div>
			<form method="POST" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Driver license:</td>
						<td><input type="file" name="driverLicense" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Upload" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<form method="POST" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Passport:</td>
						<td><input type="file" name="passport" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Upload" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<form method="POST" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Image:</td>
						<td><input type="file" name="image" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Upload" /></td>
					</tr>
				</table>
			</form>
		</div>
	</form:form>
	<div class="row">
		<div class="col s6"></div>
		<div class="col s3">
			<c:if test="${!readonly}">
				<button class="btn waves-effect waves-light right" type="submit">save</button>
			</c:if>
		</div>
		<div class="col s3">
			<a class="btn waves-effect waves-light right" href="${contextPath}">back<i
				class="material-icons right"></i>
			</a>
		</div>
	</div>
</div>

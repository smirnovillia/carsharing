<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Login with Username and Password</h3>
<div class="row">
	<div class="col s3"></div>
	<div class="col s6">
		<form name='loginForm' action="<c:url value='login' />" method='POST'>
			<div class="row">
				<div class="input-field col s12 center">
					<input type='text' name='username' value=''> <label
						for="username">User:</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 center">
					<input type='password' name='password' /><label for="password">Password:</label>
				</div>
			</div>
			<c:if test="${not empty error}">
				<div class="row">
					<div class="col s12 center">
						<div class="error">${error}</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="row">
					<div class="col s12 center">
						<div class="msg">${msg}</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col s12 center">
					<a class="btn waves-effect waves-light" href="${contextPath}">back<i
						class="material-icons right"></i>
					</a>
					<button class="btn waves-effect waves-light " type="submit">Sign
						in</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col s3"></div>
</div>
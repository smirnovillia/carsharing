<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Registration From</h3>
<div class="row">
	<div class="col s3"></div>
	<div class="col s6">
		<form name='registrationForm' action="<c:url value='registration' />"
			method='POST'>

			<div class="row">
				<div class="input-field col s6">
					<input id="first_name" type="text"
						class="validate"> <label for="first_name">First
						Name</label>
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate"> <label
						for="last_name">Last Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="email" type="email" class="validate"> <label
						for="email">Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 left">
					<input type='password' name='password' /><label for="password">Password</label>
				</div>
			</div>
			<c:if test="${not empty error}">
				<div class="row">
					<div class="col s12 center">
						<div class="error">${error}</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col s12 center">
					<button class="btn waves-effect waves-light " type="submit">next</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col s3"></div>
</div>
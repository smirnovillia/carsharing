<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Welcome to carsharing service</h3>
<div class="row">
		<form name='signIn' action="<c:url value='login' />" method='GET'>
			<div class="row">
				<div class="col s12 center">
					<button class="btn waves-effect waves-light " type="submit">Login</button>
				</div>
			</div>
			</form>
			<form name='registration' action="<c:url value='registration' />"method='GET'>
				<div class="row">
					<div class="col s12 center">
						<button class="btn waves-effect waves-light " type="submit">Registration</button>
					</div>
				</div>
			</form>
	</div>
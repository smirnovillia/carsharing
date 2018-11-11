<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Welcome to carsharing service</h3>
<div class="row">
	<form name='signIn' action="<c:url value='login' />" method='GET'>
		<div class="row">
			<div class="col s12 center">
				<button class="btn waves-effect waves-light btn-large" type="submit">Login</button>
			</div>
		</div>
	</form>
	<form name='registration' action="<c:url value='registration' />"
		method='GET'>
		<div class="row">
			<div class="col s12 center">
				<button class="btn waves-effect waves-light btn-large" type="submit">Registration</button>
			</div>
		</div>
	</form>
	<div class="row">
		<div class="col s12 center">
			<iframe src="https://yandex.com/map-widget/v1/-/CBuAzEXFPB"
				width="800" height="600" frameborder="1" allowfullscreen="true"></iframe>
		</div>

	</div>

</div>

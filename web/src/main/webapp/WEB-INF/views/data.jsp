<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<div>
	<div class="row">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="row">
				<form name='brand' action="<c:url value='brand' />" method='GET'>
					<div class="row">
						<div class="col s12 center">
							<button class="btn waves-effect waves-light btn-large"
								type="submit">Brand</button>
						</div>
					</div>
				</form>
				<form name='model' action="<c:url value='model' />" method='GET'>
					<div class="row">
						<div class="col s12 center">
							<button class="btn waves-effect waves-light btn-large"
								type="submit">Model</button>
						</div>
					</div>
				</form>
				<form name='Color' action="<c:url value='color' />" method='GET'>
					<div class="row">
						<div class="col s12 center">
							<button class="btn waves-effect waves-light btn-large"
								type="submit">Color</button>
						</div>
					</div>
				</form>
			</div>
		</sec:authorize>
	</div>
</div>

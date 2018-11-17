<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://api-maps.yandex.ru/2.1/?apikey=<423d1045-9802-4ce3-85f4-19f86fb3b0b4>&lang=en_US"
	type="text/javascript"></script>
<script type="text/javascript">
	ymaps.ready(init);
	var myMap, myPlacemark;

	function init() {
		myMap = new ymaps.Map("map", {
			center : [ 53.90, 27.56 ],
			zoom : 11
		});

		myPlacemark = new ymaps.Placemark([ 53.90, 27.56 ], {
			hintContent : 'Minsk',
			balloonContent : 'Capital of BLR'
		});

		myMap.geoObjects.add(myPlacemark);
	}
</script>
</head>
<body>
	<h3>Welcome to carsharing service</h3>
	<div class="row">
		<form name='signIn' action="<c:url value='login' />" method='GET'>
			<div class="row">
				<div class="col s12 center">
					<button class="btn waves-effect waves-light btn-large"
						type="submit">Login</button>
				</div>
			</div>
		</form>
		<form name='registration' action="<c:url value='registration' />"
			method='GET'>
			<div class="row">
				<div class="col s12 center">
					<button class="btn waves-effect waves-light btn-large"
						type="submit">Registration</button>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col s8 offset-s2 center">
				<div id="map" style="width: 100%; height: 50%"></div>
			</div>
		</div>
	</div>
</body>
</html>

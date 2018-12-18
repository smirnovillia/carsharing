function mapInit(coord) {
ymaps.ready(init);
	function init() {
//		var cars = new ymaps.GeoObject({
//		 geometry: {
//		        type: "Point",
//		        coordinates: coord
//		      });
//	
//		var myMap = new ymaps.Map("map", {
//			center : [ 53.90, 27.56 ],
//			zoom : 11
//		});


		myMap.geoObjects.add(cars);
	}
	}

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div data-role="carousel">
	<div data-role="mySlides">
		<ul style="padding-left: 0px;">
		
			<img class="mySlides" src="resources/images/p33.jpg" width="100%" height="100%" style="display : none">
			<img class="mySlides" src="resources/images/p22.jpg" width="1325" height="540">
			<img class="mySlides" src="resources/images/p11.jpg" width="1325" height="540">
		</ul>
	</div>
</div>
	<script>
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 3000); // Change image every 2 seconds
		}
	</script>

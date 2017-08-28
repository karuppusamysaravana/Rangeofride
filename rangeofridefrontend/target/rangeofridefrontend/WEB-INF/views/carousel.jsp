<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div data-role="carousel">
	<div data-role="mySlides">
		<ul style="padding-left: 0px;">
		
			<img class="mySlides" src="resources/images/p1.jpg" width="100%" height="auto" style="display : none">
			<img class="mySlides" src="resources/images/p2.jpg" width="100%" height="40%" style="display : none">
			<img class="mySlides" src="resources/images/p3.jpg" width="100%" height="40%" style="display : none">
		 </style>
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

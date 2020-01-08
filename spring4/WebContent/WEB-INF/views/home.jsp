<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />		
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />	
	
	<title>sign test</title>
		 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>    	    	
	    var clickX = new Array();
		var clickY = new Array();
		var clickDrag = new Array();
		
		var clickX2 = new Array();
		var clickY2 = new Array();
		var clickDrag2 = new Array();
		
		var paint;
		var canvas;
		var context;
		
		var paint2;
		var canvas2;
		var context2;
		
		/** Clear Canvas **/
		function clearSig() {
			clickX = new Array();
			clickY = new Array();
			clickDrag = new Array();
			canvas.width = canvas.width;
			canvas.height = canvas.height;
			
			clickX2 = new Array();
			clickY2 = new Array();
			clickDrag2 = new Array();
			canvas2.width = canvas2.width;
			canvas2.height = canvas2.height;
		}
		
		/** Redraw the Canvas **/
		function redraw() {
			canvas.width = canvas.width; // Clears the canvas
	
			context.strokeStyle = "#000000";
			context.lineJoin = "miter";
			context.lineWidth = 2;
	
			for (var i = 0; i < clickX.length; i++) {
				context.beginPath();
				if (clickDrag[i] && i) {
					context.moveTo(clickX[i - 1], clickY[i - 1]);
				} else {
					context.moveTo(clickX[i] - 1, clickY[i]);
				}
				context.lineTo(clickX[i], clickY[i]);
				context.closePath();
				context.stroke();
			}
		}
		
		function redraw2() {
			canvas2.width = canvas2.width; // Clears the canvas
	
			context2.strokeStyle = "#000000";
			context2.lineJoin = "miter";
			context2.lineWidth = 2;
	
			for (var i = 0; i < clickX2.length; i++) {
				context2.beginPath();
				if (clickDrag2[i] && i) {
					context2.moveTo(clickX2[i - 1], clickY2[i - 1]);
				} else {
					context2.moveTo(clickX2[i] - 1, clickY2[i]);
				}
				context2.lineTo(clickX2[i], clickY2[i]);
				context2.closePath();
				context2.stroke();
			}
		}
	
		/** Starting a Click **/
		function addClick(x, y, dragging) {
			clickX.push(x);
			clickY.push(y);
			clickDrag.push(dragging);
		}
		
		function addClick2(x, y, dragging) {
			clickX2.push(x);
			clickY2.push(y);
			clickDrag2.push(dragging);
		}
		
		$(document).ready(function () {
			/** Set Canvas Size **/
			var canvasWidth = $("#signaturePad").width();
			var canvasHeight = $("#signaturePad").height();
			
			var canvasWidth2 = $("#signaturePad2").width();
			var canvasHeight2 = $("#signaturePad2").height();
	
			/** Set Canvas setting **/
			var canvasDiv = document.getElementById('signaturePad');
			canvas = document.createElement('canvas');
			canvas.setAttribute('width', canvasWidth);
			canvas.setAttribute('height', canvasHeight);
			canvas.setAttribute('id', 'canvas');
			canvasDiv.appendChild(canvas);
			context = canvas.getContext("2d");
			
			var canvasDiv2 = document.getElementById('signaturePad2');
			canvas2 = document.createElement('canvas');
			canvas2.setAttribute('width', canvasWidth2);
			canvas2.setAttribute('height', canvasHeight2);
			canvas2.setAttribute('id', 'canvas2');
			canvasDiv2.appendChild(canvas2);
			context2 = canvas2.getContext("2d");
	
			/**Draw when moving over Canvas **/
			$('#signaturePad').on("touchmove", function (e) {
				if (paint) {
					addClick(e.originalEvent.touches[0].pageX - this.offsetLeft, e.originalEvent.touches[0].pageY - this.offsetTop, true);
					redraw();
				}
			});
			
			$('#signaturePad2').on("touchmove", function (e) {
				if (paint2) {
					addClick2(e.originalEvent.touches[0].pageX - this.offsetLeft, e.originalEvent.touches[0].pageY - this.offsetTop, true);
					redraw2();
				}
			});
	
			/**Stop Drawing on Mouseup **/
			$('#signaturePad').on("touchend", function (e) {
				paint = false;
			});
			
			$('#signaturePad2').on("touchend", function (e) {
				paint2 = false;
			});
	
			$('#signaturePad').on("touchstart", function (e) {
				paint = true;
				addClick(e.originalEvent.touches[0].pageX - this.offsetLeft, e.originalEvent.touches[0].pageY - this.offsetTop);
				redraw();
			});
			
			$('#signaturePad2').on("touchstart", function (e) {
				console.log(e);
				paint2 = true;
				addClick2(e.originalEvent.touches[0].pageX - this.offsetLeft, e.originalEvent.touches[0].pageY - this.offsetTop);
				redraw2();
			});
		});
    </script>
</head>
<body>
	<div class="wrap">
		<div class="wrap02">
			<div class="imgPage">
				<div class="sign">
					<div class="tit">
						<strong>고객성명 입력</strong>
						<button type="button" class="btn_re" onclick="clearSig()">다시작성</button>
					</div>
					<div id="signaturePad" style="height: 100px; width: 200px;border: 1px solid;">
						
					</div>
					<div class="tit">
						<strong>고객서명 입력</strong>
					</div>
					<div id="signaturePad2" style="height: 100px; width: 200px; border: 1px solid;">
						
					</div>
				</div>
				
				<div class="btn_box type02">
					<span>
						<button type="submit" id="" class="" onclick="location.href='/insutok/smartOn/smartOn08'">이전</button>
					</span>
					<span>
						<button type="submit" class="btnCol02" onclick="location.href='/insutok/smartOn/smartOn10'">다음</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	
  </body>
</html>
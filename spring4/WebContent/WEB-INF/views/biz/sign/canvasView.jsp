<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<section>
		<div>
			<canvas id="sig-canvas" width="620" height="160"></canvas>
		</div>
		<div class="row">
			<button class="btn btn-primary" id="sig-submitBtn">Submit Signature</button>
			<button class="btn btn-default" id="sig-clearBtn">Clear Signature</button>
			<button class="btn btn-default" id="sig-ajaxBtn">AJAX TEST</button>
		</div>

		<div class="col-md-12">
			<textarea id="sig-dataUrl" class="form-control" rows="5">Data URL for your signature will go here!</textarea>
		</div>
		
		<div class="col-md-12">
			<img id="sig-image" src="" alt="Your signature will go here!"/>
		</div>
		
	</section>
	
<style >
#sig-canvas {
  border: 2px dotted #CCCCCC;
  border-radius: 15px;
  cursor: crosshair;
}
</style>
<script type="text/javaScript" defer="defer">

$(function() {
    $("#sig-ajaxBtn").on( "click", function() {
		$.ajax({
			url: "<c:url value='/sign/jsonTest'/>"
			, type: "POST"
			, dataType: "json"
			, async: true
			, contentType: "application/json;charset=UTF-8;"
			, data: JSON.stringify({ "id":"test","dataUrl":"sssss" })
			, success: function(data){
				console.log(data);
				alert(data);
			}, error: function(){
				alert('error');
			}, complete: function(){
			}
		});    	
    });
});

(function() {
	  window.requestAnimFrame = (function(callback) {
	    return window.requestAnimationFrame ||
	      window.webkitRequestAnimationFrame ||
	      window.mozRequestAnimationFrame ||
	      window.oRequestAnimationFrame ||
	      window.msRequestAnimaitonFrame ||
	      function(callback) {
	        window.setTimeout(callback, 1000 / 60);
	      };
	  })();

	  var canvas = document.getElementById("sig-canvas");
	  var ctx = canvas.getContext("2d");
	  ctx.strokeStyle = "#222222";
	  ctx.lineWidth = 2;

	  var drawing = false;
	  var mousePos = {
	    x: 0,
	    y: 0
	  };
	  var lastPos = mousePos;

	  canvas.addEventListener("mousedown", function(e) {
	    drawing = true;
	    lastPos = getMousePos(canvas, e);
	  }, false);

	  canvas.addEventListener("mouseup", function(e) {
	    drawing = false;
	  }, false);

	  canvas.addEventListener("mousemove", function(e) {
	    mousePos = getMousePos(canvas, e);
	  }, false);

	  // Add touch event support for mobile
	  canvas.addEventListener("touchstart", function(e) {

	  }, false);

	  canvas.addEventListener("touchmove", function(e) {
	    var touch = e.touches[0];
	    var me = new MouseEvent("mousemove", {
	      clientX: touch.clientX,
	      clientY: touch.clientY
	    });
	    canvas.dispatchEvent(me);
	  }, false);

	  canvas.addEventListener("touchstart", function(e) {
	    mousePos = getTouchPos(canvas, e);
	    var touch = e.touches[0];
	    var me = new MouseEvent("mousedown", {
	      clientX: touch.clientX,
	      clientY: touch.clientY
	    });
	    canvas.dispatchEvent(me);
	  }, false);

	  canvas.addEventListener("touchend", function(e) {
	    var me = new MouseEvent("mouseup", {});
	    canvas.dispatchEvent(me);
	  }, false);

	  function getMousePos(canvasDom, mouseEvent) {
	    var rect = canvasDom.getBoundingClientRect();
	    return {
	      x: mouseEvent.clientX - rect.left,
	      y: mouseEvent.clientY - rect.top
	    }
	  }

	  function getTouchPos(canvasDom, touchEvent) {
	    var rect = canvasDom.getBoundingClientRect();
	    return {
	      x: touchEvent.touches[0].clientX - rect.left,
	      y: touchEvent.touches[0].clientY - rect.top
	    }
	  }

	  function renderCanvas() {
	    if (drawing) {
	      ctx.moveTo(lastPos.x, lastPos.y);
	      ctx.lineTo(mousePos.x, mousePos.y);
	      ctx.stroke();
	      lastPos = mousePos;
	    }
	  }

	  // Prevent scrolling when touching the canvas
	  document.body.addEventListener("touchstart", function(e) {
	    if (e.target == canvas) {
	      e.preventDefault();
	    }
	  }, false);
	  document.body.addEventListener("touchend", function(e) {
	    if (e.target == canvas) {
	      e.preventDefault();
	    }
	  }, false);
	  document.body.addEventListener("touchmove", function(e) {
	    if (e.target == canvas) {
	      e.preventDefault();
	    }
	  }, false);

	  (function drawLoop() {
	    requestAnimFrame(drawLoop);
	    renderCanvas();
	  })();

	  function clearCanvas() {
	    canvas.width = canvas.width;
	  }

	  // Set up the UI
	  var sigText = document.getElementById("sig-dataUrl");
	  var sigImage = document.getElementById("sig-image");
	  var clearBtn = document.getElementById("sig-clearBtn");
	  var submitBtn = document.getElementById("sig-submitBtn");
	  clearBtn.addEventListener("click", function(e) {
	    clearCanvas();
	    sigText.innerHTML = "Data URL for your signature will go here!";
	    sigImage.setAttribute("src", "");
	  }, false);
	  submitBtn.addEventListener("click", function(e) {
	    var dataUrl = canvas.toDataURL();
	    sigText.innerHTML = dataUrl;
	    sigImage.setAttribute("src", dataUrl);

	    var testData = {
	    	    id: "123",
	    	    name: "123",
	    	    testTags: [{id: "1111", tag: "2222"}]
	    	};
	    
		$.ajax({
			url: "<c:url value='/sign/canvasInsert'/>"
			, type: "POST"
			, dataType: "json"
			, async: true
			, contentType: "application/json; charset=UTF-8;"
			, data: JSON.stringify({ "id":"1222541","dataUrl":dataUrl })
			, success: function(data){
				console.log(data);
				alert(data);
			}, error: function(){
				alert('error');
			}, complete: function(){
			}
		});
	    
	  }, false);

	})();
</script>



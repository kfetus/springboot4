<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>환영합니다.</title> 
<style type="text/css">
html, body { margin: 0; padding: 0; background-color: #f1f1f1; overflow-x: hidden; }
div {display: block;}
.top {position: relative;height: 90px; border-bottom: 1px solid #d1d8e4;background: #fff;}
.leftarea { position: relative; top: 0; left: 0; bottom: 0; padding: 0; width: 300px; height: 100%; background-color: #fff; border-right: 1px solid #ddd; cursor: default; overflow-y: auto; height: 100%;}
.content { position: absolute;left: 300px; width: 150px; height: 100%; padding-right: 30px;}
</style>
<script src="<c:url value='/js/jquery-3.4.1.min.js'/>"></script>
</head>
<% System.out.println("sjkadflk 나다"); %>

<div>
	<div class="top">
탑
	</div>
	<div class="leftarea">
레프트 
	</div>
	<div class="content">
		라이트
									
		<div>
		<strong>메인 컨텐츠</strong>
		<span>SPAN 태그</span>
		</div>
		
		<ul>
			<li>1. base <a href="http://localhost:8080/spring4/base.do">사인</a></li>
			<li id="liScrTest">2. script test</li>
			<li>3. </li>
		</ul>
	</div>
</div>

<body>
</body>
<script>
	var indexScript = (function($) {
		var mainScript = {
				consoleLog : function(){
					console.log('test ss');
				}
		}
		
		$(function() {
			$('#liScrTest').on('click', function(){
				mainScript.consoleLog();
				alert('333');
			})
		});
		return mainScript;
	})(jQuery);
</script>

</html>
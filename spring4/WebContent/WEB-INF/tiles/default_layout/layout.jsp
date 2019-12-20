<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><c:out value="${pageTitle}"></c:out></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>" />
<script src="<c:url value='/js/jquery-3.4.1.min.js'/>"></script>

</head>

<body>

<tiles:insertAttribute name="head" />

<tiles:insertAttribute name="content" />

<tiles:insertAttribute name="bottom" />

</body>
</html>

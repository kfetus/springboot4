<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>" />

<script src="<c:url value='/js/jquery-3.4.1.min.js'/>"></script>


<script type="text/javaScript" defer="defer">

	function fnSearch() {
//		document.searchForm.pageIndex.value = pageNo;
		document.searchForm.action = "<c:url value='/schedule/scheduleList.do'/>";
		document.searchForm.submit();
	}
	
	function fnInsert() {
		document.searchForm.action = "<c:url value='/schedule/scheduleInsertView.do'/>";
		document.searchForm.submit();
	}

	function fnDetailView(pk) {
		$("#pk").val(pk);
		document.searchForm.action = "<c:url value='/schedule/scheduleView.do'/>";
		document.searchForm.submit();
	}
	
</script>
</head>

<body>
	<header>
		<div>
			<div>
				<h1>Hi</h1>
				<p>List 샘플</p>
			</div>
		</div>
	</header>

	<section>
		<form id="searchForm" name="searchForm" method="post" action="">
			<input id="pk" name="pk" value='' type="hidden" />
			<div>
				<ul>
					<li>
						<label for="yyyymmdd" style="visibility: hidden; display: none;"></label> 
						<input id="yyyymmdd" name="yyyymmdd" value='<c:out value="${yyyymmdd}"></c:out>' type="TEXT" maxlength="8" /> 
					</li>
					<li>
						<span> 
						<a href="javascript:fnSearch();">검색</a>
						<a href="javascript:fnInsert();">등록</a>
						</span>
					</li>
				</ul>
			</div>
		</form>
	</section>

	<section>
		<div>
			<div>

				<table class="commtable">
					<colgroup>
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="*" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">일자</th>
							<th scope="col">요일숫자</th>
							<th scope="col">요일</th>
							<th scope="col">스케쥴</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list != null}">
								<c:forEach items="${list }" var="row">
									<tr>
										<td><a href="javascript:fnDetailView('${row.YYYYMMDD }');">${row.YYYYMMDD }</a></td>
										<td>${row.DT }</td>
										<td>${row.DAY }</td>
										<td>${row.SCH }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">조회된 결과가 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<section>
			<div id="jsGrid"></div>
	</section>

	<footer>
		<div>
			<div>
				<div>
					<h3>바닥글</h3>
					<p>샘플로 만드는 틀</p>
				</div>
			</div>
		</div>
		<div>
			<div>
				<div>
					<p>Copyright &copy; 2018</p>
				</div>
			</div>
		</div>
	</footer>

</body>
</html>

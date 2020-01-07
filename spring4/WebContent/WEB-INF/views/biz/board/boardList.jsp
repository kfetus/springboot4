<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form id="searchForm" name="searchForm" method="post" action="">
		<input type="hidden" id="seq" name="seq" value='' />
		<section>
			<div>
				<ul>
					<li>
						<input id="title" name="title" value='<c:out value="${title}"></c:out>' type="TEXT" maxlength="8" /> 
					</li>
					<li>
						<span> 
						<button type="button" id="searchBtn" class="btn">검색</button>
						</span>
					</li>
				</ul>
			</div>
		</section>
	
		<section>
			<div>
				<div>
	
					<table class="commtable">
						<colgroup>
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="*" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">순번</th>
								<th scope="col">카테고리</th>
								<th scope="col">제목</th>
								<th scope="col">등록자ID</th>
								<th scope="col">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list != null}">
									<c:forEach items="${list }" var="row">
										<tr>
											<td><a href="javascript:fnDetailView('${row.SEQ }');">${row.SEQ }</a></td>
											<td>${row.CATEGORY }</td>
											<td>${row.TITLE }</td>
											<td>${row.REG_ID }</td>
											<td>${row.REG_DT }</td>
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
	</form>

<script type="text/javaScript" defer="defer">

	$(function() {
	    console.log( "ready!" );
	    
	    $("#searchBtn").on('click',function(){

			$.ajax({
				url: "<c:url value='/board/boardSearch'/>"
				, type: "POST"
				, dataType: "json"
				, async: true
				, contentType: "application/json;charset=UTF-8;"
				, data: JSON.stringify({ "seq":$("#seq").val(), "title":$("#title").val() })
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

	
	function fnDetailView(seq){
		$("#searchForm").attr("action", "<c:url value='/board/boardSearch'/>");
		$("#seq").val(seq);
		$("#searchForm").submit();
	}
	
</script>



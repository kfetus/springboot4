<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
						<c:out value="${fn:length(list)}"></c:out> 건
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
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">순번</th>
								<th scope="col">카테고리</th>
								<th scope="col">제목</th>
								<th scope="col">등록자ID</th>
								<th scope="col">등록일</th>
								<th scope="col"><button type="button" id="addBoardBtn" class="btn" style="font-size:14px;">추가</button></th>
							</tr>
						</thead>
						<tbody id="boardlistBody">
							<c:choose>
								<c:when test="${list != null and fn:length(list) > 0}">
									<c:forEach items="${list }" var="row">
										<tr>
											<td><a href="javascript:fnDetailView('${row.SEQ }');">${row.SEQ }</a></td>
											<td>${row.CATEGORY }</td>
											<td>${row.TITLE }</td>
											<td>${row.REG_ID }</td>
											<td>${row.REG_DT }</td>
											<td><a href="javascript:fnEditBoard('${row.SEQ }');">수정</a></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr id="noResult">
										<td colspan="6">조회된 결과가 없습니다.</td>
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
	    
	    $("#addBoardBtn").on('click',function(){
	    	if($("#noResult").length){
	    		$("#noResult").remove();
	    	}
	    	var row = "<tr>"
		    		+ "<td>순번</td>"
	    			+ "<td><input type='text' placeholder='카테고리'></td>"
	    			+ "<td><input type='text' placeholder='제목'></td>"
	    			+ "<td><input type='text' placeholder='등록자ID'></td>"
	    			+ "<td>등록일</td>"
	    			+ "<td><a href='javascript:fnEditBoard('${row.SEQ }');'>수정</a></td>"
	    			+ "</tr>";
    		$('#boardlistBody').append(row)
	    });
	    
	});

	
	function fnDetailView(seq){
		$("#searchForm").attr("action", "<c:url value='/board/boardSearch'/>");
		$("#seq").val(seq);
		$("#searchForm").submit();
	}
	
	function fnEditBoard(seq) {
		alert(seq);
	}
	
</script>



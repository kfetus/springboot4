<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<form id="searchForm" name="searchForm" method="post" action="">
		<input type="hidden" id="seq" name="seq" value='' />
		<section>
			<div>
				<input id="title" name="title" value='<c:out value="${reqMap.title}"></c:out>' type="TEXT" maxlength="8" /> 
				<span> 
					<button type="button" id="searchBtn" class="btn">검색</button>
				</span>
				<c:out value="${fn:length(list)}"></c:out> 건
			</div>
		</section>
		<div class="div_blank"></div>
		<section>
			<div>
				<div>
	
					<table class="commtable">
						<colgroup>
							<col width="15%" />
							<col width="15%" />
							<col width="*" />
							<col width="15%" />
							<col width="15%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">순번</th>
								<th scope="col">카테고리</th>
								<th scope="col">제목</th>
								<th scope="col">등록자ID</th>
								<th scope="col">등록일</th>
								<th scope="col"><button type="button" id="addBoardBtn" class="btn" style="font-size:12px;">추가</button></th>
							</tr>
						</thead>
						<tbody id="boardlistBody">
							<c:choose>
								<c:when test="${list != null and fn:length(list) > 0}">
									<c:forEach items="${list }" var="row">
										<tr>
											<td><a href="javascript:fn_DetailView('${row.SEQ }');">${row.SEQ }</a></td>
											<td>${row.CATEGORY }</td>
											<td>${row.TITLE }</td>
											<td>${row.REG_ID }</td>
											<td>${row.REG_DT }</td>
											<td><a href="javascript:fn_DelBoard('${row.SEQ }');">삭제</a></td>
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
	    	fn_searchList();
	    });
	    
	    $("#addBoardBtn").on('click',function(){
	    	if($("#noResult").length){
	    		$("#noResult").remove();
	    	}
	    	
	    	var row = "<tr id='append_"+$('#boardlistBody tr').length+"'>"
		    		+ "<td>순번</td>"
	    			+ "<td><input type='text' placeholder='카테고리'></td>"
	    			+ "<td><input type='text' placeholder='제목'></td>"
	    			+ "<td><input type='text' placeholder='등록자ID'></td>"
	    			+ "<td>등록일</td>"
	    			+ "<td><a href='javascript:fn_EditBoard(\"append_"+$('#boardlistBody tr').length+"\");'>등록</a></td>"
	    			+ "</tr>";
    		$('#boardlistBody').append(row)
	    });
	    
	    gfn_setStorage('localStorage','temp1','111');
	    gfn_setStorage('sessionStorage','temp1','222');
	    
	});

	function fn_searchList(){
		console.log( gfn_getStorage('localStorage','temp') );
		console.log( gfn_getStorage('sessionStorage','temp') );

		$("#searchForm").attr("action", "<c:url value='/board/boardList'/>");
		$("#searchForm").submit();
	}
	
	function fn_DelBoard(seq) {
		$("#seq").val(seq);
		$("#searchForm").attr("action", "<c:url value='/board/boardDelete'/>");
		$("#searchForm").submit();
	}
	
	function fn_DetailView(seq){
		$("#seq").val(seq);
		$("#searchForm").attr("action", "<c:url value='/board/boardView'/>");
		$("#searchForm").submit();

	}
	
	function callbackTest(data){
		alert(data);
		
	}
	
	function fn_EditBoard(trId) {
		console.log(trId);
		var trElement = $('#'+trId); 
		
		jsonAjaxSync("<c:url value='/board/boardInsert'/>","POST",
				JSON.stringify({ "category":trElement.children()[1].firstElementChild.value, "title":trElement.children()[2].firstElementChild.value,
			 	"bodyText":'',"regId":trElement.children()[3].firstElementChild.value })
			 	,callbackTest);
		
/*		
 		$.ajax({
			url: "<c:url value='/board/boardInsert'/>"
			, type: "POST"
			, dataType: "json"
			, async: false
			, contentType: "application/json;charset=UTF-8;"
			, data: JSON.stringify({ "category":trElement.children()[1].firstElementChild.value, 
									 "title":trElement.children()[2].firstElementChild.value,
									 "bodyText":'',
									 "regId":trElement.children()[3].firstElementChild.value })
			, success: function(data){
				console.log(data);
				alert('등록되었습니다');
			}, error: function(){
				alert('error');
			}, complete: function(){
			}
		});
*/		
 		fn_searchList();
	}
	
</script>



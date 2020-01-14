<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<form id="dataForm" name="dataForm" method="post" action="">
		<section>
			<div>
				<span> 
					<button type="button" id="updateBtn" class="btn">수정</button>
				</span>
			</div>
		</section>
		<div class="div_blank"></div>
		<section>
			<div>
				<div>
					<input type="hidden" id="seq" name="seq" value="<c:out value="${detailData.SEQ}" />" />
					<table class="commtable">
						<colgroup>
							<col width="15%" />
							<col width="35%" />
							<col width="15%" />
							<col width="35%" />
						</colgroup>
						<tbody id="boardlistBody">
							<tr>
								<td>카테고리</td>
								<td><input id="category" name= "category" type='text' value="<c:out value="${detailData.CATEGORY}" />"></td>
								<td>제목</td>
								<td><input id="title" name= "title" type='text' value="<c:out value="${detailData.TITLE}" />"></td>
							</tr>
							<tr>
								<td>내용</td>
								<td colspan="3">
									<textarea id="bodyText" name= "bodyText" cols="50" rows="10"><c:out value="${detailData.BODY_TEXT}" /></textarea>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</form>

<script type="text/javaScript" defer="defer">

	$(function() {
	    console.log( "ready!" );
	    
	    $("#updateBtn").on('click',function(){
			$("#dataForm").attr("action", "<c:url value='/board/boardUpdate'/>");
			$("#dataForm").submit();

	    });
	    
	});
	
</script>



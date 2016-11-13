<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>게시판 리스트</title>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<div align="center">
		<h3>목록보기</h3>
		<table class="button_table">
			<tr>
				<td>
					<a href="insert.do">
						<img alt="write button" src="img/btn_write.gif">
					</a>
				</td>
			</tr>
		</table>
		<table id="content_table">
			<tr>
				<th width="10%">번호</th>
				<th width="45%">제목</th>
				<th width="15%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>				
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td width="10%">${vo.no }</td>
				<td width="45%" id="left_td">
					<a href="content.do?no=${vo.no }&page=${curPage}">
						${vo.subject }
					</a>
					<fmt:formatDate var="regdate" value="${vo.regdate}" pattern="yyyy-MM-dd"/>
					<c:if test="${regdate==today }">
						<sup><img src="img/icon_new (2).gif"></sup>
					</c:if>					
				</td>
				<td width="15%">${vo.name }</td>
				<td width="20%">${regdate }</td>
				<td width="10%">${vo.hit }</td>		
			</tr>
		</c:forEach>
		</table>
		<table class="button_table">
			<tr>
				<td id="right_td">
			 	<a href="list.do?page=1">
			 		<img src="img/begin.gif">
			 	</a>
				<a href="list.do?page=${curPage>1 ? curPage-1 : 1 }">
					<img src="img/prev.gif">				 		
			 	</a>
				<c:forEach var="i" begin="1" end="${totalPage }">
				 	[
					<c:if test="${curPage==i }">
						<font color="red">
							${i }
						</font>				 	
				 	</c:if>
				 	<c:if test="${curPage!=i }">
				 		<a href="list.do?page=${i }">
				 			${i }
				 		</a>
				 	</c:if>	
				 	]
				</c:forEach>
				<a href="list.do?page=${curPage<totalPage ? curPage+1 : totalPage }">
					<img src="img/next.gif">				 		
			 	</a>
				<a href="list.do?page=${totalPage }">
			 		<img src="img/end.gif">
			 	</a>
			 	&nbsp;
			 	${curPage }page / ${totalPage }page 
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
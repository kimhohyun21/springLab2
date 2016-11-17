<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Movie List</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div align="center" class="article">
		<h3><a href="list.do">��ȭ ���</a></h3>
		<div class="movieList">
			<c:forEach var="vo" items="${list }">
			<div class="movie">
				<table class="movieTable">
					<tr>
						<td colspan="2">
							<img src="${vo.poster }" width="120px" height="170px">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div style="width:135px; text-overflow:ellipsis; overflow:hidden;">
								<nobr>${vo.title }</nobr>
							</div>							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							${vo.grade }
						</td>
					</tr>
					<tr>
						<td>
							����
						</td>
						<td>
							������	
						</td>
					</tr>	
					<tr>
						<td>
							${vo.rank }��
						</td>
						<td>
							${vo.star }��	
						</td>
					</tr>				
				</table>	
			</div>
			</c:forEach>
		</div>
		<div class="btnArea">
			<span><a href="list.do?page=1">&lt;&lt;ó��</a></span>
			<c:if test="${fromPage<=block }">
				<span>
					<a href="list.do?page=${curPage>1 ? curPage-1 : 1 }">
						&lt;&lt;����
					</a>
				</span>
			</c:if>
			<c:if test="${fromPage>block }">
				<span>
					<a href="list.do?page=${fromPage-block }">
						&lt;&lt;����
					</a>
				</span>
			</c:if>
			<c:forEach var="i" begin="${fromPage }" end="${toPage>totalPage ? totalPage : toPage }">
				<c:if test="${curPage==i }">
					<span><a href="list.do?page=${i }" style="color:red">[${i }]</a></span>
				</c:if>
				<c:if test="${curPage!=i }">
					<span><a href="list.do?page=${i }">[${i }]</a></span>
				</c:if>
			</c:forEach>		
			<c:if test="${toPage<totalPage }">
				<span>
					<a href="list.do?page=${toPage+block }">
						���� &gt;&gt;
					</a>
				</span>
			</c:if>
			<c:if test="${toPage>=totalPage }">
				<span>
					<a href="list.do?page=${curPage<totalPage ? curPage+1 : totalPage }">
						���� &gt;&gt;
					</a>
				</span>
			</c:if>			
			<span><a href="list.do?page=${totalPage }">������ &gt;&gt;</a></span>
		</div>					
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${bCheck==false }">
		<script>
			alert('비밀번호가 잘 못되었습니다.');
			history.back();
		</script>
	</c:when>
	<c:when test="${bCheck==true }">
		<script>
			alert('수정 되었습니다.');
			location.href="content.do?no=${no }&page=${page }"
		</script>
	</c:when>
</c:choose>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${bCheck==false }">
		<script>
			alert('��й�ȣ�� �� ���Ǿ����ϴ�.');
			history.back();
		</script>
	</c:when>
	<c:when test="${bCheck==true }">
		<script>
			alert('���� �Ǿ����ϴ�.');
			location.href="content.do?no=${no }&page=${page }"
		</script>
	</c:when>
</c:choose>
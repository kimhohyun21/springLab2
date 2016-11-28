<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>����� ��� ����</title>
	<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- �ΰ����� �׸� -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<!-- �������� �ּ�ȭ�� �ֽ� �ڹٽ�ũ��Ʈ -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
</head>
<body>
	<div class="container">
		<h2 class="text-center">����� ��� ����</h2>
		<div>
			<form action="insertUser.do" method="post">
				<table class="table table-bordered table table-hover">
					<tr>
						<td>���̵� : </td>
						<td><input type="text" name="userId" ></td>
					</tr>
					<tr>
						<td>�̸� : </td>
						<td><input type="text" name="name" ></td>
					</tr>
					<tr>
						<td>���� : </td>
						<td>
							<c:forEach var="genderName" items="map.genderList">
								<input type="radio" name="gender" value="${genderName }">
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td>������ : </td>
						<td>
							<select name="city">
								<c:forEach var="cityName" items="map.cityList">
									<option value="${cityName }">${cityName }</option>
								</c:forEach>								
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="���">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="���">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
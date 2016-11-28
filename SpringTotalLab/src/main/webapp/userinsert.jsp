<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사용자 등록 정보</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 등록 정보</h2>
		<div>
			<form action="insertUser.do" method="post">
				<table class="table table-bordered table table-hover">
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="userid"></td>
					</tr>
					
					<tr>
						<td>이름 : </td>
						<td><input type="text" name="name"></td>
					</tr>
					
					<tr>
						<td>성별 : </td>
						<td><c:forEach var="genderName" items="${map.genderList }">
								<input type="radio" name="gender" value="${genderName }">${genderName }
							</c:forEach>
						</td>
					</tr>
					
					<tr>
						<td>거주지 : </td>
						<td>
							<select name="city">
								<c:forEach var="cityName" items="${map.cityList }">
									<option value="${cityName }">${cityName }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" class="text-center">
						<input type="submit" value="등록">
						</td>
					</tr>
					
					<tr>
						<td colspan="2" class="text-center">
							<a href="getUserList.do">사용자 목록보기</a>
						</td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>
</body>
</html>
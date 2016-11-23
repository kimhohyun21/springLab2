<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Validation</title>
</head>
<body>
	<div align="center">
		<h3>��ȿ�� üũ</h3>
		<form:form method="post" action="validationForm_ok.do" commandName="validationForm1">
			<table style="border: 1px solid black; border-collapse: collapse; width: 250px">
				<tr style="border: 1px solid black;">
					<th width="30%">�̸�</th>
					<td width="70%">
						<input type="text" name="name" size="20">
						<font color="red"><form:errors path="name"/></font>
					</td>
				</tr>
				<tr style="border: 1px solid black;">
					<th width="30%">����</th>
					<td width="70%">
						<input type="text" name="age" size="20">
						<font color="red"><form:errors path="age"/></font>
					</td>
				</tr>
				<tr style="border: 1px solid black;">
					<th width="30%">��й�ȣ</th>
					<td width="70%">
						<input type="password" name="pwd" size="20">
						<font color="red"><form:errors path="pwd"/></font>
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="����">
			</div>
		</form:form>
	</div>
</body>
</html>
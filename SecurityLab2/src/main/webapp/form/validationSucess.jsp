<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Sucess</title>
</head>
<body>
	<div align="center">
		<h3>��ȿ�� ���</h3>
		<table style="border: 1px solid black; border-collapse: collapse; width: 500px">
				<tr style="border: 1px solid black;">
					<th width="30%">�̸�</th>
					<td width="70%">
						${vo.name }
					</td>
				</tr>
				<tr style="border: 1px solid black;">
					<th width="30%">����</th>
					<td width="70%">
						${vo.age }
					</td>
				</tr>
				<tr style="border: 1px solid black;">
					<th width="30%">��й�ȣ</th>
					<td width="70%">
						${vo.pwd }
					</td>
				</tr>
			</table>
	</div>
</body>
</html>
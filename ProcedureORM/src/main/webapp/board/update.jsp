<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>글쓰기</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		function enter(){
			if(event.keyCode==13){
				send();	
			}
		};
		
		function send(){			
			//계층구조 : window ==> document ==> form ==> input
			var f=document.frm;
			if(f.name.value==""){
				alert('이름을 입력해주세요.');
				f.name.focus();
				return;
			}
			if(f.subject.value==""){
				alert('제목을 입력해주세요.');
				f.subject.focus();
				return;
			}
			if(f.content.value==""){
				alert('내용을 입력해주세요.');
				f.content.focus();
				return;
			}
			if(f.pwd.value==""){
				alert('비밀번호를 입력해주세요.');
				f.pwd.focus();
				return;
			}
			f.submit();
		};
	</script>
</head>
<body>
	<div align="center">
		<h3>글쓰기</h3>
		<form action="update_ok.do?page=${page }" method="post" name="frm" id="frm">
			<table id="insert_table">
				<tr>
					<th width="20%">이름</th>
					<td>
						<input type="text" size="15" name="name" id="name" value="${vo.name }">
						<input type="hidden" name="no" value="${vo.no }">
					</td>
				</tr>
				<tr>
					<th width="20%">제목</th>
					<td>
						<input type="text" size="50" name="subject" id="subject"  value="${vo.subject }">
					</td>
				</tr>
				<tr>
					<th width="20%">내용</th>
					<td>
						<textArea cols="52" rows="10" name="content" id="content">${vo.content }</textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">비밀번호</th>
					<td>
						<input type="password" size="15" name="pwd" id="pwd">
					</td>
				</tr>							
			</table>
			<table id="button_table">
				<tr>
					<td>
						<input type="button" value="글쓰기" onclick="send()">
						<input type="reset" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>	
			</table>
		</form>
	</div>
</body>
</html>
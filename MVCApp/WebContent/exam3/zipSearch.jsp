<%@ page  contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
<script >
	function fnDongCheck(){
		if(document.f.dong.value == ""){
			alert("�ݵ�� ���̸��� �Է��ϼž� �˴ϴ�");
			document.f.dong.focus();
		}
		document.f.submit();
	}
</script>

</head>
<body>
<h2>�����ȣ ã��</h2>
<form method="post" action="/MVCApp/reg.action" name="f">
<input type="hidden" name="command" value="ZIPSEARCH"/>
	<table>
		<tr>
			<td>���̸� �Է� : <input type="text" name="dong"/>
				&nbsp;&nbsp;<input type="button" value="�˻�" onclick="fnDongCheck()"/></td>
				
		</tr>
	</table>
</form>
</body>
</html>
<%@page import="mvc.exam2.BookDto"%>
<%@page import="java.util.Vector"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
</head>
<body>
<h1>���� ���� �ֹ� ������</h1>
<b>�ֹ��� ����</b>
<table border="1">
	<tr>
		<th>���� ����</th><th>�۰�</th><th>����</th><th>����</th>
	</tr>
	<%
	int result=0;
	Vector bookList = (Vector)session.getAttribute("cart");
	for(int i=0;i<bookList.size();i++){
		BookDto dto = (BookDto)bookList.get(i);
		result += dto.getPrice() *dto.getQuantity();
	%>
	<tr>
			
			<td><%=dto.getTitle() %></td>
			<td><%=dto.getAuthor() %></td>
			<td><%=dto.getPrice()%></td>
			<td><%=dto.getQuantity()%></td>
			</tr>
			<%
	}
			%>
</table>
<hr />
<b>��ü ���� �׼� : <%=result %></b>
</body>
</html>
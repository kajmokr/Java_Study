<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��������</h1>
	����ID: <%=session.getId() %><br>
	���� �����ð�: <%=session.getCreationTime() %><br>
	���� �ֱ����ٽð�: <%=session.getLastAccessedTime() %> <br>
	���� Timeout �ð� : <%=session.getMaxInactiveInterval() %> <br>
	���� isNew : <%=session.isNew() %> <br>
</body>
</html>
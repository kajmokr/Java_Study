<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<body>
	<!-- <% %> �ȿ��� �ڹ� �ڵ带 ������� �ۼ��Ҽ� �ִ�. -->
	<!-- ����Ʈ -->
	<%-- �ڹ� --%>
	   <%@ include file="sub.jsp" %> <!-- �ߺ��Ǵ� �ڵ� ������ ��Ƴ��� -->
		<%
			String str1 = "Hello str1";
			Date myDate = new Date();
			out.println(myDate.toString());
			String value = request.getParameter("name");
		%>
	   <jsp:include page="title.jsp">
	   		<jsp:param name="myName" value="<%=value%>" />
	   </jsp:include><!-- jsp:include page�� page�а� �ٽ� ���ƿ´�.  -->
		�ȳ��ϼ���?<%=value%>��<br>
		<%-- �ڹ� --%>
		<%! String str2 = "Hello str2"; %>
		str1 ���� ���� : <%=str1%> <br>
		str2 ���� ���� : <%=str2%>
	</body>
</html>
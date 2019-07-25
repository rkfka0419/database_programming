<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*, company.*"%>
<%!
DBAgent dba = new DBAgent();

String inId;
int id = -1;
String password = null;
ResultSet rs;
int loginCheckNum =0;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("euc-kr");%>
	<%dba.getConnection(); %>
	<%id = Integer.parseInt(request.getParameter("id")); %>
	<%password = request.getParameter("pw"); %>
	<%out.print(id+" "+password); %>
	<%rs = dba.CheckLogin(id, password);%>
	<%loginCheckNum = dba.login(rs); %>
	<%if (loginCheckNum==1){
		request.setAttribute("RS", rs);
		request.setAttribute("ID", id);
		request.setAttribute("PASSWORD", password);
		request.getRequestDispatcher("Admin_Menu.jsp").forward(request, response);}
	else if (loginCheckNum==2) request.getRequestDispatcher("Admin_menu.jsp").forward(request, response);
	else response.sendRedirect("Admin_menu.jsp");%>
	
	
</body>
</html>
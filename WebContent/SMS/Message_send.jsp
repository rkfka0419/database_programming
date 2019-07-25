<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*, company.*,java.util.Date
    ,java.text.SimpleDateFormat"%>
    <%response.setContentType("text/html; charset=euc-kr");%>
<% request.setCharacterEncoding("euc-kr");%>
 <%!
 int msgCheckNum = -1;
 DBAgent dba = new DBAgent();
 String receiver;
 String title;
 String body;
 String sender;
 ResultSet rs;
 Date dt = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); 
	String sendtime = sdf.format(dt).toString();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%  request.setCharacterEncoding("EUC-KR");%>
<%dba.getConnection(); %>
<%receiver = request.getParameter("receiver");
  title = request.getParameter("title");
  body = request.getParameter("body");%>
<%rs = dba.executeSerachWorkerNameByID(000);
	rs.next();
  sender = rs.getString(2);%>
 <%out.print(sender); %>
<%msgCheckNum = dba.sendMessage(title, body, sender, receiver, sendtime);
if(msgCheckNum >0) out.print("전송 성공");
else out.print("전송 실패"); out.print(receiver); out.print(title);%>  
</body>
</html>
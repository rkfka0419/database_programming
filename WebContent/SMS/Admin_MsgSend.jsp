<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%response.setContentType("text/html; charset=euc-kr");%>
<% request.setCharacterEncoding("euc-kr");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.css" type="text/css"> 
<title>Insert title here</title>
</head>
<body>
<%  request.setCharacterEncoding("EUC-KR");%>
<%response.setCharacterEncoding("EUC-KR"); %>
<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="text-right"><i><b>메시지 송신</b></i></h1>
        </div>
        <div class="col-md-6">
          <h1 class="text-right">관리자 모드</h1>
        </div>
      </div>
    </div>
  </div>
  <form class="" action = "Message_send.jsp">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="받는 사원" name ="receiver"> </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="제목" name ="title"> </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          
            <div class="form-group">
              <input type="text" class="form-control" placeholder="내용" name="body"> </div>
            <button type="submit" class="btn btn-block btn-primary">전송</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
  <script src="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js"></script>

</body>
</html>
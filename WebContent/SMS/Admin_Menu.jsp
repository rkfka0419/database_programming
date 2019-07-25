<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*, company.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.github.io/templates/blank/theme.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%  request.setCharacterEncoding("euc-kr");%>

<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="text-right" contenteditable="true"><b><i>HOME</i></b></h1>
        </div>
        <div class="col-md-6">
          <h1 class="text-right">관리자 모드</h1>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="lead text-center bg-success"><b>메시지 조작</b></p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <a href="Admin_Receive.jsp" class="btn btn-outline-primary btn-block btn-lg">메시지 수신</a>
        </div>
        <div class="col-md-6">
          <a href="Admin_MsgSend.jsp" class="btn btn-outline-primary btn-block btn-lg">메시지 송신
            <br>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="lead text-center bg-warning">데이터 조작</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <a href="Admin_InsEmployee.jsp" class="btn btn-outline-primary btn-block btn-lg my-4">사원 등록</a>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <a href="Admin_DelEmployee.jsp" class="btn btn-outline-primary btn-block">사원 삭제</a>
        </div>
        <div class="col-md-6">
          <a href="Admin_ModDep.jsp" class="btn btn-outline-primary btn-block">부서 수정</a>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
  <script src="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js"></script>

</body>
</html>
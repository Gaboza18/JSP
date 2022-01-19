<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인 페이지</title>
</head>
<body>
   <h2>아이디 중복확인</h2>
   <form method="get" action="idCheck.do">
   <label>아이디</label>
   <input type="text" name="userid" id="userid" value="${userid}">
   <input type="submit" value="중복체크"><br><br>
   <c:choose>
      <c:when test="${result == 1}">
      ${userid}는 이미 사용중인 아이디 입니다.
      </c:when>
      <c:when test="${result == -1}">
      ${userid}는 사용 가능한 아이디 입니다.&nbsp;
      <input type="button" value="사용" onclick="idok()">
      </c:when>
   </c:choose>
   </form>
  <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보 관리</title>
</head>
<style>
label {
   display: inline-block;
   width: 75px;
}
</style>
<body>
<h2>상품 정보 입력</h2>

<form method="post" action="04_addItemResult.jsp">
   <label>상품명</label>
   <input type="text" name="itemname" size="20"><br>
   <label>가 격</label>
   <input type="text" name="price" size="20"><br><br>
   <label>설 명</label>
   <textarea cols="50" rows="10" name="description" style="vertical-align:middle" ></textarea><br><br>

   <div id="buttons">
      <input type="submit" value="전송">
      <input type="reset" value="취소">
   </div>

</form>
</html>
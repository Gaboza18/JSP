<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어로 두 수의 합 구하기</title>
<style>
	#container{
		margin: 0 auto;
		width: 600px;
		border: 1px solid #000;
		padding: 20px;
	}
	label{
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
  <div id="container">
  
	 <!-- <form method="post" action="06_addtion.jsp">  --> 
	  <form method="post" action="07_addtion.jsp"> 
	
		<label for="num1">숫자 1: </label>
		<input type="text" name="num1" id="num1">
		<br>
		<label for="num2">숫자 2: </label>
		<input type="text" name="num2" id="num2">
		<br>
		<input type="submit" value="전송">
		
	</form>
</div>		
</body>
</html>
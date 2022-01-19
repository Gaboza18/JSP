<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:foreach end,begin,step 연습</title>
<style>
	.result th{
		width: 200px;
	}
	
	.result td{
		text-align:center;
	}
</style>
</head>
<body>
		<c:forEach var="cnt" begin="1" end="10" varStatus="status">
			${cnt}
			<c:if test="${not status.last}">,</c:if>
		</c:forEach>
		
		<br><br>
		
		<table border="1" class="result">
			<!-- 각 열의 제목 -->
			<tr>
				<th>index</th><th>count</th><th>cnt</th>
			</tr>
			
			<c:forEach var="cnt" begin="7" end="10" step="1" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${status.count}</td>
					<td>${cnt}</td>
				</tr>	
			</c:forEach>
		</table>
		
		<br><br>
		
		<table border="1" class="result">
			<tr>
				<th>index</th><th>count</th><th>cnt</th>
			</tr>
			
			<c:forEach var="cnt" begin="1" end="10" step="2" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${status.count}</td>
					<td>${cnt}</td>
				</tr>	
			</c:forEach>
		</table>
			
		

		

</body>
</html>
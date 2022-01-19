<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style> 
	label { 
		width:160px;
		display: inline-block;
		float: left;
	}
	#button{
		text-align: center;
	}
</style> 
</head>
<body>
<form name="frm" id="reg_frm" method="post" action="JoinServlet"> 

   <label for="name"> 이름 </label><span style="color:red;"> * </span> <!-- span 태그: inline 일때 사용-->
   <input type="text" id="name" name="name" > <br>
  
   <label>주민등록번호  </label><span style="color:red;"> * </span>
   <input type="text" name="jumin_1" id="jumin_1"> - <!-- 주민번호 앞자리 입력 -->
   <input type="text" name="jumin_2" id="jumin_2"> <br> <!-- 주민번호 뒷자리 입력 -->
   
   <label for="id"> 아이디  </label><span style="color:red;"> * </span>
   <input type="text" id="id" name="id"><br>
    
    <label for="pwd"> 비밀번호 </label><span style="color:red;"> * </span> 
    <input type="password" id="pwd" name="pwd"><br>
    
    <label for="pwd_re"> 비밀번호 확인  </label><span style="color:red;"> * </span>
    <input type="password" id="pwd_re" name="pwd_re"><br>
    
    <label for="email">이메일 </label> &nbsp;
    <input type="text" name="email"> @ <!-- 이메일 앞부분 -->
    <input type="text" name="email_dns" value=""> <!-- 이메일 뒤 DNS 부분 -->
    <select name="emailaddr">
        <option value="">직접입력</option>
        <option value="daum.net">daum.net</option>
        <option value="empal.com">empal.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="hanmail.net">hanmail.net</option>
        <option value="msn.com">msn.com</option>
        <option value="naver.com">naver.com</option>
        <option value="nate.com">nate.com</option>                
    </select><br>    
    
    <label for="zip">우편번호</label> &nbsp;
    <input type="text" id="zip" name="zip"><br>
           
    <label for="addr1">주소</label> &nbsp;
    <input type="text" id="addr1" name="addr1" >
    <input type="text" name="addr2"><br>
    
    <label for="phone">핸드폰번호</label>  &nbsp;
    <input type="tel" id="phone" name="phone"><br>
    
    <label for="job">직업</label>  &nbsp;
    <select id="job" name="job" size="3">  
       <option value="학생">학생</option> 
       <option value="컴퓨터/인터넷">컴퓨터/인터넷</option> 
       <option value="언론">언론</option> 
       <option value="공무원">공무원</option> 
       <option value="군인">군인</option> 
       <option value="서비스업">서비스업</option> 
       <option value="교육">교육</option> 
    </select><br>
    
    <label for="chk_mail">메일/SMS 정보 수신</label>  &nbsp;
    <input type="radio" id="chk_mail" name="chk_mail" value="yes" checked> 수신 
    <input type="radio" id="chk_mail" name="chk_mail" value="no"> 수신거부<br>

    <label for="interest">관심분야</label>  &nbsp;
      <input type="checkbox" id="interest" name="interest" value="생두"> 생두         
      <input type="checkbox" id="interest" name="interest" value="원두"> 원두         
      <input type="checkbox" id="interest" name="interest" value="로스팅"> 로스팅         
      <input type="checkbox" id="interest" name="interest" value="핸드드립"> 핸드드립         
      <input type="checkbox" id="interest" name="interest" value="에스프레소"> 에스프레소         
      <input type="checkbox" id="interest" name="interest" value="창업"> 창업<br><br>
    
 <div id="button">
    <input type="submit" value="회원가입" onclick="return check_ok()"> <!-- 회원가입 목록중 조건을 받는 JS 호출 -->
    <input type="reset" value="취소">
 </div>
</form>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script> <!-- JS 사용하기 위해 선언 -->
<script type="text/javascript" src="js/join.js"></script> <!-- 저장된 JS 파일 호출하기 위한 선언 -->
</body>
</html>
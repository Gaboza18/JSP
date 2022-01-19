
/*
		<< 로그인 화면>> 
		아이디, 비밀번호 미입력시 체크 메소드
*/

function login_check() {

	var $userid = $("#userid");
	var $userpwd = $("#userpwd");

	if ($userid.val() == "") { // 빈문자열 일때
		alert("아이디를 입력하세요");
		$userid.focus(); // 잘못 입력한 부분 커서 깜빡임
		return false;
	}

	if ($userpwd.val() == "") { // 빈문자열 일때
		alert("암호를 입력하세요");
		$userpwd.focus(); // 잘못 입력한 부분 커서 깜빡임
		return false;
	}

	return true;
}

/*
	<< 회원가입 화면 >> 
	  회원가입 에서 입력한 사용자 ID가 이미 사용중인지 확인 (중복체크)
*/
function idCheck() {

	var $userid = $("#userid");

	if ($userid.val() == "") { // 회원가입 할 아이디를 입력하지 않았을때
		alert("사용자 아이디를 입력해 주세요");
		$userid.focus();
		return false;
	}

	// idCheck 수행을 위한 새로운 윈도우 오픈
	var url = "idCheck.do?userid=" + $userid.val(); // idCheckServlet 으로 전송하는 URL
	window.open(url, "_blank_", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300");
}

/*
	조회한 아이디를 사용버튼을 눌러 회원가입창에 아이디 복사	
*/

function idok() {

	// 팝업창을 오픈한 부모창을 지정하여 아이디값을 전달

	var confirmId = $("#userid").val(); // 팝업창의 사용자ID(사용가능 ID값)

	// 부모의 창의 userid에 값을 설정함
	$("#userid", opener.document).val(confirmId);

	// 부모창의 reid에 값을 설정함
	$("#reid", opener.document).val(confirmId);

	self.close();
}



/* 필수 입력항목 체크 하는 메소드*/

function joinCheck() {

	var $name = $("#name");
	var $userid = $("#userid");
	var $pwd = $("#pwd");
	var $pwd_check = $("#pwd_check");
	var $reid = $("#reid");

	if ($name.val() == "") {
		alert("이름을 입력하세요");
		$name.focus();
		return false;
	}

	if ($userid.val() == "") {
		alert("아이디를 입력하세요");
		$userid.focus();
		return false;
	}

	if ($userid.val().length < 4) {
		alert("사용자 아이디는 4글자 이상이여야 합니다");
		$userid.focus();
		return false;
	}

	if ($pwd.val() == "") {
		alert("암호를 입력하세요");
		$pwd.focus();
		return false;
	}

	if ($pwd_check.val() == "") {
		alert("암호확인을 하십시오");
		$pwd_check.focus();
		return false;
	}

	if ($pwd.val() != $pwd_check.val()) {
		alert("암호가 일치하지 않습니다");
		$pwd.focus();
		return false;
	}

	if ($reid.val() == "") {
		alert("아이디 중복체크를 하지 않았습니다");
		$reid.focus();
		return false;
	}
	return true;
}

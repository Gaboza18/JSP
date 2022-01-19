/* 필수입력 항목에 대한 JS */

function check_ok() {

	var $name = $("#name");
	var $jumin1 = $("#jumin_1");
	var $jumin2 = $("#jumin_2");
	var $id = $("#id");
	var $pwd = $("#pwd");
	var $pwd_re = $("#pwd_re");

	if ($name.val() == "") { // 빈문자열 일때
		alert("이름을 입력하세요");
		$name.focus(); // 잘못 입력한 부분 커서 깜빡임
		return false;
	}

	if ($jumin1.val().length != 6) { // 주민번호 앞자리가 6자리가 아닐때
		alert("주민번호 앞자리는 6자리 입니다");
		$jumin1.focus();
		return false;
	}

	if ($jumin2.val().length != 7) { // 주민번호 앞자리가 7자리가 아닐때
		alert("주민번호 뒷자리는 7자리 입니다");
		$jumin2.focus();
		return false;
	}

	if ($id.val() == "") { // 아이디를 입력하지 않을때
		alert("아이디를 입력하세요");
		$id.focus();
		return false;
	}

	if ($pwd.val() == "") { // 비밀번호를 입력하지 않을때
		alert("비밀번호를 입력하세요");
		$pwd.focus();
		return false;
	}

	// 비밀번호와 비밀번호 확인 같은지 확인
	if ($pwd.val() != $pwd_re.val()) {
		alert("비밀번호가 일치하지 않습니다");
		$pwd_re.focus();
		return false;
	}

	return true;
}
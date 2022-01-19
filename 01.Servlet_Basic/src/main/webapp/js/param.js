/**
 *  입력한 값을 조건을 확인해 사용자에게 메세지를 주는 JQuery
 */

function check() {

	var $id = $("#id"); // '아이디'' 아이디값 변수
	var $age = $("#age"); // '나이' 아이디값 변수

	if ($id.val() == "") { // 아이디 값이 공백일때
		alert("아이디를 입력해 주세요");
		$id.focus(); // 입력이 잘못된 부분에 커서를 깜빡인다
		return false;
	}

	else if ($age.val() == "") { // 나이 값이 공백일때
		alert("나이를 입력해 주세요");
		$age.focus();
		return false;
	}

	else if (isNaN($age.val())) { // 나이 입력칸에 숫자가 아닌 값을 넣었을떄
		alert("숫자를 입력해 주세요");
		$age.focus();
		return false;
	}

	return true; // 정상적인 값이 들어올떄
}
/**
 * 	 게시글 입력 항목 확인
 */

function boardCheck() {

	var $name = $("#name");
	var $pass = $("#pass");
	var $title = $("#title");

	if ($name.val() == "") {
		alert("작성자를 입력하세요!");
		$name.focus();
		return false;
	}

	if ($pass.val() == "") {
		alert("비밀번호를 입력하세요!");
		$pass.focus();
		return false;
	}

	if ($title.val() == "") {
		alert("제목을 입력하세요!");
		$title.focus();
		return false;
	}
	return true;
}

function open_win(url, name) {

	// url = BoardServlet?command=board_check_pass_form&num=${board.num}
	// name = 'update' 또는 'delete'

	window.open(url, name, "width=500, height=250");

}
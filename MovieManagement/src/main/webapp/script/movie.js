/**
 * 
 */
function movieCheck() {
	var $title = $("#title");
	var $price = $("#price");
	var $director = $("#director");
	var $actor = $("#actor");
	var $synopsis = $("#synopsis");
	var $poster = $("#poster");

	if ($title.val().length == 0) {
		alert("제목을 입력해주세요.");
		$title.focus();
		return false;
	}

	if ($price.val().length == 0) {
		alert("가격을 입력해 주세요.");
		$price.focus();
		return false;
	}

	if (isNaN($price.val())) {
		alert("가격은 숫자를 입력해 주세요.")
		$price.focus();
		return false;
	}

	/*
	if ($image.val() == "") {
	   alert("상품 이미지를 선택해주세요!");
	   $image.focus();
	   return false;
	}
	*/

	if ($director.val().length == 0) {
		alert("감독을 입력해 주세요.");
		$director.focus();
		return false;
	}

	if ($actor.val().length == 0) {
		alert("배우를 입력해 주세요.");
		$actor.focus();
		return false;
	}

	if ($synopsis.val().length == 0) {
		alert("줄거리를 입력해 주세요.");
		$synopsis.focus();
		return false;
	}

	if ($poster.val().length == 0) {
		alert("사진을 입력해 주세요.");
		$poster.focus();
		return false;
	}

	return true;
}
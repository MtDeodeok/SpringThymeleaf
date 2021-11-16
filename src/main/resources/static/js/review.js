function btnCommentUpdate(data) {
	var check = $("[name='commentUpdate']").val();
	var update = document.getElementById(data.getAttribute('id'))
		.getAttribute('id');
	var updateok = Number(update) + 10;
	if (check == "수정") {
		document.getElementById(update + "").style.display = "none";
		document.getElementById(updateok + "").style.display = "block";
		var comment = "#comment" + update;
		var id = "#id" + update;
		var memberid = "#memberid" + update
		$(comment).attr('readonly', false);
		$(comment).attr("name", "comment");
		$(id).attr("name", "id");
		$(memberid).attr("name", "memberid");
	}
}
function btnCommentUpdateOk(data) {
	var check = $("[name='commentUpdateOk']").val();
	var updateok = document.getElementById(data.getAttribute('id'))
		.getAttribute('id');
	var update = Number(updateok) - 10;
	if (check == "확인") {
		document.getElementById(updateok + "").style.display = "none";
		document.getElementById(update + "").style.display = "block";
		var comment = "#comment" + update;
		$(comment).attr("readonly", true);
		$("#commentForm").attr("action", "updateComment");
		$("#commentForm").submit();
	}
}

function btnCommentDelete(data) {
	console.log(data);
	var check = document.getElementById(data.getAttribute('id'))
		.getAttribute('id');
	var id = "#id" + check;
	$(id).attr("name", "id");
	$("#commentForm").attr("action", "deleteComment");
	$("#commentForm").submit();
}
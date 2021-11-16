function btn1(data){
	var check = $("[name='update']").val();
	if(check=="수정"){
		$("#detailForm").attr("action", "updateContents");
		$("#detailForm").submit();
	}
}
function btn2(data){
	var check = $("[name='delete']").val();
	if(check2=="삭제") {
		$("#detailForm").attr("action", "deleteContents");
		$("#detailForm").submit();
	}
}
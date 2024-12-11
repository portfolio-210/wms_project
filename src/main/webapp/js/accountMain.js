function accountModify(aidx){
	location.href='./accountModify.do?aidx='+aidx;
}


function accountDelete(aidx){
	if (confirm("거래처를 삭제하시겠습니까?")) {
	    location.href='./accountDelete.do?aidx='+aidx;
	} else {
	  return false;
	}
	
}

function page_go(n){
   location.href='./accountMain.do?pageno='+n;
}
	  
	  
function sh(p){
	if(p==1){
		if(frm.search.value==""){
			alert("거래처명을 입력해주세요.");
			frm.search.focus();
			return false;
		}
		else{
			frm.search.value = frm.search.value.replaceAll(" ", "");
			frm.method = "post";
			frm.action ="./accountMain.do";
			frm.submit();
		}
	}
	else if(p==2){//전체리스트
			location.href='./accountMain.do'
   }
}	    
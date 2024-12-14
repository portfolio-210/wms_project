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
  location.href ='./accountMain.do?pageno='+n;
  /* 
   if (!search == null ) {
	url+= s =${sy}
	location.href = url
	//config main jsp 참죠!!
	*/
}
	  
/*	  
function sh(p){
	if(p==1){
		if(frm.search.value==""){
			alert("거래처명을 입력해주세요.");
			frm.search.focus();
			return false;
		}
		else{
			frm.search.value = frm.search.value.replaceAll(" ", "");
			frm.method = "get";
			frm.action ="./accountMain.do?search=" + 1;
			frm.submit();
		}
	}
	else if(p==2){//전체리스트
			location.href='./accountMain.do'
   }
}	
*/

function sh(p) {

    if (p == 1) {
        if (f1.search.value == "") {
            alert("거래처명을 입력해주세요.");
            f1.search.focus();
            return false;  // 검색어가 없으면 폼 제출을 막음
        } else {
            f1.search.value = f1.search.value.replaceAll(" ", "");  // 공백 제거
            f1.method = "get";
            // 사용자가 입력한 검색어를 URL 파라미터로 전송
            f1.action = "./accountMain.do?search=" + encodeURIComponent(f1.search.value);
            f1.submit();  // 폼을 제출
        }
    } else if (p == 2) {  // 전체 리스트로 이동
        location.href = './accountMain.do';  // '전체' 버튼 클릭 시 전체 리스트로 이동
    }
}    
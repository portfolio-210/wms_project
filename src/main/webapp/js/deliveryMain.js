function deliveryInsert(){
	location.href='/delivery/deliveryInsert.jsp'
};

// 수정
function deliveryModify(didx){
	location.href='/delivery/deliveryModify.do?didx='+didx;
};


//검색하면 form전송 핸들링
function sh(p){
	var part = f2.part.value;
	var search = f2.search;
	
	if(p == 1){
		
	}
	else if(p == 2){
		if(search.value ==""){
			if(part == "기사명"){	
				alert("찾으실 기사명을 입력해 주세요.");
				search.focus();
				return false;
			} 
			else if(part == "사원번호"){
				alert("찾으실 기사님의 사원번호를 입력해 주세요.");
				search.focus();
				return false;
			}
			else if(part ==  "연락처"){
				alert("찾으실 기사님의 연락처를 입력해 주세요.");
				search.focus();
				return false;
			}
		}
		else{
			search = search.value.replaceAll(" ", "");
			if(search.length == 0){
				alert("검색어를 다시 한 번 확인해주세요.");
			}
			else {
					f2.search.value = f2.search.value.replaceAll(" ","");
					f2.method = "get";
					f2.action ="deliveryMain.do?search=" + 2;
					f2.submit();
			}
		}
	}
	
	
	
}








function page_go(n){
	console.log(n);
  location.href ='./deliveryMain.do?pageno='+n;
  /* 
   if (!search == null ) {
	url+= s =${sy}
	location.href = url
	//config main jsp 참죠!!
	*/
}


// 현황 승인 
function approveCk(apck,a){
	var approve = apck.value;
	var idx = a;
	
	document.getElementById("dapprove").value = approve;
	document.getElementById("didx").value = idx

	
	
	f1.action = "/delivery/deliveryApprove.do";
	f1.method = "get";
	f1.submit();
	
	
}
	
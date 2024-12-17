function deliveryInsert(){
	location.href='/delivery/deliveryInsert.jsp'
};

// 수정
function deliveryModify(didx){
	location.href='/delivery/deliveryModify.do?didx='+didx;
};



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
	
function deliveryMain(){
	location.href="/delivery/deliveryMain.jsp";
	
}

function deliverySubmit(){
	
	if(f1){
		
	}else{
		
		f1.method="POST";
		f1.action="/delivery/deliveryInsertok.do";
		f1.submit();
		
	}
	
}
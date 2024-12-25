function copyAddress(address) {
      var tempInput = document.createElement('textarea');
      document.body.appendChild(tempInput);
      tempInput.value = address;
      tempInput.select();
      tempInput.setSelectionRange(0, 99999); 
      document.execCommand('copy');
      document.body.removeChild(tempInput);
      alert('주소가 복사되었습니다\n[' + address+']');
  }

$(function(){

    $("#menus").click(function(){
        var $screen = $("#blackscreen").css("display");
        if($screen=="none"){
            $("#blackscreen").css("display","block");
            $("#s_menu").stop().animate({
                "width":"85%"
            },200,function(){
                $("#menu_outline").css("display","block");
            });
        }
        else{
            $("#menu_outline").css("display","none");
            $("#s_menu").stop().animate({
                "width":"0%"
            },200,function(){
                $("#blackscreen").css("display","none");
            });
        }
    });

    $("#login_out").click(function(){
        if(confirm("로그아웃 하시겠습니까?")){
            location.href="/deliveryMobile/logout.do";
        }
    });


    $("#s_menu_ul>li").click(function(){
        var idx = $(this).index();
        var $gourl = "";
        switch(idx){
            case 0:
                $gourl = "";
            break;

            case 1:
                $gourl = "";
            break;
        }
        location.href = $gourl;
    });

});

	//배송준비
	function ma(state,idx){
		//대기
		if(state == "대기"){
			f1.method = "post";
			f1.action = "/deliveryMobile/mobileState.do?state=대기&idx="+idx;
			f1.submit();
		}
		else{
			alert("시스템 오류입니다. 다시 시도해주세요");
			return false;
		}
	}
	
	//배송중
	function mb(state,idx){
		if(state == "배송중"){
			f1.method = "post";
			f1.action = "/deliveryMobile/mobileState.do?state=배송중&idx="+idx;
			f1.submit();
		}
		else{
			alert("시스템 오류입니다. 다시 시도해주세요");
			return false;
		}
	}
	
	//촬영하기
	function mc(state,idx){
		if(state == "촬영하기"){
			console.log(f1.cam.value);
			//만약 저 밸류값 사진이 없음!!! 핸들링 XX
			f1.method = "post";
			f1.action = "/deliveryMobile/mobileState.do?state=촬영하기&idx="+idx;
			//f1.submit();
		}
		else{
			alert("시스템 오류입니다. 다시 시도해주세요");
			return false;
		}
	
	}

	//완료하기
	function md(state,idx){
		if(state == "완료하기"){
			if(confirm("배송 완료 처리하시겠습니까?")){
			f1.method = "post";
			f1.action = "/deliveryMobile/mobileState.do?state=완료하기&idx="+idx;
			f1.submit();
			}
		}
		else{
			alert("시스템 오류입니다. 다시 시도해주세요");
			return false;
		}
	}
	
	function repage(){
		location.href="/deliveryMobile/mobileMain.do";
		
	}

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

    //로그아웃
    $("#login_out").click(function(){
        if(confirm("로그아웃 하시겠습니까?")){
            location.href="/deliveryMobile/logout.do";
        }
    });


    //햄버거 메뉴
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
	function ma(state){
		alert("배송준비");
		location.href = "/deliveryMobile/mobileMain.do?state="+state;
	}
	
	//배송중
	function mb(){
		alert("배송중");
	}
	
	//촬영하기
	function mc(){
		alert("촬영하기");
		
	}

	//완료하기
	function md(){
		alert("완료하기");
	}

	
	
	function repage(){
		location.href="/deliveryMobile/mobileMain.do";
		
	}

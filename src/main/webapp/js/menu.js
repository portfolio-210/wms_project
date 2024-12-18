$(function(){
    
    /* 햄버그버튼 */
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
            location.href="";
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
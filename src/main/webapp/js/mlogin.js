var login_btn = document.querySelector("#login_btn");
login_btn.addEventListener("click",function(){
    if(fm.deliver_id.value==""){
        alert("기사님의 사원번호를 입력하세요");
        fm.deliver_id.focus();
    }
    else if(fm.deliver_pw.value==""){
        alert("기사님의 패스워드를 입력하세요");
        fm.deliver_pw.focus();
    }
    else{
        fm.method = "POST";
        fm.action = "";
        fm.enctype = "application/x-www-form-urlencoded";
        fm.submit();
    }
});
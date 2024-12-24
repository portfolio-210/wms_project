
  // DOMContentLoaded 이벤트를 사용하여 DOM이 완전히 로드된 후에 실행
  document.addEventListener("DOMContentLoaded", function() {
    // 페이지 로드 시 로컬 스토리지에 저장된 아이디와 패스워드가 있으면 입력
    if (localStorage.getItem("deliver_id") && localStorage.getItem("deliver_pw")) {
      document.getElementById("deliver_id").value = localStorage.getItem("deliver_id");
      document.getElementById("deliver_pw").value = localStorage.getItem("deliver_pw");
      document.getElementById("deliver_check").checked = true; // 체크박스도 체크된 상태로 설정
    }

    // 로그인 버튼 클릭 시 아이디, 패스워드를 로컬 스토리지에 저장
    document.getElementById("login_btn").addEventListener("click", function() {
      var id = document.getElementById("deliver_id").value;
      var pw = document.getElementById("deliver_pw").value;
      var isChecked = document.getElementById("deliver_check").checked;

      // 체크박스가 선택되었으면 로컬 스토리지에 저장
      if (isChecked) {
        localStorage.setItem("deliver_id", id);
        localStorage.setItem("deliver_pw", pw);
      } else {
        // 체크박스가 선택되지 않으면 로컬 스토리지에서 삭제
        localStorage.removeItem("deliver_id");
        localStorage.removeItem("deliver_pw");
      }

      // 로그인 처리 코드 추가 (여기서는 예시로만 처리)
      alert("로그인 처리되었습니다.");
    });
  });

  

  
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
          fm.action = "/deliveryMobile/mobileLoginOk.do";
          fm.enctype = "application/x-www-form-urlencoded";
          fm.submit();
      }
  });

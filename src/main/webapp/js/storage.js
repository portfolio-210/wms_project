
var frm = document.getElementById('frm');

function insert12(){
	
	var scode = frm.scode.value;
	var sspot = frm.sspot.value;
	var sname = frm.sname.value;
	var spost = frm.spost.value;
	var saddress1 = frm.saddress1.value;
	var saddress2 = frm.saddress2.value;
	var smname = frm.smname.value;
	var smhp = frm.smhp.value;
	var mid = frm.mid.value;
	var sdeleted = frm.sdeleted.value;
	// 선택된 라디오 버튼의 값 가져오기
	var susel = document.querySelector('input[name="suse"]:checked').value; // 선택된 라디오 버튼의 값
	    var suse = parseInt(susel); // int로 변환하여 0 또는 1로 설정!

	    // suse를 폼에 설정
	    document.getElementById('suse').value = suse;

	
	if(sname === ""){
		alert("등록할 창고명을 입력해주세요.");
		frm.sname.focus();
		return;
	} else 
	if(saddress1 === ""){
		alert("창고 주소를 입력해주세요.");
		return;
	} else if(spost === ""){
		alert("상세주소를 입력해주세요.");
		return;
	} else if(saddress2 === ""){
		alert("상세주소를 입력해주세요.");
		frm.saddress2.focus();
		return;
	} else if(smname === ""){
		alert("담당자 이름을 입력해주세요.");
		frm.smname.focus();
		return;
	} else if(smhp === ""){
		alert("담당자 연락처를 입력해주세요.");
		frm.smhp.focus();
		return;
	} else if(!/^\d{10,11}$/.test(smhp)){
			alert("올바른 전화번호를 입력해주세요.");
			frm.smhp.focus();
			return;
		}
		 else {
				
		frm.action="/storageInsert.do";  // 폼 전송 URL 설정
		frm.submit(); // 폼 제출
	}
}

async function checkCode(scode){
	
	const a = await fetch(`/api/checkCode/${scode}`); // 서버에 요청
	const b = await a.json(); // JSON으로 변환하여 중복 여부를 얻음
	return b; // true 또는 false 반환
	
	
}

async function RandomCode() {
		var scode;
		var a = true;
				
		while (a) {		
		        scode = Math.floor(10000 + Math.random() * 90000); // 10000부터 99999 범위의 숫자 생성
		        a = await checkCode(scode); // 중복 체크
				
		    }
			
       document.getElementById('scode').value = scode;
	   
   }//창고 코드 만들기(랜덤함수이며 5글자 숫자)
   
   
   onload = function() {
        //scode 입력 필드가 존재하는지 확인
       if (location.pathname === '/storage/storageInsert.do') {
           RandomCode(); // scode 필드가 있을 때만 랜덤 코드 생성
       }
   };

   //수정시
   function validate1() {
       var sname = frm.sname.value.trim();
       var spost = frm.spost.value.trim();
       var saddress1 = frm.saddress1.value.trim();
       var saddress2 = frm.saddress2.value.trim();
       var smname = frm.smname.value.trim();
       var smhp = frm.smhp.value.trim();

       if (sname === "") {
           alert("창고명을 입력해주세요.");
           frm.sname.focus();
           return false;
       } 
       else if (saddress1 === "") {
           alert("창고 주소를 입력해주세요.");
           frm.saddress1.focus();
           return false;
       }
       else if (spost === "") {
           alert("우편번호를 입력해주세요.");
           frm.spost.focus();
           return false;
       } 
       else if (saddress2 === "") {
           alert("상세 주소를 입력해주세요.");
           frm.saddress2.focus();
           return false;
       }
      else if (smname === "") {
           alert("담당자명을 입력해주세요.");
           frm.smname.focus();
           return false;
       }
      else if (smhp === "") {
           alert("담당자 연락처를 입력해주세요.");
           frm.smhp.focus();
           return false;
       }
       else if (!/^\d{10,11}$/.test(smhp)) {
           alert("올바른 연락처를 입력해주세요. 숫자만 입력 가능합니다.");
           frm.smhp.focus();
           return false;
       }
	else{
       // 선택된 라디오 버튼의 값 (true/false)을 설정
       //var suse = (susel.value === 'true');
       //document.getElementById('suse').value = suse;
		
	  // console.log(suse);
       // 유효성 검사 통과 시 폼 제출 허용
       return true;
	   }
   }

function back1(){
	if(confirm("입력된 내용은 모두 삭제 됩니다. 취소 하시겠습니까?")){
		frm.reset();
		location.href="/storage/storageMain.do";
	}
}

// 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('spost').value = data.zonecode;
                document.getElementById("saddress1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("saddress2").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
	
	
/////////////////////////////////////////////////////////////////
//main

function searchall1(){
						
			var mspot = frm.mspot.value;
			console.log("mspot value:", mspot);
	       //frm.method = "get"; // 폼 메서드 설정
	       //frm.action = "/storage/storageMain.do"; // 폼 액션 설정
	       // 폼을 body에 추가
	       // 폼 제출
	       //frm.submit();	  	
		   var url = "/storage/storageMain.do?mspot=" + encodeURIComponent(mspot);
		   window.location.href = url; // URL로 이동
}

function search1(){
	var search = document.getElementById("searchKeyword").value.trim();
	if (search === "") {
	        alert("검색어를 입력하세요");
	        return false;
	}else {
		 
		    document.getElementById("hiddenSearch").value = search;
		     // 폼 제출
		  }
		
	
}

function RadioClick(radio){
	if(frm.suse[1].checked==true){
		alert("미사용중으로 변경시 재고 입고, 출고가 적용되지 않습니다.")
	}
	console.log("선택된 값: ", radio.value);
	/*
	if(radio.value === "false"){
	alert("미사용중으로 변경시 재고 입고, 출고가 적용되지 않습니다.");
	}
	    console.log("선택된 값: ", radio.value);
	*/

}

function deleteStorage(scode) {
	if (confirm("입력된 내용은 모두 삭제 됩니다. 취소 하시겠습니까?")) {
	       $.ajax({
	           url: '/storageDelete.do',
	           type: 'POST',
	           data: { scode: scode }, // 다른 데이터도 포함할 수 있음
	           success: function() {
	               location.reload();
	           },
	           error: function() {
	               alert("삭제에 실패했습니다.");
	           }
	       });
	   }
}
	
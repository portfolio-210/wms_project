
// 이미지 클릭 이벤트를 동적으로 처리하기 위해 이벤트 위임 사용
document.body.addEventListener('click', function(event) {
    if (event.target && event.target.id === 'showImageBtn') {
        event.preventDefault();
        document.getElementById('imageWrapper').style.display = 'block'; // 이미지 보여주기
    }

    if (event.target && event.target.id === 'closeBtn') {
        event.preventDefault();
        document.getElementById('imageWrapper').style.display = 'none'; // 이미지 닫기
    }
});


	// 체크박스
	
	function toggleSelectAll() {
	        const selectAll = document.getElementById('selectAll');
	        const checkboxes = document.querySelectorAll('.checkbox');
	        
	        // 전체 선택/해제 상태에 따라 체크박스 모두 선택/해제
	        checkboxes.forEach(checkbox => {
	            checkbox.checked = selectAll.checked;
	        });
	    }

	    // 개별 체크박스 클릭 시, 전체 체크박스를 업데이트
	    const checkboxes = document.querySelectorAll('.checkbox');
	    checkboxes.forEach(checkbox => {
	        checkbox.addEventListener('change', function() {
	            const selectAll = document.getElementById('selectAll');
	            const checkedCheckboxes = document.querySelectorAll('.checkbox:checked');

	            // 하나라도 체크가 해제되면 전체 체크박스도 해제
	            if (checkedCheckboxes.length === checkboxes.length) {
	                selectAll.checked = true; // 모든 체크박스가 체크되면 전체 체크박스도 체크
	            } else {
	                selectAll.checked = false; // 하나라도 체크가 해제되면 전체 체크박스 해제
	            }
	        });
	    });










//배송 기사별 현황 버튼
function btn(a){
	
	var start = document.getElementById("start").value;
	var end = document.getElementById("end").value;
	var dcode = document.getElementById("dcode").value;
	console.log(a);
	
	// 오더 일자별 검색
	if(a == 1 ){
		if(start == ""){
			alert("검색하실 시작 날짜를 선택해주세요.");
			return false;
		}
		else if(end == ""){
			alert("검색하실 종료 날짜를 선택해주세요.");
			return false;
		}
		else if(start > end){
			alert("종료날짜보다 시작날짜가 더 클수 없습니다.");
		}
		else{
		//location.href = "/deliveryShip/deliveryShip.do?start="+start+"&end="+end;
			location.href = "/deliveryShip/deliveryShip.do?start="+start+"&end="+end;

		}				
		
	}
	
	// 배송기사별 현황 검색
	if(a == 2 ){
		
		if(dcode == ""){
			alert("배송기사를 선택해주세요.")
		}
		else{
			location.href = "/deliveryShip/deliveryShip.do?dcode="+dcode;
		}
	}
}



function tracking(){
	
	var selectedAidxs = [];
	   document.querySelectorAll('.checkbox:checked').forEach(function(checkbox) {
	       selectedAidxs.push(checkbox.getAttribute('aidx'));
	   });

	   // 선택된 aidx 값이 없으면 알림
	   if (selectedAidxs.length === 0) {
	       alert("운송장번호 생성할 오더를 선택해주세요.");
	       return;
	   }
	   else{
	   var aidx = selectedAidxs.join(',');
	   document.getElementById('aidx').value = aidx;	
	   console.log(aidx);
		
	   f1.method ="post";
	   f1.action = "/deliveryShip/deliveryTracking.do?idx="+aidx;
	   f1.submit();

	   }

	   
	   // 체크박스 체크 초기화
	      document.querySelectorAll('.checkbox').forEach(function(checkbox) {
	          checkbox.checked = false;
	      });
		  
	  // selectAll 체크박스도 초기화
	      document.getElementById('selectAll').checked = false;
}


// qr생성
function qrmake(){
	
var selectedAidxs = [];
	   document.querySelectorAll('.checkbox:checked').forEach(function(checkbox) {
	       selectedAidxs.push(checkbox.getAttribute('aidx'));
	   });

	   // 선택된 aidx 값이 없으면 알림
	   if (selectedAidxs.length === 0) {
	       alert("운송장번호 생성할 오더를 선택해주세요.");
	       return;
	   }
	   else{
	   var aidx = selectedAidxs.join(',');
	   document.getElementById('aidx').value = aidx;	
	   console.log(aidx);
		
	   f1.method ="post";
	   f1.action = "/deliveryShip/deliveryQr.do?idx="+aidx;
	   f1.submit();

	   }

	   
	   // 체크박스 체크 초기화
	      document.querySelectorAll('.checkbox').forEach(function(checkbox) {
	          checkbox.checked = false;
	      });
		  
	  // selectAll 체크박스도 초기화
	      document.getElementById('selectAll').checked = false;
}






function go_page(i, search){
    let url = "deliveryShip.do?pageno=" + i;

    location.href = url;
}




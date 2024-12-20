function deliveryInsert(){
	location.href='/deliveryList/deliveryInsert.jsp'
};

// 수정
function deliveryModify(didx){
	location.href='/deliveryList/deliveryModify.do?didx='+didx;
};


function sh(type) {
    var spot = document.querySelector('select[name="spot"]').value;  // 소속
    var part = document.querySelector('select[name="part"]').value;  // 담당기사 검색 기준
    var search = document.querySelector('#search').value.trim();  // 검색어, 공백 제거


	
	    // 소속 검색
    if (type === 1) {
        // 소속이 '전체'일 때와 지점 선택 시 처리
        if (spot === "전체") {
            // 모든 데이터를 출력 (mspot에 관계없이)
            window.location.href = './deliveryMain.do?spot=전체';
        } else {
            // 특정 지점만 출력
            window.location.href = './deliveryMain.do?spot=' + spot;
        }
    }

    // 담당기사 검색
    if (type === 2) {
        var mspot = '<%= sessionScope.mspot %>'; // 세션에서 지점 정보 가져오기
        var url = './deliveryMain.do?part=' + part;  // 기본 URL

        // 검색어가 비어 있는지 체크
        if (search === "") {
            if (part === "기사명") {
                alert("찾으실 기사명을 입력해 주세요.");
            } else if (part === "사원번호") {
                alert("찾으실 기사님의 사원번호를 입력해 주세요.");
            } else if (part === "연락처") {
                alert("찾으실 기사님의 연락처를 입력해 주세요.");
            }
            return false;  // 검색어가 없으면 함수 종료
        }

        search = search.replace(/\s+/g, '');  // 모든 공백을 제거합니다.

        if (search.length === 0) {
            alert("검색어를 다시 한 번 확인해주세요.");
            return false;
        }

        url += '&search=' + search;

        // 본사일 경우, 모든 지점에서 검색
        if (mspot === '본사') {
            window.location.href = url;
        } else {
            // 특정 지점만 검색
            url += '&spot=' + mspot;
            window.location.href = url;
        }
    }
}





function page_go(n,search){
	var url ="./deliveryMain.do?pageno="+ n;

	if (search) {
		url+= "&search=" + encodeURIComponent(search);
			}
			location.href = url
}


// 현황 승인 
function approveCk(apck,a){
	var approve = apck.value;
	var idx = a;
	
	document.getElementById("dapprove").value = approve;
	document.getElementById("didx").value = idx

	
	
	f1.action = "/deliveryList/deliveryApprove.do";
	f1.method = "get";
	f1.submit();
	
	
}
	
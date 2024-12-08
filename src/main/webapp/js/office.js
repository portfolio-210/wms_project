//officeMain.jsp
var search_word = document.getElementById("search");

//검색 버튼 클릭 시 적용 함수
function search_office(){
	console.log(search_word);
	if(search_word.value == ""){
		//검색어를 입력하지 않은 경우
		alert("검색할 지점명을 입력해주세요.");
		search_word.focus();
	}
	else {
		//검색어를 입력한 경우
		var search = search_word.value.trim();
		search = search.replaceAll(" ", "");
		
		if(search.length == 0){
			alert("검색어를 다시 한 번 확인해주세요.");
			search_word.focus();
		}

		else {
			frm.method="post";
			frm.action="../office/officeMain.do";
			frm.submit();
		}
	}
}

//전체 버튼 클릭 시 적용 함수
function searchAll_office(){
	search_word.value = "";
	frm.method="post";
	frm.action="../office/officeMain.do";
	frm.submit();
}

//수정 버튼 클릭 시 적용 함수
function modify_office(){
	
}

//삭제 버튼 클릭 시 적용 함수
function delete_office(oidx){
	var key = window.btoa("wms.test");
	if(confirm("해당 게시물을 삭제하시겠습니까?\n삭제된 데이터는 복구하지 못합니다.")){
		location.href="../office/office_delete.do?oidx=" + window.btoa(oidx) + "&key=" + key;
	}
}


//officeInsert.jsp

//지점명 중복체크 버튼 클릭 시 적용 함수
function officenameCheck(){
	var officename = frm.officename.value;
	if(officename == ""){
		alert("등록할 지점을 입력해주세요.");
		frm.officename.focus();
	}
	else {
		//입력한 지점 이름 내 공백 체크
		officename = officename.replaceAll(" ", "");
		if(officename.length == 0){
			alert("입력한 지점 이름을 다시 한번 확인해주세요.");
		}
		else {
			//http : 전송하는 값, result : Back-end에서 받은 응답을 저장하는 값
			var http, result;
			http = new XMLHttpRequest();
			http.onreadystatechange = function(){
				if(http.readyState == 4 && http.status == 200){
					result = this.response;
					if(result == "0"){
						alert("등록 가능한 지점입니다.");
					} else {
						alert("해당 지점은 이미 등록되어 있습니다.");
					}
				}
			}
		}
		http.open("post", "../office/officenameCheck.do", true);
		http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		http.send("officename=" + officename);
	}
}

//등록하기 버튼 클릭 시 적용 함수
function insert_check(){
	var officename = frm.officename;
	var mname = frm.mname;
	var otel = frm.otel;
	var opost = frm.opost;
	var oaddress = frm.oaddress;
	
	if(officename == ""){
		alert("등록할 지점명을 입력해주세요.");
		officename.focus();
	} else if(mname.value == ""){
		alert("해당 지점 담당자를 선택해주세요.");
		mname.focus();
	} else if(otel.value == ""){
		alert("등록할 지점의 대표 연락처를 입력해주세요.");
		otel.focus();
	} else if(opost.value == ""){
		alert("해당 지점의 주소를 입력해주세요.");
		opost.focus();
	} else if(oaddress.value == ""){
		alert("상세 주소를 입력해주세요.");
		oaddress.focus();
	} else {
		//대표 연락처 "-" 포함 되도록 검사
		
		//부가 유효 검사 후 submit
		frm.action="../office/office_insert.do";
	}
}

//취소하기 버튼 클릭 시 적용 함수
function cancel(){
	if(confirm("해당 지점 등록을 취소 하시겠습니까?")){
		frm.reset();
		location.href="../office/officeMain.do";
	}
}


//officePopList.jsp

//팝업 관리자 검색
function search_member(){
	var part = frm.part.value;
	var search = frm.search;
	if(search.value == ""){
		if(part == "이름"){
			alert("찾으실 담당자 이름을 입력해주세요.");
			search.focus();
		} else if(part == "아이디"){
			alert("찾으실 담당자 아이디를 입력해주세요.");
			search.focus();
		} else if(part == "연락처"){
			alert("찾으실 담장자의 연락처를 입력해주세요.");
			search.focus();
		}
	}
	else {
		//검색어를 입력한 경우
		search = search.value.replaceAll(" ", "");
		if(search.length == 0){
			alert("검색어를 다시 한 번 확인해주세요.");
		}
		else {
			frm.method="post";
			frm.action="/office/officePopList.do";
			frm.submit();
		}
	}
}

//팝업 관리자 전체 출력 버튼
function searchAll_member(){
	frm.search.value = "";
	frm.method="post";
	frm.action="../office/officePopList.do";
	frm.submit();
}

//팝업 관리자 적용 버튼 클릭
function apply_member(midx){
	console.log(midx);

	//http : 전송하는 값, result : Back-end에서 받은 응답을 저장하는 값
	var http, result;
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			result = this.response;
			if(result.length === 0){
				alert("적용할 수 없는 관리자입니다.\n관리자 현황을 다시 확인해주세요.");
			} else {
				var data = result.split("|");
				var mname = data[1];
				alert(mname + "님은 적용 가능한 관리자입니다.");
			}
		}
	}
	http.open("post", "../office/officeInsert.do", true);
	http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	http.send("midx=" + midx);
}



//주소 찾기 카카오 API 연동
// 우편번호 찾기 화면을 넣을 element
var element_layer = document.getElementById('layer');

function closeDaumPostcode() {
    // iframe을 넣은 element를 안보이게 한다.
    element_layer.style.display = 'none';
}

function sample2_execDaumPostcode() {
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
            document.getElementById("opost").value = data.zonecode;
            document.getElementById("oroad").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("oaddress").focus();

            // iframe을 넣은 element를 안보이게 한다.
            // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
            element_layer.style.display = 'none';
        },
        width : '100%',
        height : '100%',
        maxSuggestItems : 5
    }).embed(element_layer);

    // iframe을 넣은 element를 보이게 한다.
    element_layer.style.display = 'block';

    // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
    initLayerPosition();
}

// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
function initLayerPosition(){
    var width = 300; //우편번호서비스가 들어갈 element의 width
    var height = 400; //우편번호서비스가 들어갈 element의 height
    var borderWidth = 5; //샘플에서 사용하는 border의 두께

    // 위에서 선언한 값들을 실제 element에 넣는다.
    element_layer.style.width = width + 'px';
    element_layer.style.height = height + 'px';
    element_layer.style.border = borderWidth + 'px solid';
    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
    element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
    element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}

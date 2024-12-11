var isIdChecked = false;  
var phoneRegex = /^\d{3}-\d{3,4}-\d{4}$/;// 휴대폰 번호만
var nameRegex = /^[가-힣]{2,4}$/;
var ahp_regex = /^\d{3}-\d{4}-\d{4}$|^\d{3}-\d{3}-\d{4}$|^\d{2}-\d{4}-\d{4}$|^\d{2}-\d{3}-\d{4}$|^\d{4}-\d{4}$/;
var anum_regex = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/;
var afax_regex = /^(?:\+82-\d{1,2}-\d{3,4}-\d{4}|\d{2,3}-\d{3,4}-\d{4})$/;

	
	// 거래처명 중복체크
	function company_check(){
		var acompany = document.getElementById("acompany");
		
		if(f1.acompany.value == ""){
			alert("거래처명을 입력해주세요.");
			f1.acompany.focus();
			return false;
		}
		else if(f1.acompany.value.length < 2){
			alert("옳바른 거래처명을 입력해주세요.");
			return false;
		}

		else{
			var data = f1.acompany.value.replaceAll(" ", "");
			
			if(data.length == 0){
				alert("정상적인 거래처명을 입력해주세요.");
				 id.value = null;
			}else{
				let http = new XMLHttpRequest();
				let result, count;
				
				//var http, result, count;  // 날리는건 http, 백엔드가 주는건 result
				//http = new XMLHttpRequest();
				http.onreadystatechange = function () {
				                
					if (http.readyState == 4 && http.status == 200) {
	                   // 응답 내용을 먼저 확인해봄
	                   console.log("응답 데이터:", this.response);
	                   
	                   const responseArray = this.response.split(',');
	                   
	                   if (responseArray.length === 2) {
	                       result = responseArray[0].trim();  // 첫 번째 값
	                       count = responseArray[1].trim();   // 두 번째 값
						   
						   // count 값을 3자리로 맞추고 string으로 받은값을 숫자로 변환하고 1더해줘야한다 현재 DB데이터갯수니까
						    count = (parseInt(count) + 1).toString().padStart(3, '0'); // 3자리로 0을 채운다
	                   } else {
	                       console.error("숫자 못가져온데 ㅜㅜ");
	                       return;
	                   }
						console.log(result);	// 이건 0 아님 1 중복확인이고!!
						console.log(count);	// DB 총갯수 그럼 여기다 +1하면됨
						
						// 중복환인끝나면 코드 자동생성되게!!!!
						if (result == "0") {
	                        alert("등록 가능한 거래처명 입니다.");
							f1.acode.value ="DE"+count;
	                        isIdChecked = true;  
							acompany.style.cursor = "pointer";   
	                        acompany.setAttribute("readonly", true);
	                    } else {
	                        alert("[ "+data+" ]"+" 의 거래처명은 이미 등록되어 있습니다.");
							f1.acompany.value = "";
	                        isIdChecked = false; 
							acompany.removeAttribute("readonly");
							
	                    }
	                    console.log(result);
	                }
	            };
	
	            http.open("post", "./companyck.do", true);  
	            http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	            http.send("acompany=" + data); 
	        }
	    }
	}
	
	// 거래처명 중복완료되면 readonly되는데 다시 거래처명을 바꾸고 싶을때 readonly해제되게
	function re_company(z) {
		var acompany = document.getElementById("acompany");
		var acode = document.getElementById("acode");
	   if(z.readOnly == true){
		if(confirm('거래처명을 수정 하시겠습니까?')){
			z.readOnly = false;
			acompany.value="";
			acode.value="";
			acompany.focus();
			acompany.style.cursor = "text";  
			isIdChecked = false;
		}
	   }
	}


	function account_check(){
		
		if(f1.acompany.value == ""){
			alert("거래처명을 입력해주세요.");
			f1.acompany.focus();
			return false;
		}
		else if(!isIdChecked){
					alert("거래처명 중복체크을 해주세요.");
					return false;
				}
		else if(f1.aname.value == ""){
			alert("대표자명을 입력해주세요");
			f1.anme.value="";
			f1.aname.focus();
			return false;
		}
		else if(f1.aindustry.value == ""){
			alert("업태를 입력해주세요.");
			f1.aindustry.value="";
			f1.aindustry.focus();
			return false;
		}
		else if(f1.aname.value == ""){
			alert("대표자명을 입력해주세요.");
			f1.aname.value="";
			f1.aname.focus();
			return false;
		}
		else if (!nameRegex.test(f1.aname.value)) {
			 alert("대표자명은 한글로 2~4글자만 입력 가능합니다.");
			 //f1.aname.value = "";
			 f1.aname.focus();
			 return false;
		}
		else if(f1.ahp.value == ""){
			alert("대표번호를 입력해주세요.");
			//f1.ahp.focus();
			return false;
		}
		else if(!ahp_regex.test(f1.ahp.value)){
			alert("옳바르지 못한 전화번호 형태입니다.");
			f1.ahp.value="";
			f1.ahp.focus();
			return false;
		}

		else if(f1.anum.value==""){
			alert("사업자 번호를 입력해주세요.");
			f1.anum.focus();
			return false;
		}

		else if(!anum_regex.test(f1.anum.value)){
			alert("올바르지 않는 사업자 번호 입니다.");
			//f1.anum.value="";
			f1.anum.focus();
			return false;
		}

		else if(f1.atype.value==""){
			alert("종목을 입력해주세요");
			f1.atype.focus();
			return false;
		}
		else if(f1.afax.value == ""){
			alert("팩스번호를 입력해주세요.")
			f1.afax.value="";
			f1.afax.focus();
			return false;
				}
		else if(!afax_regex.test(f1.afax.value)){
			alert("올바르지 않는 팩스번호 입니다.")
			f1.afax.value="";
			f1.afax.focus();
			return false;
		}
		else if(f1.apost.value==""){
			alert("주소찾기를 통하여 주소를 입력해 주세요.");
			f1.apost.value="";
			f1.aroad.value="";
			return false;
		}
		else if(f1.aroad.value==""){
			alert("주소찾기를 통하여 주소를 입력해 주세요.");
			f1.apost.value="";
			f1.aroad.value="";
			return false;
		}
		else if(f1.addr.value==""){
			alert("상세주소를 입력해주세요.");
			f1.addr.value="";
		}
		else{
		f1.method="post";
		f1.action="/account/accountInsertok.do";
		f1.submit();
		}
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
	            document.getElementById("apost").value = data.zonecode;
	            document.getElementById("aroad").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("addr").focus();

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
	    var borderWidth = 1; //샘플에서 사용하는 border의 두께

	    // 위에서 선언한 값들을 실제 element에 넣는다.
	    element_layer.style.width = width + 'px';
	    element_layer.style.height = height + 'px';
	    element_layer.style.border = borderWidth + 'px solid';
	    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
	    element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
	    element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
	}
		
		
	
	
	
	
	
	
	
	
	
	

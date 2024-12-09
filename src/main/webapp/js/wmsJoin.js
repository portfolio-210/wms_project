// 중복확인이 완료되었는지 여부를 저장하는 변수
var isIdChecked = false;  
var idRegex = /^[a-z0-9]+$/;
var passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{6,}$/;  // 6자 이상, 영문자+숫자 포함
var phoneRegex = /^\d{3}-\d{3,4}-\d{4}$/;// 휴대폰 번호만
var nameRegex = /^[가-힣]{2,4}$/;
var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;


// 지점을 선택하면 지점을 선택할수있는 select가 나와게!!
document.addEventListener('DOMContentLoaded', function () {
    // DOM이 로드된 후 실행되는 코드
    var mpart = document.getElementById('mpart');
    if (mpart) {
        mpart.addEventListener('change', function() {
            var mpartValue = this.value;
            var mspot = document.getElementById('mspot');
          
            if (mpartValue === '지점') {
                mspot.hidden = false; 
            } else {
                mspot.hidden = true; 
            }
        });
    }
});



// 아이디 중복 확인 함수
function idcheck() {
	
    var id = document.getElementById("mid");
	

    if (f1.mid.value == "") {
        alert("아이디를 입력하세요");
        f1.mid.focus();
			}
			else if(f1.mid.value == ""){
					alert("아이디를 입력해주세요.");
					return false;
			}

			else if(f1.mid.value=="admin"||f1.mid.value=="master"||f1.mid.value=="webmaster"||f1.mid.value=="administrator"|| f1.mid.value=="manager"){
					alert("＂"+f1.mid.value+"＂"+ "의 아이디는 사용이 불가능합니다.");
					f1.mid.value = "";
					return false;
			}
			else if (f1.mid.value.length < 4) {
		        	alert("아이디는 최소 4자 이상이어야 합니다.");
		        	return false;
		    }

			// 아이디 영문자만 허용 (정규식으로 확인)
			else if (!idRegex.test(f1.mid.value)) {
			       alert("아이디는 특수문자 및 대문자를 사용할수 없습니다.");
				   f1.mid.value = "";
			       return false;
				  
				
    } else {
        var data = f1.mid.value.replaceAll(" ", "");

        if (data.length == 0) {
            alert("정상적인 아이디를 입력해주세요");
            id.value = null;
        } else {
            var http, result;  // 날리는건 http, 백엔드가 주는건 result
            http = new XMLHttpRequest();
            http.onreadystatechange = function () {
                
				if (http.readyState == 4 && http.status == 200) {
                    result = this.response;
                    
					if (result == "0") {
                        alert("사용가능한 아이디입니다.");
                        isIdChecked = true;  // 중복확인 완료
						 // 중복확인 후 아이디 입력 필드를 readonly로 설정
                        mid.setAttribute("readonly", true);
                    } else {
                        alert("해당 아이디는 사용할 수 없습니다.");
						f1.mid.value = "";
                        isIdChecked = false;  // 중복아이디인 경우
						mid.removeAttribute("readonly");
                    }
                    console.log(result);
                }
            };

            http.open("post", "./idcheck.do", true);  // 해당 백엔드 경로로 비동기 통신
            http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            http.send("mid=" + f1.mid.value);  // POST 요청으로 아이디 전송
        }
    }
}

function part_click(){
	if(f1.mpart.value=="본사"){
		f1.mspot.value="N";
	}
}

function login_check(){
    var hp1 = document.getElementById("hp1");
    var hp2 = document.getElementById("hp2");
    var hp3 = document.getElementById("hp3");
    var repw = document.getElementById("repw");
	var password = f1.mpass.value;// 비밀번호 영문+숫자


   		if(f1.mpart.value == "지점"){
			
			if(f1.mspot.value == "N"){
			       alert("지점을 선택해주세요.");
			       return false;
			}
		}
		else if(f1.mpart.value=="본사"){
					f1.mspot.value="N";
					
				}
		
		
		if(f1.mname.value == ""){
				alert("담당자명을 입력하세요.");
				f1.mpass.value="";
				repw.value="";
				return false;
			    }
				
		else if (!nameRegex.test(f1.mname.value)) {
				 alert("이름은 한글로 2~4글자만 입력 가능합니다.");
				 f1.mname.value = "";
				 f1.mpass.value="";
				 repw.value="";
				 return false;
				}		
				
		else if(f1.mjob.value == ""){
				alert("직책을 선택해주세요.");
				f1.mpass.value="";
				repw.value="";
				return false;
		}
		else if(!isIdChecked){
				  alert("아이디 중복확인을 해주세요.");
				  f1.mpass.value="";
				  repw.value="";
				  return false;  // 중복 확인이 완료되지 않으면 폼 제출을 막음
		}
	    else if(f1.mpass.value == ""){
	        alert("비밀번호를 입력하세요");
	        return false;
    	}
		
	    else if (f1.mpass.value.length < 6) {
	        alert("비밀번호는 최소 6자 이상이어야 합니다.");
			f1.mpass.value="";
			repw.value="";
	        return false;
	    }
	    else if (!passwordRegex.test(password)) {
	        alert("비밀번호는 최소 6자 이상, 영문자와 숫자를 포함해야 합니다.");
			f1.mpass.value="";
			repw.value="";
	        return false;
	    }	
	    else if(f1.mpass.value != f1.repw.value){
	        alert("동일한 비밀번호를 입력하세요.");
			f1.mpass.value="";
			repw.value="";
	        return false;
	    }
	    else if(f1.memail.value == ""){
	        alert("이메일을 입력해주세요");
			f1.mpass.value="";
			repw.value="";
	        return false;
	    }
	  	else if (!emailRegex.test(f1.memail.value)) {
	       alert("이메일 형식이 올바르지 않습니다.");
		   f1.memail.value ="";
		   f1.mpass.value="";
		   repw.value="";
	       return false;
	   	}
	    
	    else if(hp1.value == "" || hp2.value == "" || hp3.value == ""){
	        alert("올바른 전화번호를 입력해주세요.");
			hp2.value = "";
			hp3.value = "";
			f1.mpass.value="";
			repw.value="";
	        return false;
	    }
		
		
		
		if (!/^\d+$/.test(hp2.value) || !/^\d+$/.test(hp3.value)) {
		            alert("전화번호는 숫자만 입력 가능합니다.");
		            hp2.value = "";
		            hp3.value = "";
					f1.mpass.value="";
					repw.value="";
		            return false;
			}

	else{
	    f1.mhp.value = hp1.value + hp2.value +  hp3.value;
		f1.method="post";
		f1.action="./wmsJoinok.do";
	    f1.submit();
	}	
}

/*
function idcheck() {
	f1.submit();
}
*/

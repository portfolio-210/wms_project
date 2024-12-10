//paletteMain.jsp - 파렛트 리스트 페이지 관련 javascript

//검색 버튼 클릭 시
function searchPalette(){
    var search = frm.search;
    if(search.value == ""){
        alert("검색할 파렛트명을 입력해주세요");
        search.focus();
    }
    else {
    		//검색어를 입력한 경우
    		search = search.value.trim();
    		search = search.replaceAll(" ", "");

    		if(search.length == 0){
    			alert("검색어를 다시 한 번 확인해주세요.");
    			search.focus();
    		}
    		else {
    			frm.method="post";
    			frm.action="../palette/paletteMain.do";
    			frm.submit();
    		}
    	}
}

//전체 버튼 클릭 시
function searchAllPalette(){
    search.value = "";
    frm.method="post";
    frm.action="../palette/paletteMain.do";
    frm.submit();
}

//수정 버튼 클릭 시
function modify_palette(pidx){

}

//삭제 버튼 클릭 시
function delete_palette(pidx){
    console.log(pidx);
    if(confirm("해당 게시물을 삭제하시겠습니까?\n삭제된 데이터는 복구하지 못합니다.")){
        const form = document.createElement("form");
        form.method="post";
        form.action="../palette/palette_delete.do";

        const input = document.createElement("input");
        input.type="hidden";
        input.name="pidx";
        input.value=pidx;

        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }
}



//paletteInsert.jsp - 파렛트 등록 페이지 관련 javascript

//파렛트명 중복체크 검사
var pnameCheck = false; //중복체크 버튼 클릭 유무
function pname_validate(){
    var pname = frm.pname;
    if(pname.value == ""){
        alert("등록할 파렛트 이름을 먼저 입력해주세요.");
    }else{
        //등록할 파렛트 이름 입력 시
        pname = pname.value.replaceAll(" ", "");
        if(pname.length == 0){
            alert("입력하신 파렛트 이름을 다시 확인해주세요.");
        }else {
            //http : 전송하는 값, result : Back-end에서 받은 응답을 저장하는 값
            var http, result;
            http = new XMLHttpRequest();
            http.onreadystatechange = function(){
                if(http.readyState == 4 && http.status == 200){
                    result = this.response;
                    if(result == "0"){
                        pnameCheck = true;
                        alert("등록 가능한 파렛트입니다.");
                        frm.pname.readOnly = true;
                    } else {
                        alert("해당 파렛트는 이미 등록되어 있습니다.\n새로운 파렛트를 입력해주세요");
                    }
                }
            }
        }
        http.open("post", "../palette/pnameCheckOk.do", true);
        http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        http.send("pname=" + pname);
    }
}


///paletteModify.jsp - 파렛트 수정 페이지 관련 javascript
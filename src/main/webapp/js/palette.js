//paletteMain.jsp - 파렛트 리스트 페이지 관련 javascript
var search = frm.search;

//검색 버튼 클릭 시
function searchPalette(){
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
    frm.method="get";
    frm.action="../palette/paletteMain.do";
    frm.submit();
}

//paletteInsert.jsp - 파렛트 등록 페이지 관련 javascript



///paletteModify.jsp - 파렛트 수정 페이지 관련 javascript
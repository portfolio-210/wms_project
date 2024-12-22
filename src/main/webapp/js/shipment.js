//오더 일자별 검색 버튼
//let search_ck = false;
function search_shipment(){
    var start_date = search_frm.start_date.value;
    var end_date = search_frm.end_date.value;
    console.log(start_date);
    console.log(end_date);
/*
    if(search_ck){
        start_date = "";
        end_date = "";
        console.log("날짜 초기화");
        search_ck = false;
        location.href="/shipment/shipmentMain.do";
    }
*/
    if(!start_date){
        alert("시작 날짜를 입력해주셔야 합니다.");
    }else if(!end_date){
        alert("종료 날짜를 입력해주셔야 합니다.");
    }else{
        const start = new Date(start_date);
        const end = new Date(end_date);
        if(start > end){
            alert("시작 날짜가 종료 날짜보다 늦을 수 없습니다.");
        }else{
            //search_ck = true;
            //console.log(search_ck);
            search_frm.method="get";
            search_frm.action="../shipment/shipmentMain.do";
            search_frm.submit();
        }
    }
}

//전체 체크박스 checked=true
function all_select(ck){
    var ea = document.getElementsByName("product");
    for(var i=0; i<ea.length; i++){
        ea[i].checked = ck;
    }
}

//개별 체크박스 checked
function one_select(){
    var ea = document.getElementsByName("product");
    var count = 0;
    for(var i=0; i<ea.length; i++){
        if(ea[i].checked == true){
            count++;
        }
    }
    if(count == ea.length){
        document.getElementById("all_check").checked = true;
    }
    else{
        document.getElementById("all_check").checked = false;
    }
}

//물품 검색 - 팝업 오픈
function open_popup(){
    var pd_check = document.getElementsByName("product");
    var pdcodes = new Array();   //체크된 체크박스의 value 값을 담을 배열
    var index = 0;
    //console.log(pd_check[0].getAttribute("value"));
    for(var i=0; i<pd_check.length; i++){
        if(pd_check[i].checked == true){
            pdcodes[index] = pd_check[i].getAttribute("value");
            index++;
        }
    }
    if(index == 0){
        alert("검색할 물품을 선택해주세요.");
    }
    else{
        //console.log(pdcode);
        let url = "shipmentPopList.do?pdcodes=" + encodeURIComponent(pdcodes.join(","));
        console.log(pdcodes.join(","));
        window.open(url, "popupWindow", "width=750px, height=500px");
    }
}

//물품 검색 팝업 - 검색 버튼 클릭
function search_product(){
    var part = frm.part;
    var search = frm.search;
    var pdcodes = frm.pdcodes;
    if(search = ""){
        alert("검색할 상품을 입력해주세요.");
    }
    else{
        frm.method="get";
        frm.action="../shipment/shipmentPopList.do";
        frm.submit();
    }
}

//팝업 창닫기
function close_popup(){
    window.close();
}
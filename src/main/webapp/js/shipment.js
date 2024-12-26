//오더 일자별 검색 버튼
//let search_ck = false;
function search_shipment(){
    var start_date = search_frm.start_date.value;
    var end_date = search_frm.end_date.value;
    console.log(start_date);
    console.log(end_date);

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
            //상품 번호 배열에 저장
            pdcodes[index] = pd_check[i].getAttribute("value");
            index++;
        }
    }
    if(index == 0){
        alert("검색할 물품을 선택해주세요.");
    }
    else{
        console.log(pdcodes);
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

//물품 검색 팝업 물품 적용 버튼 클릭
function apply_product(pdidx, pdcode){
    console.log(pdidx);
    console.log(pdcode);
    var http, result;
    http = new XMLHttpRequest();
    http.onreadystatechange = function () {
        if (http.readyState === 4) { // 요청 완료
            if (http.status === 200) { // HTTP 상태 코드 확인
                try {
                    result = JSON.parse(http.responseText);
                    if(result.error){
                        alert(result.error);
                    }
                    else{
                        if(confirm(result.sname + " " + result.pdname + " 제품을 적용하시겠습니까?")){
                            var rows = window.opener.document.getElementsByClassName("shipment_row");
                            for (var i = 0; i < rows.length; i++) {
                                var checkbox = rows[i].querySelector("input[type='checkbox']");
                                console.log(checkbox);
                                if (checkbox.checked && pdcode == result.pdcode) {
                                    console.log("조건 통과:", result.sname, result.pname, result.scode, result.pcode);
                                    rows[i].querySelector("input[name='bstorage']").value = result.sname;
                                    rows[i].querySelector("input[name='bpalett']").value = result.pname;
                                    rows[i].querySelector("input[name='bstoragecode']").value = result.scode;
                                    rows[i].querySelector("input[name='bpalettcode']").value = result.pcode;

                                    rows[i].querySelector("input[name='bstorage']").readOnly = true;
                                    rows[i].querySelector("input[name='bpalett']").readOnly = true;

                                    console.log(rows[i].querySelector("input[name='bstorage']").value);

                                    //window.close();
                                }
                            }
                        }
                    }
                } catch (e) {
                    console.error("JSON 파싱 에러:", e.message, http.responseText);
                }
            } else {
                console.error("HTTP 요청 실패:", http.status, http.statusText);
            }
        }
    };
    http.open("post", "../shipment/apply_product.do", true);
    http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    http.send("pdidx=" + pdidx + "&pdcode=" + pdcode);
}

//팝업 창닫기
function close_popup(){
    window.close();
}

//체크한 주문 저장 - 개별 저장
function save_shipment(aidx){
    console.log(aidx);
    var bstorage = document.querySelector("input[name='bstorage']").value;
    var bpalett = document.querySelector("input[name='bpalett']").value;
    var bstoragecode = document.querySelector("input[name='bstoragecode']").value;
    var bstoragecode = document.querySelector("input[name='bstoragecode']").value;
    console.log(bstorage);
    console.log(bpalett);
    console.log(bstoragecode);
    console.log(bstoragecode);
}
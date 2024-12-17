//일자별 오더등록 검색 버튼 클릭 시
function search_order(){
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
            search_frm.action="../order/orderMain.do";
            search_frm.submit();
        }
    }
}

//EXCEL 등록 버튼 클릭 시
function insert_order(){
    var order_file = file_frm.order_file.value;
    if(order_file == ""){
        alert("EXCEL 파일을 첨부하셔야 합니다.");
    }else{
        console.log(order_file);
        file_frm.method="post";
        file_frm.action="../order/file_upload.do";
        file_frm.submit();
    }
}
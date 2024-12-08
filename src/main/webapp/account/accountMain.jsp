<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%> 


<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">거래처 리스트 현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">검색형식</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="text" name="" id="" style="width: 200px; height: 40px;" class="form-control font12" placeholder="거래처명을 입력하세요">
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>   
                <button type="button" class="btn btn-dark font12" style="width: 70px; height: 40px; margin-right: 10px;">전체</button> 
            </li>
        </ul> 
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="height: 30px;">NO</th>
                <th scope="col" style="width: 150px;">거래처명</th>
                <th scope="col" style="width: 100px;">거래처코드</th>
                <th scope="col" style="width: 150px;">사업자번호</th>
                <th scope="col" style="width: 100px;">대표자</th>
                <th scope="col" style="width: 100px;">연락처</th>
                <th scope="col" style="width: 100px;">업태</th>
                <th scope="col" style="width: 100px;">종목</th>
                <th scope="col" style="width: 400px;">주소</th>
                <th scope="col" style="width: 120px;">수정 / 삭제</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td>1</td>
                    <td>GS홈쇼핑</td>
                    <td>ACC123</th>
                    <td>81-23456-55245</td>
                    <td>홍길동</td>
                    <td>02-1234-5678</td>
                    <td>방송/엔터</td>
                    <td>전자상거래</td>
                    <td style="text-align: left;">(05632)서울시 영등포구 문래동 6가 GS타워 3F</td>
                    <td>
                        <ul class="btn_ul">
                            <li><button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;">수정</button>
                            </li>
                            <li>
                            <button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;">삭제</button> 
                            </li>
                            </ul>
                    </td>
                  </tr>
            </tbody>
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
      <div class="mb-3" style="text-align: right;">
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px;" onclick="location.href='./account_upload.jsp'">거래처 등록</button> 
      </div>
    </div>
  </div>
</main>  

<!-- Footer -->
<%@ include file="../footer.jsp"%>
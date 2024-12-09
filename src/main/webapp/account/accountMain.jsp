<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            
            
            <!-- 리스트 출력 파트 -->
            <tbody style="background-color: #f1f1ef;">
            <c:forEach var="account" items="${all}" varStatus="idx">
                <tr align="center" style="line-height: 30px;">
                    <td>${total - idx.index}</td>
                    <td>${account.acompany}</td>
                    <td>${account.acode}</th>
                    <td>${account.anum}</td>
                    <td>${account.aname}</td>
                    <td>${account.ahp}</td>
                    <td>${account.aindustry}</td>
                    <td>${account.atype}</td>
                    <td style="text-align: left;">(${account.apost}) ${account.aroad} ${account.addr}</td>
                    <td>
                        <ul class="btn_ul">
                            <li><button type="button" class="btn btn-dark font12"  style="width: 50px; height: 30px; margin-right: 10px;" onclick="location.href='./accountModify.do?aidx=${account.aidx}'">수정</button>
                            </li>
                            <li>
                            <button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;"onclick="accountDelete(${account.aidx})">삭제</button> 
                            </li>
                            </ul>
                    </td>
                  </tr>
            </c:forEach>
            </tbody>
            <!-- 리스트 출력 끝!! -->
            
            
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
      <div class="mb-3" style="text-align: right;">
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px;" onclick="location.href='./accountInsert.do'">거래처 등록</button> 
      </div>
    </div>
  </div>
</main>  
<script src="../js/accountMain.js?v=<%=sf.format(today)%>"></script>
<!-- Footer -->
<%@ include file="../footer.jsp"%>
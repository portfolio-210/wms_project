<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%> 


<main role="main" style="height: auto;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">배송기사별 배송현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">기사검색</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <select style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option>이름</option>
                    <option>사원번호</option>
                    <option>연락처</option>
                </select>
                <input type="text" style="width: 150px; height: 40px;" class="form-control font12">
                <button type="button" class="btn btn-success font12" style="width: 100px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>
                <button type="button" class="btn btn-primary font12" style="width: 100px; height: 40px; margin-right: 10px;">전체</button>
                <font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 검색된 기사에 한해서 배송현황을 확인 할 수 있습니다.</font>
            </li>
        </ul>  
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width: 50px;">번호</th>
                <th scope="col" style="width: 150px;">사원번호</th>
                <th scope="col" style="width: 120px;">배송 기사명</th>
                <th scope="col" style="width: 200px;">근무지역</th>
                <th scope="col" style="width: 100px;">배송완료</th>
                <th scope="col" style="width: 100px;">배송분실</th>
                <th scope="col" style="width: 130px;">근무현황</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td>1</td>
                    <td>M0122324</td>
                    <td>홍길동</td>
                    <td>본사</td>
                    <td>5</td>
                    <td>-</td>
                    <td>근무중</td>
                  </tr>
            </tbody>
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
    </div>
  </div>
</main>



<script src="../js/deliveryState.js?v=<%=sf.format(today)%>"></script>
<!-- Footer -->
<%@ include file="../footer.jsp"%>
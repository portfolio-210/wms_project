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
    <p class="sub_title font16_bold">배송현황 및 운송장 출력</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">오더 일자별 검색</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="date" style="width: 150px; height: 40px;" class="form-control font12">&nbsp;-&nbsp; 
                <input type="date" style="width: 150px; height: 40px;" class="form-control font12">
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>   
            </li>
        </ul>
        <ul class="ul-2">
            <li class="num_font13_bold">배송기사별 현황</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <select style="width: 150px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option>전체</option>
                    <option>홍길동</option>
                    <option>강감찬</option>
                </select>
                <button type="button" class="btn btn-success font12" style="width: 100px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button><font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 배송기사별로 할당된 오더를 확인 할 수 있습니다.</font>
            </li>
        </ul>  
        <ul class="ul-2">
            <li class="num_font13_bold">운송장</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <button type="button" class="btn btn-primary font12" style="width: 120px; height: 40px; margin-right: 10px;">운송장 생성</button><font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 체크된 오더에 한하여 운송장이 생성 됩니다.</font>
            </li>
        </ul>
        <ul class="ul-2">
            <li class="num_font13_bold">운송장 출력</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <button type="button" class="btn btn-warning font12" style="width: 120px; height: 40px; margin-right: 10px;">운송장 출력</button><font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 운송장이 적용된 오더에 한하여 운송장이 출력 됩니다. (QR 생성)</font>
            </li>
        </ul>
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width: 40px;"><input type="checkbox"></th>
                <th scope="col" style="width: 150px;">운송장번호</th>
                <th scope="col" style="width: 120px;">주문번호</th>
                <th scope="col" style="width: 200px;">상품명</th>
                <th scope="col" style="width: 100px;">상품코드</th>
                <th scope="col" style="width: 120px;">고객명</th>
                <th scope="col" style="width: 100px;">연락처</th>
                <th scope="col" style="width: 100px;">입력일자</th>
                <th scope="col" style="width: 100px;">기사명</th>
                <th scope="col" style="width: 100px;">QR출력</th>
                <th scope="col" style="width: 100px;">배송현황</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td><input type="checkbox"></td>
                    <td>-</td>
                    <td>630960421494</td>
                    <td>LG 냉장고</td>
                    <td>123456</td>
                    <td>홍길동</td>
                    <td>010123456789</td>
                    <td>2024-12-05</td>
                    <td>기사1</td>
                    <td>[QR보기]</td>
                    <td>대기</td>
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




<script src="../js/deliveryInsert.js?v=<%=sf.format(today)%>"></script>
<!-- Footer -->
<%@ include file="../footer.jsp"%>

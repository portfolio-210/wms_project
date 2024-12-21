<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>


<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%>   



 
<main role="main" style="height: auto;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">배송기사 배정</p>
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
            <li class="num_font13_bold">기사선택</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <select style="width: 200px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option>홍길동</option>
                    <option>강감찬</option>
                </select>
                <button type="button" class="btn btn-success font12" style="width: 100px; height: 40px; margin-left:10px; margin-right: 10px;">기사 선택 완료</button><font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 근무하고 있는 배송기사만 출력 됩니다.</font>
            </li>
        </ul>  
        <ul class="ul-2">
            <li class="num_font13_bold">기사배정 여부</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <label class="font12">
                <input type="radio" style="vertical-align: -2px;">&nbsp;기사배정 완료 오더
                </label>&nbsp;&nbsp;&nbsp;&nbsp;
                <label class="font12">
                <input type="radio" style="vertical-align: -2px;">&nbsp; 기사배정 미지정 오더
                </label>
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button><font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 기사배정 완료 오더와 미지정 오더 별로 확인 할 수 있습니다.</font>
            </li>
        </ul>
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width: 40px;"><input type="checkbox"></th>
                <th scope="col" style="width: 150px;">주문번호</th>
                <th scope="col" style="width: 150px;">상품명</th>
                <th scope="col" style="width: 100px;">상품코드</th>
                <th scope="col" style="width: 100px;">고객명</th>
                <th scope="col" style="width: 120px;">연락처</th>
                <th scope="col" style="width: 300px;">주소</th>
                <th scope="col" style="width: 100px;">입력일자</th>
                <th scope="col" style="width: 70px;">기사배정</th>
                <th scope="col" style="width: 70px;">삭제</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td><input type="checkbox"></td>
                    <td>630960421494</td>
                    <td>LG 냉장고</td>
                    <td>123456</td>
                    <td>홍길동</td>
                    <td>010123456789</td>
                    <td align="left">서울특별시 영등포구 당산1가 12-22</td>
                    <td>2024-12-05</td>
                    <td>N</td>
                    <td>
                        <button type="button" class="btn btn-danger font12" style="width: 60px; height: 30px;">삭제</button> 
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
    </div>
  </div>
</main>
<!-- Footer -->
<%@ include file="../footer.jsp"%>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/storeDlivery.js?v="<%= sf.format(today) %>></script>
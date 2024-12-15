<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>


<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%>   



 
<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">창고별 재고 현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">재고창고</li>
            <li style="display: flex;">
                <select style="width: 200px; height: 40px;" class="form-control font12">
                    <option>창고명 출력</option>
                   
                </select>
            </li>
            <li class="num_font13_bold">이동창고</li>
            <li>
                <select style="width: 200px; height: 40px;" class="form-control font12">
                    <option>창고명 출력</option>
                </select>
            </li>
        </ul> 
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width:30px; height: 30px;">
                    <input type="checkbox">
                </th>
                <th scope="col" style="width: 150px;">거래처명</th>
                <th scope="col" style="width: 260px;">상품명</th>
                <th scope="col" style="width: 110px;">상품코드</th>
                <th scope="col" style="width: 100px;">수량</th>
                <th scope="col" style="width: 180px;">창고명</th>
                <th scope="col" style="width: 120px;">파렛트명</th>
                <th scope="col" style="width: 100px;">출고수량</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td><input type="checkbox"></td>
                    <td>
                        NH 홈쇼핑
                    </td>
                    <td align="left">
                        LG 32인치 144Hz 게이밍 와이드 모니터
                    </td>
                    <td>
                        P_123456
                    </td>
                    <td>50 EA</td>
                    <td>수원창고1</td>
                    <td>P11</td>
                    <td>
                        <input type="text" style="width: 90px; height: 40px;" maxlength="5" class="form-control font12">
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
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px;">상품 창고 이동</button> 
      </div>
    </div>
  </div>
</main>
<!-- Footer -->
<%@ include file="../footer.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/storage.js?v="<%= sf.format(today) %>></script>
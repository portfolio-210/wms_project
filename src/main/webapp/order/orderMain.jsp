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
    <p class="sub_title font16_bold">오더등록 및 현황</p>
    <div class="mb-3" style="position: relative;">
        <form id="search_frm">
        <ul class="ul-2">
            <li class="num_font13_bold">오더등록 일자별</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="date" name="start_date" id="start_date" style="width: 150px; height: 40px;" class="form-control font12">&nbsp;-&nbsp;
                <input type="date" name="end_date" id="end_date" style="width: 150px; height: 40px;" class="form-control font12">
                <button type="button" onclick="search_order()" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>
            </li>
        </ul>
        </form>
        <form id="file_frm" enctype="multipart/form-data">
        <ul class="ul-2">
            <li class="num_font13_bold">EXCEL 오더등록</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="file" name="order_file" id="order_file" style="width: 400px; height: 40px; margin-right: 3px;" class="form-control font12">
                <button type="button" onclick="insert_order()" class="btn btn-success font12" style="width: 100px; height: 40px; margin-left:10px; margin-right: 10px;">EXCEL 등록</button>&nbsp;&nbsp;
                <a href="./shipping.xls" style="color:#333;" download="shipping.xls">※ EXCEL 샘플 [다운로드]</a>
            </li>
        </ul>
        <form>
        <ul class="ul-2">
            <li class="num_font13_bold">오더등록 건수</li>
            <li style="display: flex; flex-direction: row;">
                <span class="font14_bold">총 <font style="color:red;">0</font> 건</span>
            </li>
            <li class="num_font13_bold">거래처별 등록현황</li>
            <li>
                <select style="width: 200px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option>NH 홈쇼핑</option>
                    <option>GS 홈쇼핑</option>
                    <option>공영 홈쇼핑</option>
                </select>
            </li>
        </ul> 
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width: 40px;">번호</th>
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
                    <td>1</td>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/order.js?v=<%= sf.format(today) %>"></script>
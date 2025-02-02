
<%
	HttpSession sess = request.getSession(false);
	
if (session == null || 
	session.getAttribute("id") == null || 
	session.getAttribute("name") == null || 
	session.getAttribute("email") == null || 
	session.getAttribute("mpart") == null || 
	session.getAttribute("mhp") == null || 
	session.getAttribute("mspot") == null) {
	
%>
	<script>
	alert('비정상적인 접근입니다. 로그인 페이지로 이동합니다.');
    location.href = '/member/wmsLogin.jsp';
	</script>
<%
	return; 
	}

	String id = (String)sess.getAttribute("id");
	String name = (String)sess.getAttribute("name");
	String email = (String)sess.getAttribute("email");
	String mpart = (String)sess.getAttribute("mpart");
	String mspot = (String)sess.getAttribute("mspot");
	String mhp = (String)sess.getAttribute("mhp");

%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="/member/wmsMain.do">ADMINISTRATOR</a>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">입고관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../storage/storageInstore.do">상품입고</a>
          <a class="dropdown-item" href="../storage/storageList.do">재고 및 창고이동</a>
          <a class="dropdown-item" href="../storage/storagePalette.do">재고 팔레트 이동</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">오더관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="/order/orderMain.do">오더등록 및 현황</a>
          <a class="dropdown-item" href="/shipment/shipmentMain.do">배송선택(본사,지점)</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:160px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">창고 및 기사배정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../storage/storageMain.do">창고리스트</a>
          <a class="dropdown-item" href="../storage/storageInsert.do">창고등록</a>
          <a class="dropdown-item" href="../storeDelivery/storeDelivery.do">배송기사 배정</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:110px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">배송 관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../deliveryShip/deliveryShip.do">배송현황 및 운송장 출력</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:140px;">
        <a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-expanded="false">배송 기사관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../deliveryList/deliveryMain.do">배송기사 리스트</a>
          <a class="dropdown-item" href="../deliveryState/deliveryState.do">배송 기사별 배송현황</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">환경설정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../config/configMain.do">관리자 현황</a>
          <a class="dropdown-item" href="../office/officeMain.do">지점 현황</a>
          <a class="dropdown-item" href="../account/accountMain.do">거래처 현황</a>
          <a class="dropdown-item" href="../palette/paletteMain.do">팔레트 현황</a>
        </div>
      </li>

    </ul>
    
  	<span style="color: white; margin-right: 5px;">[<%=mpart%>]&nbsp;&nbsp;<a><%=name%></a> 님 환영합니다.</span>
     
	
	
	
      <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='/member/logout.do'">로그아웃</button>
  </div>
</nav>
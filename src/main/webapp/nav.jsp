
<%
	HttpSession sess = request.getSession(false);
	
if (session == null || 
	session.getAttribute("id") == null || 
	session.getAttribute("name") == null || 
	session.getAttribute("email") == null || 
	session.getAttribute("mpart") == null || 
	session.getAttribute("mspot") == null) {
	
%>
	<script>
	alert('비정상적인 접근입니다. 로그인 페이지로 이동합니다.');
    location.href = '/wmsLogin.jsp';
	</script>
<%
	return; 
	}

	String id = (String)sess.getAttribute("id");
	String name = (String)sess.getAttribute("name");
	String email = (String)sess.getAttribute("email");
	String mpart = (String)sess.getAttribute("mpart");
	String mspot = (String)sess.getAttribute("mspot");
	
	//out.print("　　　--세션값 참고하세요--　　　");
	//out.print("id("+ sess.getAttribute("id")+ ")　　");	//수원지점
	//out.print("name("+sess.getAttribute("name")+ ")　　");	// 이름
	//out.print("email("+sess.getAttribute("email")+ ")　　");	//이메일
	//out.print("mpart("+sess.getAttribute("mpart")+ ")　　"); // 본사
	//out.print("mspot("+sess.getAttribute("mspot")+ ")　　");	// 지점 이름
	//out.print("　>> 앞에있는값이 세션 id값입니다!!");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="/wmsMain.do">ADMINISTRATOR</a>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">입고관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">상품입고</a>
          <a class="dropdown-item" href="#">재고 및 창고이동</a>
          <a class="dropdown-item" href="#">재고 팔레트 이동</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">오더관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">오더등록 및 현황</a>
          <a class="dropdown-item" href="#">배송선택(본사,지점)</a>
          <a class="dropdown-item" href="#">반품처리</a>
          <a class="dropdown-item" href="#">취소처리</a>
          <a class="dropdown-item" href="#">교환반품/취소리스트</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:160px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">창고 및 기사배정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../storage/storageMain.do">창고리스트</a>
          <a class="dropdown-item" href="../storage/storageInsert.do">창고등록</a>
          <a class="dropdown-item" href="#">배송기사 배정</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:120px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">배송 관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">배송현황 및 운송장 출력</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:150px;">
        <a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-expanded="false">배송 기사관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../delivery/deliveryMain.jsp">배송기사 리스트</a>
          <a class="dropdown-item" href="#">배송 기사별 배송현황</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">환경설정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="../config/configMain.do">관리자 현황</a>
          <a class="dropdown-item" href="../office/officeMain.do">지점 현황</a>
          <a class="dropdown-item" href="../account/accountMain.do">거래처 현황</a>
          <a class="dropdown-item" href="../palette/paletteMain.do">팔레트 현황</a>
        </div>
      </li>
    </ul>
    
     <!-- <span style="color: white; margin-right: 5px;">[<%=mpart%>]&nbsp;&nbsp;<a href="#"><%=name%> (<%=id%>)</a> 님 환영합니다.</span> --> 
     	<cr:if test="${sessionScope.mpart == '본사'}">
    		<span style="color: white; margin-right: 5px;">[${mpart}]&nbsp;&nbsp;<a href="../config/configMain.do">${name} (${id})</a> 님 환영합니다.</span>
		</cr:if>

		<cr:if test="${sessionScope.mpart == '지점'}">
    		<span style="color: white; margin-right: 5px;">[${mspot}]&nbsp;&nbsp;<a href="../config/configMain.do">${name} (${id})</a> 님 환영합니다.</span>
		</cr:if>
	
	
	
      <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='/logout.do'">로그아웃</button>
  </div>
</nav>
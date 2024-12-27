

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%>   

   
<main role="main" style="height: 850px;">
  <div class="container">
    <div class="row">
  <!--입고현황-->
      <div class="ad_main">
        <div class="ad_main1">
           <ul>
              <li class="ad_maintitle font14">🌟🎄입고현황🎄🌟</li>
              <li class="ad_mainbox">
                <c:forEach var="p" items="${product}">
                 <ol>
                    <li class="bgcolor1">
                       ${p.lastmove} &gt; ${p.pdname}(${p.pdcode}) &gt; 
                       ${p.pdamount}EA &gt;${p.sname} &gt; ${p.pname} 
                    </li>
                 </ol>
                 </c:forEach>
              </li>
           </ul>
        </div>
     </div>
<!--입고현황 끝-->

  <!--배송현황-->
  <div class="ad_main">
    <div class="ad_main1">
       <ul>
          <li class="ad_maintitle font14">❤️🎄배송현황🎄❤️</li>
          <li class="ad_mainbox" style="display: flex; align-items: center;">                                     
             <select id="deliveryList" onfocus="this.size=5;" onblur="this.size=1;" onchange="Change(this.value); this.size=1; this.blur();" >
             <option value="">배송기사를 선택해주세요</option>
             <c:forEach var="d" items="${deliverymanList}">
             <option value="${d.dcode}"
             <c:if test="${d.dcode == param.z}">selected</c:if>>${d.dname} 기사님(${d.dspot})</option>
             </c:forEach>
             </select>
             <div style="margin-left: 40px; margin-top: 15px;">
             <c:choose>
		    <c:when test="${empty deliveryList}">
		        <p>현재 배송중인 배송건이 없습니다.</p>
		    </c:when>
		    <c:otherwise>
		        <c:forEach var="l" items="${deliveryList}"> 
		            <ol>
		                <li class="bgcolor1">
		                  주문번호 : ${l.aordercode} | 상품명 : ${l.aproduct} | 배송지 : ${l.addr} | 배송현황 : ${l.shipstate} | 📲 ${l.mobileck} 
		                </li>
		            </ol>
		        </c:forEach>
		    </c:otherwise>
		</c:choose>
		</div>
          </li>
       </ul>
    </div>
 </div>
<!--배송현황 끝-->

<!--배송현황-->
<div class="ad_main">
  <div class="ad_main1">
     <ul>
        <li class="ad_maintitle font14">🎅🏻신규등록 배송기사🎅🏻</li>
        <li class="ad_mainbox">
          <c:forEach var="m" items="${deliveryman}">
                 <ol>
                    <li class="bgcolor1">
                     🫅🏻 이름 : ${m.dname}( 사원코드 : ${m.dcode} ) | 
                          &#128222;  ${m.dhp} | 소속 : ${m.dspot} 
                    </li>
                 </ol>
          </c:forEach>
        </li>
     </ul>
  </div>
</div>
<!--배송현황 끝-->
    </div>

  </div> <!-- /container -->
</main>

<!-- Footer -->
<%@ include file="../footer.jsp"%>
<script>
function Change(z) {
    if (z != "") {
        // GET 방식으로 서버에 요청
        window.location.href = '/member/wmsMain.do?z=' + z;
    }
}
</script>

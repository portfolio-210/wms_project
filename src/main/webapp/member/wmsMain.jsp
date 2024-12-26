

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
              <li class="ad_maintitle font14">입고현황</li>
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
          <li class="ad_maintitle font14">배송현황</li>
          <li class="ad_mainbox">
             <ol>
                <li class="bgcolor1">
                  현재 등록된 배송 정보가 없습니다.
                </li>
             </ol>
          </li>
       </ul>
    </div>
 </div>
<!--배송현황 끝-->

<!--배송현황-->
<div class="ad_main">
  <div class="ad_main1">
     <ul>
        <li class="ad_maintitle font14">신규등록 배송기사</li>
        <li class="ad_mainbox">
           <ol>
              <li class="bgcolor1">
                현재 등록된 배송 기사 정보가 없습니다.
              </li>
           </ol>
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

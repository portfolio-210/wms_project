

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                 <ol>
                    <li class="bgcolor1">
                       본사창고 &gt; 컴퓨터5(a123459) &gt; 
                       5 EA &gt; 세종지점창고2 &gt; T-12 
                    </li>
                 </ol>
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

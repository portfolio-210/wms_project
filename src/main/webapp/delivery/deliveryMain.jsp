<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%> 

    
    

<main role="main" style="height: auto;">
<form id="f1">
<input type="hidden" name="dapprove" id="dapprove" value="">
<input type="hidden" name="didx" id="didx" value="">

</form>
  <div class="container">
    <div>
    <p class="sub_title font16_bold">배송기사 리스트[근무현황]</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">소속</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <select style="width: 200px; height: 40px;" class="form-control font12">
                    <option>전체</option>
                    <option>수원지점</option>
                    <option>인천지점</option>
                </select>
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>   
            </li>
        </ul>
        <ul class="ul-2">
            <li class="num_font13_bold">담당기사 검색</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <select style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option>기사명</option>
                    <option>사원번호</option>
                    <option>연락처</option>
                </select>
                <input type="text" style="width: 200px; height: 40px;" class="form-control font12" placeholder="검색할 단어를 입력하세요">
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>   
            </li>
        </ul> 
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width: 120px;">소속</th>
                <th scope="col" style="width: 100px;">기사명</th>
                <th scope="col" style="width: 100px;">사원번호</th>
                <th scope="col" style="width: 100px;">연락처</th>
                <th scope="col" style="width: 230px;">이메일</th>
                <th scope="col" style="width: 150px;">주민번호</th>
                <th scope="col" style="width: 100px;">증명사진</th>
                <th scope="col" style="width: 100px;">현황</th>
                <th scope="col" style="width: 70px;">수정</th>
              </tr>
            </thead>
            
            
            <tbody style="background-color: #f1f1ef;">
            
            
            <!-- 거래처가 없는경우 -->
             <c:if test="${empty all}">
		        <tr>
		            <td colspan="10" height="60px" align="center" style="color: #777; font-size: 14px; ">등록된 배송기사 리스트가 없습니다.</td>
		        </tr>
    		</c:if>
            
                    
            <c:forEach var="delivery" items="${all}" varStatus="idx">
                <tr align="center" style="line-height: 30px;">
                    <td>${delivery.dspot}</td>
                    <td>${delivery.dname}</td>
                    <td>${delivery.dcode}</td>
                    <td>${delivery.dhp}</td>
                    <td>${delivery.demail}</td>
                    <td>${delivery.didnum}******</td>
                    <td>
                    	<c:choose>
        					<c:when test="${delivery.dimgck == 'N'}">미등록</c:when>
        					<c:otherwise>등록완료</c:otherwise>
    					</c:choose>
                    </td>
                    
          
                    <td>
                        <select name="approve" id="approve" style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12" onchange="approveCk(this, ${delivery.didx})">
                            <option value="근무중"<c:if test="${delivery.dapprove == '근무중'}">selected</c:if>>근무중</option>
                            <option value="일시정지"<c:if test="${delivery.dapprove == '일시정지'}">selected</c:if>>일시정지</option>
                            <option value="퇴사"<c:if test="${delivery.dapprove == '퇴사'}">selected</c:if>>퇴사</option>
                        </select>
                    </td>
                    
                    <td>
                        <button type="button" class="btn btn-success font12" style="width: 60px; height: 30px;">수정</button> 
                    </td>
                  </tr>
              </c:forEach>
  					
            </tbody>
          </table>
     </div>
     
     <div class="mb-3">
        <ul class="pageing">
        <c:set var="pages" value="${total / 15 + (1 - (total / 15) % 1)}"/>
        <c:forEach var="no" begin="1" end="${pages}" step="1">
          <li onclick="page_go(${no})" style="cursor: pointer;">${no}</li>
         </c:forEach>
        </ul>
      </div>
     
      <div class="mb-3" style="text-align: right;">
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px;" onclick="deliveryInsert()">배송기사 등록</button> 
      </div>
    </div>
  </div>
</main>
<script>
                        
                        	
                  
                        
                        </script>
<script src="../js/deliveryMain.js?v=<%=sf.format(today)%>"></script>
<!-- Footer -->
<%@ include file="../footer.jsp"%>

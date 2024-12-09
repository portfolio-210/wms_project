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
    <p class="sub_title font16_bold">창고 수정</p>
    <form id="frm" method="post" onsubmit="return update12();">
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">창고코드</li>
            <li style="display: flex; flex-direction: row;">
                <input type="text" style="width: 150px; height: 40px;" class="form-control font12" maxlength="5" readonly> <font style="font-size: 12px; color: red;">&nbsp;&nbsp;※ 변경 불가능</font>
            </li>
            <li class="num_font13_bold">창고명</li>
            <li style="display: flex; flex-direction: row;">
                <input type="text" style="width: 250px; height: 40px;" class="form-control font12" maxlength="5" placeholder="창고명을 입력해 주세요">
            </li>
        </ul> 
     </div>
     <div>
        <div class="mb-3" style="position: relative;">
        <ul class="ul-2" style="margin-bottom: 5px;">
            <li class="num_font13_bold">지점위치</li>
            <li style="width:85%; display: flex; flex-direction: row;">
                <input style="width: 180px; height: 40px;" class="form-control font12" readonly>
            </li>
        </ul>
        </div> 
        <div class="mb-3" style="position: relative;">
            <ul class="ul-1" style="margin-top: 5px;">
                <li class="num_font13_bold">주소찾기</li>
                <li style="width: 85%; display: flex; flex-direction: row;">
                    <input type="text" style="width: 100px; height: 40px; margin-right: 5px;" maxlength="5" class="form-control font12" readonly>
                    <button type="button" class="btn btn-secondary font12" style="width: 100px; height: 40px;">
                        주소찾기
                    </button>
                </li>
                <li></li>
                <li></li>
            </ul> 
            <ul class="ul-1" style="margin-bottom: 5px;">
                <li class="num_font13_bold">도로명 주소</li>
                <li>
                    <input type="text" style="height: 40px;" class="form-control font12" readonly>
                </li>
                <li class="num_font13_bold">상세주소</li>
                <li>
                    <input type="text" style="height: 40px;" class="form-control font12" placeholder="상세주소를 입력하세요">
                </li>
            </ul> 
            <ul class="ul-1" style="margin-bottom: 5px;">
                <li class="num_font13_bold">담당자명</li>
                <li>
                    <input type="text" style="height: 40px;" class="form-control font12" placeholder="담당자명을 입력하세요">
                </li>
                <li class="num_font13_bold">담당자 연락처</li>
                <li>
                    <input type="text" style="height: 40px;" class="form-control font12" placeholder="담당자 연락처를 입력하세요">
                </li>
            </ul>
            <ul class="ul-1" style="margin-bottom: 5px;">
                <li class="num_font13_bold">사용 유/무</li>
                <li>
                    <label style="margin-right: 40px;">
                        <input type="radio" style="vertical-align:-2px; width: 15px; height:15px;"> 사용중
                    </label>
                    <label>
                        <input type="radio" style="vertical-align:-2px; width: 15px; height:15px;"> 미사용중
                    </label>
                </li>
                <li class="num_font13_bold"></li>
                <li>
                    
                </li>
            </ul>
        </div>
      <div class="mb-3" style="text-align: right;">
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px; margin-right: 5px;">수정완료</button> 
      <button type="button" onclick="back1()" class="btn btn-dark font12" style="width: 100px; height: 40px;">취소하기</button> 
      </div>
      </form>
    </div>
  </div>
</main>

<!-- Footer -->
<%@ include file="../footer.jsp"%>
<script src="../js/storage.js?v=<%= sf.format(today) %>"></script>


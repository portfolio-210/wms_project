<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%>   

<script src="../storage.js?v="<%= sf.format(today) %>></script>

<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">창고 리스트 현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">검색형식</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="text" style="width: 200px; height: 40px;" class="form-control font12" placeholder="창고명을 입력하세요">
                <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>   
                <button type="button" class="btn btn-dark font12" style="width: 70px; height: 40px; margin-right: 10px;">전체</button> 
            </li>
        </ul> 
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="height: 30px;">NO</th>
                <th scope="col" style="width: 120px;">창고코드</th>
                <th scope="col" style="width: 150px;">창고명</th>
                <th scope="col" style="width: 330px;">주소</th>
                <th scope="col" style="width: 120px;">담당자</th>
                <th scope="col" style="width: 150px;">사용 유/무</th>
                <th scope="col" style="width: 150px;">수정 / 삭제</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
                <tr align="center" style="line-height: 30px;">
                    <td colspan="7">등록된 창고가 없습니다.</td>
                </tr>
                <tr align="center" style="line-height: 30px;">
                    <td>1</td>
                    <td>S7391</td>
                    <td>세종 남구대리점 창고1</th>
                    <td>(30151) 세종특별자치시 한누리대로 215499-2 1F</td>
                    <td>홍길동</td>
                    <td>Y</td>
                    <td>
                        <ul class="btn_ul">
                            <li>
                            <button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;">수정</button>
                            </li>
                            <li>
                            <button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;">삭제</button> 
                            </li>
                        </ul>
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
      <button type="button" class="btn btn-danger font12" style="width: 100px; height: 40px;">창고 등록</button> 
      </div>
    </div>
  </div>
</main>

<!-- Footer -->
<%@ include file="../footer.jsp"%>
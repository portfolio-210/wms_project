<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Header -->
<cr:import url="../header.jsp"/>
<!-- Nav -->
<cr:import url="../nav.jsp"/>


<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">파렛트 리스트 현황</p>
    <div class="mb-3" style="position: relative;">
        <form id="frm">
        <ul class="ul-2">
            <li class="num_font13_bold">검색형식</li>
            <li style="width: 85%; display: flex; flex-direction: row;">
                <input type="text" name="search" style="width: 200px; height: 40px;" class="form-control font12" placeholder="파렛트명을 입력하세요">
                <button type="button" onclick="searchPalette()" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;">검색</button>
                <button type="button" onclick="searchAllPalette" class="btn btn-dark font12" style="width: 70px; height: 40px; margin-right: 10px;">전체</button>
            </li>
        </ul>
        </form>
     </div>
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="height: 30px;">NO</th>
                <th scope="col" style="width: 200px;">파렛트명</th>
                <th scope="col" style="width: 150px;">파렛트 코드</th>
                <th scope="col" style="width: 240px;">사이즈</th>
                <th scope="col" style="width: 150px;">색상</th>
                <th scope="col" style="width: 150px;">사용 유/무</th>
                <th scope="col" style="width: 150px;">수정 / 삭제</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">

            <!-- palette 리스트 출력 시작 -->

                <tr align="center" style="line-height: 30px;">
                    <td>1</td>
                    <td>T-12</td>
                    <td>P0002</th>
                    <td>1300 x 1100 x 3(70R)</td>
                    <td><div class="palette_box" style="background-color: #000000;"></div></td>
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

            <!-- palette 리스트 출력 시작 -->

            </tbody>
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
      <div class="mb-3" style="text-align: right;">
      <button type="button" class="btn btn-danger font12" onclick="" style="width: 100px; height: 40px;">파렛트 등록</button>
      </div>
    </div>
  </div>
</main>


<!-- 스크립트 자동 업데이트 -->
<script src="../js/palette.js?=${sf.format(today)}"></script>
<!-- Footer -->
<cr:import url="../footer.jsp"/>
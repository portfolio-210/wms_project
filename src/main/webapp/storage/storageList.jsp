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
    <p class="sub_title font16_bold">창고별 재고 현황</p>
    <div class="mb-3" style="position: relative;">
       <form action="/storage/storageList.do" method="get">
        <ul class="ul-2">
            <li class="num_font13_bold">재고창고</li>
            <li style="display: flex;">
                <select name="selectstorage" onchange="this.form.submit()" style="width: 200px; height: 40px;" class="form-control font12">
                    <option value="">창고명 출력</option>
                    <c:forEach var="storagefrom" items="${members}">
                    <option value="${storagefrom.scode}">${storagefrom.sname}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="num_font13_bold">이동창고</li>
            <li>
                <select name="storageto" id="storageto" onchange="updateHiddenField(this)" style="width: 200px; height: 40px;" class="form-control font12">
                    <option value="">창고명 출력</option>
                    <c:forEach var="storageto" items="${membersall}">
                    <option value="${storageto.scode}" data-storagename="${storageto.sname}">${storageto.sname}</option>
                    </c:forEach>
                </select>
            </li>
        </ul>
        </form> 
     </div>
     <form id="productfrom" action="/storage/moveProduct.do" method="post" onsubmit="return collectCheckedData();">
     <input type="hidden" id="Name" name="Name" value="">
     <input type="hidden" id="to" name="to" value="">
     <div class="mb-3">
        <table class="table font12">
            <thead>
              <tr align="center" style="line-height: 30px;">
                <th scope="col" style="width:30px; height: 30px;">
                    <input type="checkbox" id="selectAll" onclick="toggleAll(this)">
                </th>
                <th scope="col" style="width: 150px;">거래처명</th>
                <th scope="col" style="width: 260px;">상품명</th>
                <th scope="col" style="width: 110px;">상품코드</th>
                <th scope="col" style="width: 100px;">수량</th>
                <th scope="col" style="width: 180px;">창고명</th>
                <th scope="col" style="width: 120px;">파렛트명</th>
                <th scope="col" style="width: 100px;">출고수량</th>
              </tr>
            </thead>
            <tbody style="background-color: #f1f1ef;">
            <c:forEach var="products" items="${product}">
                <tr align="center" style="line-height: 30px;">
                    <td><input type="checkbox" name="checkbox" value="${products.pdidx}" class="product-checkbox"></td>
                    <td>${products.acompany}</td>
                    <td align="left">${products.pdname}</td>
                    <td>${products.pdcode}</td>
                    <td>${products.pdamount}EA</td>
                    <td>${products.sname}</td>
                    <td>${products.pname}</td>
                    <td><input type="text" name="quantity" oninput="this.value = this.value.replace(/[^0-9]/g, '');" style="width: 90px; height: 40px;" maxlength="5" class="form-control font12" ></td>
                  </tr>
               </c:forEach>
            </tbody>
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
      <div class="mb-3" style="text-align: right;">
      <button type="submit" class="btn btn-danger font12" style="width: 100px; height: 40px;">상품 창고 이동</button> 
      </div>
      </form>
    </div>
  </div>
</main>
<!-- Footer -->
<%@ include file="../footer.jsp"%>

<script>
function toggleAll(source) {
    const checkboxes = document.querySelectorAll('.product-checkbox');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = source.checked; // 전체 선택 체크박스의 상태로 설정
    });
}
function updateHiddenField(selectElement) {
	
	
    // 선택된 option의 value를 히든 필드에 설정
    document.getElementById('to').value = selectElement.value;
    
 // 선택된 option의 data-storagename 속성 값을 히든 필드에 설정
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    const storageName = selectedOption.getAttribute('data-storagename');
    document.getElementById('Name').value = storageName;
    console.log('name='+ Name.value);
    console.log('to='+to.value);
}
</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/storage.js?v="<%= sf.format(today) %>></script>
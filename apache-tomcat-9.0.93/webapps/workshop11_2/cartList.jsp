<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<h2 align="center">장바구니</h2>
	<a href="#" align="right">쇼핑 계속하기</a>

	<div id="cart-container">
		<!-- 장바구니 데이터가 여기 동적으로 들어갑니다 -->
	</div>

	<script type="text/javascript">
        $(function() {
            if (localStorage.length > 0) {
                let result = `
                    <table id="fruitTable" align="center" class="table table-striped">
                        <thead>
                            <tr style="text-align: center">
                                <th>번호</th>
                                <th>상품이미지</th>
                                <th>상품명</th>
                                <th>상품가격</th>
                                <th>수량</th>
                				<th><button class="btn btn-light" id="delete">삭제</button></th>
                            </tr>
                        </thead>
                        <tbody id="cartList">`;
                
                for (let i = 0; i < localStorage.length; i++) {
                    let key = localStorage.key(i);
                    let item = JSON.parse(localStorage.getItem(key));
                    
                    console.log(item);
                    console.log(key);
                    
                    console.log(item.url);
                    console.log(item.price);

                    result += `<tr>`;
                    
	                result += "<td>" + (i+1) + "</td>";
	                result += "<td><img src= " + item.url +"></td>";
                    result += `<td>` +item.name +`</td>`;
                    result += `<td class="prod-price">` +item.price +`</td>`;
                    result += `<td> <input type="button" class="button-plus" onclick='count(this, "plus")' value="+" />
                        <div class="prod-quantity">0</div>
                        <input type="button" class="button-minus" onclick='count(this, "minus")' value="-" /></td>`;
                    result += `<td><input type="checkbox" id="fruit-checkbox"></td>`;
                    result += `</tr>`;
                }

                result += `
                        </tbody>
                        <tfoot>
                            <tr>
                            <tr>
                           	 <td colspan="6" id="totalPrice" style="text-align: right">0</td>
                            </tr>
                        </tfoot>
                    </table>`;

                $('#cart-container').html(result);

            } else {
                $('#cart-container').html('<h3 style="text-align: center">장바구니에 담긴 값이 없습니다.</h3>');
            }

            // 삭제 버튼 클릭 이벤트 처리
            $(document).on('click', '.delete-btn', function() {
                let key = $(this).data('key');
                localStorage.removeItem(key);
                location.reload();  // 페이지를 새로고침하여 장바구니를 업데이트
            });
            
         // 삭제 버튼 클릭 시 선택된 항목 삭제
            $('#delete').on('click', function() {
                // 체크된 항목들 가져오기
                $('#fruitTable tbody tr').each(function() {
                    let $row = $(this);
                    let isChecked = $row.find('#fruit-checkbox').is(':checked');
                    // 체크박스가 체크된 경우 삭제
                    if (isChecked) {
                        let itemId = $row.data('id');  // tr 태그의 data-id 속성에서 가져옴
                        // 로컬스토리지에서 해당 항목 삭제
                        localStorage.removeItem(itemId);
                        // 테이블에서 해당 행 삭제
                        $row.remove();
                        updateTotalPrice();
                    }
                });
            });
            
        });
    </script>
</body>
<script>
    function count(button, type) {
        // 버튼이 속한 행의 모든 요소를 찾음
        const row = button.closest('tr');
        
        // 현재 행의 수량과 가격 요소 찾기
        const prodQuantity = row.querySelector(".prod-quantity");
        const prodPrice = row.querySelector(".prod-price").innerText;
        
        // 현재 화면에 표시된 값
        let currentNum = parseInt(prodQuantity.innerText);
        
        // 더하기/빼기
        if (type === "plus") {
            currentNum++;
        } else if (type === "minus" && currentNum > 0) {
            currentNum--;
        }
        
        // 결과 출력
        prodQuantity.innerText = currentNum;
        
        // 전체 가격 계산 및 업데이트
        updateTotalPrice();
    }
    
    function updateTotalPrice() {
        let totalPrice = 0;
        
        // 모든 행을 반복
        document.querySelectorAll('tr').forEach(row => {
            const prodQuantity = row.querySelector(".prod-quantity");
            const prodPrice = row.querySelector(".prod-price");
            
            if (prodQuantity && prodPrice) {
                const quantity = parseInt(prodQuantity.innerText);
                const price = parseInt(prodPrice.innerText);
                totalPrice += quantity * price;
            }
        });
        
        // 총 가격 업데이트
        document.getElementById("totalPrice").innerText = "총가격 : "+totalPrice;
    }
</script>
</html>
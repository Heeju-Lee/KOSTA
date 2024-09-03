<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#serverSend').on('click',()=>{
			$.ajax({
				type:'get',
				url:'http://localhost:8888/weather.xml',
				//dataType_서버에서 응답하는 데이타 타입을 미리 알려주는 속성이다.
				//꼭 쓰지 않아도 되지만 특이한 데이타 타입일 때만 지정해준다.(ex) xml, json)
				//응답할 때지만 요청할 때 속성을 써준다.
				dataType: 'xml',
				
				success: function(result){
					//alert(result);
					let str = '';
					$(result).find('list').each(function(index, item){
						let region = $(this).find('region').text();
						let wind = $(this).find('wind').text();
						let rain = $(this).find('rain').text();
						let temp = $(this).find('temp').text();
						
						str +='<tr>';
						str +='<td>'+region+'</td>'
						str +='<td>'+wind+'</td>'
						str +='<td>'+rain+'</td>'
						str +='<td>'+temp+'</td>'
						str +='</tr>';
					});//each (this = list)
					//$<'tbody'>.html(str); //1
					$('tbody>tr*').remove(); //3 one을 사용안한다면 이 부분을 지정하고 사용
					$('tbody').append(str); //2 one을 쓰면 된다.
				}//callback
			});//ajax
		});//on
	});//ready
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h2>Open API Weather 데이타 가져오기</h2>
		</div>
		<p>
			<a href="#" id="serverSend">XML 데이타 서버로 요청하기 </a>
		</p>
	<table class="table table-hover text-center">
			<thead class="thead-dark">
				<tr>
					<th>REGION</th>
					<th>WIND</th>
					<th>RAIN</th>
					<th>TEMP</th>
				</tr>
			</thead>
			<tbody>
				<!-- 이 부분에 공공데이타 XML의 태그안의 내용이 출력 $.each -->
				<!-- xml은 반복되는 부분을 찾아야 함 -->
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#AjaxBtn').on('click',()=>{
			let id = $('#userId').val();
			
			//비동기 시작
			$.ajax({
				type: 'post',
				url: './members.json',//같은 곳에 있음
				data: {'id':id},
				
				success: function(result){
					//alert(result);
					let members = result.members;
					//let str = '';
					
					$.each(members, function(index, item){
						//str += item.id;
						$('#resultScope')
							.append('<h3><font color=crimson>'+item.id+'</font></h3>');
					});
					//alert(str);					
				}//callback
				
			});//ajax
			
		});//ajaxbtn on click
		
		
	});
</script>
</head>
<body>

<h3>Form에 입력된 값 서버로 보내고 서버에서 보낸값 받아서 페이지 부분갱신</h3>
ID <input type="text" name="userId" id="userId">
<input type="button" value="AjaxBtn" id="AjaxBtn"> 

<div id="resultScope"></div>
</body>
</html>

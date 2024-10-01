<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#idCheck').on('click',()=>{
			let id = $('#userId').val();
			$.ajax({
				//front.do?command=idCheck
				type: 'post',
				url: 'front.do?command=idCheck',//���� ���� ����
				data: {'userId': id},				
				//result�� �޾Ƽ�...true / false ���
				success:function(result){
					
					alert(result);
					//resultView������ ������� id(������) / ��밡���� id(�Ķ���)
					if(result=='true'){
						$('#resultView')
						.html('<h3><font color=crimson>'+id+' �� ������� ���̵��Դϴ�.</font></h3>');
					}
					else{
						$('#resultView')
						.html('<h3><font color=blue>'+id+' �� ��밡���� ���̵��Դϴ�.</font></h3>');
					}				
					
				}//callback

				
			});//ajax
		});//on		
	});
</script>
</head>
<body>
	<h2>ȸ������</h2>
	<form action="register.do" method="post">
		ID <input type="text" name="id" required="required" id="userId"> 
		<input type="button" value="�ߺ�Ȯ��" id="idCheck">
		<span id="resultView"></span>
		<br>
 		PASS <input type="password" name="password" required="required"><br> 
		NAME <input	type="text" name="name"><br>
		ADDR <input type="text"	name="address"><br>
		<input type="submit" value="Register"><br>
	</form>
</body>
</html>
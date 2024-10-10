<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function Login(){
		if(document.loginFrm.user.value==""){
			alert("ID를 입력하세요");
			document.loginFrm.user.focus();
		}else if(document.loginFrm.pass.value==""){
			alert("PASSWORD를 입력하세요");
			document.loginFrm.pass.focus();
		}else{
			document.loginFrm.submit();
		}
	}
</script>
</head>
<body>
<table width="100%" height="100%">
	<tr>
		<td align="center">
		<table border="4" width="434" height="180">
			<tr><td align="center">
			<table width="400" height="180">
				<tr>
				<td width=107><img src="image/book.bmp" border="0"></td>
				<td width=281 height="150">
				
					<!--  폼 입력..-->
					
					<form method="post" action="memberLogin.do" name="loginFrm">
					<center><font size="3" face="굴림">입력하세요</font></center>
					<p><p><p>
					<table align="center">
						<tr>
							<td><img src="image/id_id.gif" border="0"></td>
							<td><input type="text" name="user" class="input" onkeypress="if (event.keyCode==13) Login();" style="width:120;height:20;"></td>
						</tr>
						<tr>
							<td><img src="image/id_pass.gif" border="0"></td>
							<td><input type="password" name="pass" class="input" onkeypress="if (event.keyCode==13) Login();" style="width:120;height:20;"></td>
						</tr>
					<tr/><tr>
					<td></td>
					<td height="5" background="image/line.gif"></td>
					</tr><tr>
					<td></td>
					<td><a href="Javascript:Login();"><img src="image/butt_login.gif" border="0" width="80" height="25"></a></td>
					</tr>
					</table>
					</form>
					
						
				</td></tr></table>
		</td></tr></table>
</body>
</html>
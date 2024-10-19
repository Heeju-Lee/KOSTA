<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>도서 등록 - ENCORE</title>
	<META http-equiv="Content-Type" content="text/html;charset=utf-8">

	<script>
	function confirmation(){
		if(isbn1.value.length!=4){
			alert ("도서번호1 길이를 잘못 입력하였습니다.");
			isbn1.focus();
			return;
		}
		if(isbn2.value.length!=3){
			alert ("도서번호2 길이를 잘못 입력하였습니다.");
			isbn2.focus();
			return;
		}
		if(isbn3.value.length!=3){
			alert ("도서번호3 길이를 잘못 입력하였습니다.");
			isbn3.focus();
			return;
		}		
		//도서종류 선택 확인	
		catalogue=document.getElementById("catalogue");
		if(catalogue.value=='NONE'){
			alert("도서종류를 선택하십시요.");
			catalogue.focus();
			return;
		}
	
		bookForm.submit();
	}

	/*************************************************************************
    취소 버튼을 누르면 폼데이터 초기화
	**************************************************************************/
	function formReset() {
		bookForm.reset();
		bookForm.isbn1.focus();
	}

	</script>
<style type="text/css">
h4  {
	text-align: center;
}
.isbn {
	width: 50px;
}
</style>
</head>

<body >

<!--도서등록 타이틀 테이블 시작//-->
<table width="650" cellpadding="0" cellspacing="0"  align="center" >
	<tr bgcolor="#E3E3E3">
		<td width="700"  valign="middle" >
			<center><h2>도서 등록 화면</h2></center>
		</td>
	</tr>
</table>
<!--도서등록 타이틀 끝//-->

<p>
<c:if test="${not empty user }">
<h4>${user.name} 님 로그인 되었습니다. <a href="memberLogout.do">로그아웃</a></h4>
</c:if>
<!--도서정보입력 FORM 테이블시작//-->
<FORM METHOD="post" action="bookRegister.do" name="bookForm" id="bookForm">

	<!--도서아이디정보 입력 테이블 시작//-->
	<Table cellpadding="0" cellspacing="1" border="0" width="650" bgcolor="#EAEAEA" align="center">
		<!-- 필수입력필드표기 -->
		<tr>
			<td width="650" bgcolor="#FFFFFF" height="35"  valign="middle" align="right" colspan="2">
				<img src=".\image\star_orange.gif" hspace="7" vspace="3">표시가 된 항목은 필수 입력 항목입니다.
			</td>
		</tr>	
		<tr>
			<td width="650" bgcolor="#F3F3F3" height="35" colspan="2">
			</td>
		</tr>
		<!--도서번호 입력-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src=".\image\star_orange.gif" hspace="7" vspace="3">도서번호
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
				<input type="number" name="isbn1"  id="isbn1"  class="isbn" MAXLENGTH="4" required="required"    tabindex="1">-
				<input type="number" name="isbn2"  id="isbn2"  class="isbn"	MAXLENGTH="3" required="required"   tabindex="2">-
				<input type="number" name="isbn3"  id="isbn3"  class="isbn" MAXLENGTH="3" required="required"   tabindex="3">
			</td>			
		</tr>	
		<!--도서제목-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src=".\image\star_orange.gif" hspace="7" vspace="3">도서제목
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="text" name="title"  id="title" size="50" MAXLENGTH="50" tabindex="4" required="required" >&nbsp;
			</td>			
		</tr>	
		<!--도서종류-->
	    <tr>    
          <td  bgcolor="#FFFFFF" height="35" width="120" valign="middle">  
			<img src=".\image\star_orange.gif" hspace="7" vspace="3" >도서종류
		  </td>  
          <td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;  
				<select NAME="catalogue" id="catalogue" tabindex="5">
				<option value="NONE">해당 항목을 선택하세요</option>
				<option value="프로그래밍">프로그래밍</option>
				<option value="운영체제">운영체제</option>
				<option value="데이터베이스">데이터베이스</option>
				<option value="네트워크">네트워크</option>
				</select>
		   </td>
        </tr>   
		<!--출판국가-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120">
				<img src=".\image\square_gray.gif" hspace="7" vspace="3">&nbsp;출판국가
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
				<input type="radio" name="nation" value="국내" checked   tabindex="6">국내도서
				<input type="radio" name="nation" value="외국">외국도서
			</td>			
		</tr>	
		<!--출판일-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120">
				<img src=".\image\square_gray.gif" hspace="7" vspace="3">&nbsp;출&nbsp;판&nbsp;일
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type='text' name='publishDate' id="publishDate" size='15'   tabindex="7"> 
			</td>
		</tr>
		<!--출판사 -->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120">
				<img src=".\image\square_gray.gif" hspace="7" vspace="3">&nbsp;출&nbsp;판&nbsp;사
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
			<SELECT name='publisher' id="publisher" tabindex="10">
						<option value="NONE">해당 항목을 선택하세요</option>
						<option value='영진출판사'>영진출판사</option>
						<option value='한빛미디어'>한빛미디어</option>
						<option value='자앤미디어'>자앤미디어</option>
						<option value='멀티캠퍼스'>멀티캠퍼스</option>
			</SELECT>
			</td>			
		</tr>	
		<!-- 저자 -->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src=".\image\star_orange.gif" hspace="7" vspace="3">저&nbsp;&nbsp;&nbsp;&nbsp;자
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="text" name="author" id="author" size="10" MAXLENGTH="50" tabindex="11">&nbsp;
			</td>			
		</tr>	

		<!-- 도서가격 -->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src="./image\square_gray.gif" hspace="7" vspace="3">&nbsp;도서가격
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="number" name="price" id="price" size="10" MAXLENGTH="6" tabindex="12">&nbsp;
				<select name="currency" id="currency" tabindex="13">
					<option value="원" selected>원</option>
					<option value="달러">달러</option>
				</select>
			</td>			
		</tr>	
	
		<!--요약내용-->
		<tr>
			<td bgcolor="#FFFFFF" height="60" width="120">
				<img src=".\image\square_gray.gif" hspace="7" vspace="3">&nbsp;요약내용
			</td>
			<td>&nbsp;&nbsp;
				<TEXTAREA NAME="description" id="description" ROWS="3" COLS="50" tabindex="14"></TEXTAREA>
			</td>			
		</tr>	
	</table>
	<!--기본입력 테이블 끝//-->

	<br>
	<Table cellpadding="0" cellspacing="1" border="0" width="650" bgcolor="#EAEAEA" align="center">
		<tr>
			<td align="center" height="30" valign="middle">
				<a href="javascript:confirmation()"><img src=".\image\ok.gif" width="64" height="29" vspace="12" hspace="2" alt="확인"  border="0"  border="0"></a>
				<a href="javascript:formReset()"><img src=".\image\cancel.gif" width="64" height="29" vspace="12" hspace="2" alt="취소"  border="0" ></a>
			</td>
		</tr>
	</table>
</FORM>
<!--정보입력 테이블끝//-->


<CENTER>
<FONT COLOR="NAVY" SIZE="2" FACE="굴림체">
사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터<BR> 
Copyright ⓒ 2021 HABAREE. All Rights Reserved.
</FONT>
</CENTER>
</body>
</html>
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-06 04:45:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cartList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<h2 align=\"center\">장바구니</h2>\r\n");
      out.write("	<a href=\"#\" align=\"right\">쇼핑 계속하기</a>\r\n");
      out.write("\r\n");
      out.write("	<div id=\"cart-container\">\r\n");
      out.write("		<!-- 장바구니 데이터가 여기 동적으로 들어갑니다 -->\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("        $(function() {\r\n");
      out.write("            if (localStorage.length > 0) {\r\n");
      out.write("                let result = `\r\n");
      out.write("                    <table id=\"fruitTable\" align=\"center\" class=\"table table-striped\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr style=\"text-align: center\">\r\n");
      out.write("                                <th>번호</th>\r\n");
      out.write("                                <th>상품이미지</th>\r\n");
      out.write("                                <th>상품명</th>\r\n");
      out.write("                                <th>상품가격</th>\r\n");
      out.write("                                <th>수량</th>\r\n");
      out.write("                				<th><button class=\"btn btn-light\" id=\"delete\">삭제</button></th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody id=\"cartList\">`;\r\n");
      out.write("                \r\n");
      out.write("                for (let i = 0; i < localStorage.length; i++) {\r\n");
      out.write("                    let key = localStorage.key(i);\r\n");
      out.write("                    let item = JSON.parse(localStorage.getItem(key));\r\n");
      out.write("                    \r\n");
      out.write("                    console.log(item);\r\n");
      out.write("                    console.log(key);\r\n");
      out.write("                    \r\n");
      out.write("                    console.log(item.url);\r\n");
      out.write("                    console.log(item.price);\r\n");
      out.write("\r\n");
      out.write("                    result += `<tr>`;\r\n");
      out.write("                    \r\n");
      out.write("	                result += \"<td>\" + (i+1) + \"</td>\";\r\n");
      out.write("	                result += \"<td><img src= \" + item.url +\"></td>\";\r\n");
      out.write("                    result += `<td>` +item.name +`</td>`;\r\n");
      out.write("                    result += `<td class=\"prod-price\">` +item.price +`</td>`;\r\n");
      out.write("                    result += `<td> <input type=\"button\" class=\"button-plus\" onclick='count(this, \"plus\")' value=\"+\" />\r\n");
      out.write("                        <div class=\"prod-quantity\">0</div>\r\n");
      out.write("                        <input type=\"button\" class=\"button-minus\" onclick='count(this, \"minus\")' value=\"-\" /></td>`;\r\n");
      out.write("                    result += `<td><input type=\"checkbox\" id=\"fruit-checkbox\"></td>`;\r\n");
      out.write("                    result += `</tr>`;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                result += `\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                        <tfoot>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                           	 <td colspan=\"6\" id=\"totalPrice\" style=\"text-align: right\">0</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tfoot>\r\n");
      out.write("                    </table>`;\r\n");
      out.write("\r\n");
      out.write("                $('#cart-container').html(result);\r\n");
      out.write("\r\n");
      out.write("            } else {\r\n");
      out.write("                $('#cart-container').html('<h3 style=\"text-align: center\">장바구니에 담긴 값이 없습니다.</h3>');\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 삭제 버튼 클릭 이벤트 처리\r\n");
      out.write("            $(document).on('click', '.delete-btn', function() {\r\n");
      out.write("                let key = $(this).data('key');\r\n");
      out.write("                localStorage.removeItem(key);\r\n");
      out.write("                location.reload();  // 페이지를 새로고침하여 장바구니를 업데이트\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("         // 삭제 버튼 클릭 시 선택된 항목 삭제\r\n");
      out.write("            $('#delete').on('click', function() {\r\n");
      out.write("                // 체크된 항목들 가져오기\r\n");
      out.write("                $('#fruitTable tbody tr').each(function() {\r\n");
      out.write("                    let $row = $(this);\r\n");
      out.write("                    let isChecked = $row.find('#fruit-checkbox').is(':checked');\r\n");
      out.write("                    // 체크박스가 체크된 경우 삭제\r\n");
      out.write("                    if (isChecked) {\r\n");
      out.write("                        let itemId = $row.data('id');  // tr 태그의 data-id 속성에서 가져옴\r\n");
      out.write("                        // 로컬스토리지에서 해당 항목 삭제\r\n");
      out.write("                        localStorage.removeItem(itemId);\r\n");
      out.write("                        // 테이블에서 해당 행 삭제\r\n");
      out.write("                        $row.remove();\r\n");
      out.write("                        updateTotalPrice();\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    function count(button, type) {\r\n");
      out.write("        // 버튼이 속한 행의 모든 요소를 찾음\r\n");
      out.write("        const row = button.closest('tr');\r\n");
      out.write("        \r\n");
      out.write("        // 현재 행의 수량과 가격 요소 찾기\r\n");
      out.write("        const prodQuantity = row.querySelector(\".prod-quantity\");\r\n");
      out.write("        const prodPrice = row.querySelector(\".prod-price\").innerText;\r\n");
      out.write("        \r\n");
      out.write("        // 현재 화면에 표시된 값\r\n");
      out.write("        let currentNum = parseInt(prodQuantity.innerText);\r\n");
      out.write("        \r\n");
      out.write("        // 더하기/빼기\r\n");
      out.write("        if (type === \"plus\") {\r\n");
      out.write("            currentNum++;\r\n");
      out.write("        } else if (type === \"minus\" && currentNum > 0) {\r\n");
      out.write("            currentNum--;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        // 결과 출력\r\n");
      out.write("        prodQuantity.innerText = currentNum;\r\n");
      out.write("        \r\n");
      out.write("        // 전체 가격 계산 및 업데이트\r\n");
      out.write("        updateTotalPrice();\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function updateTotalPrice() {\r\n");
      out.write("        let totalPrice = 0;\r\n");
      out.write("        \r\n");
      out.write("        // 모든 행을 반복\r\n");
      out.write("        document.querySelectorAll('tr').forEach(row => {\r\n");
      out.write("            const prodQuantity = row.querySelector(\".prod-quantity\");\r\n");
      out.write("            const prodPrice = row.querySelector(\".prod-price\");\r\n");
      out.write("            \r\n");
      out.write("            if (prodQuantity && prodPrice) {\r\n");
      out.write("                const quantity = parseInt(prodQuantity.innerText);\r\n");
      out.write("                const price = parseInt(prodPrice.innerText);\r\n");
      out.write("                totalPrice += quantity * price;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        // 총 가격 업데이트\r\n");
      out.write("        document.getElementById(\"totalPrice\").innerText = \"총가격 : \"+totalPrice;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

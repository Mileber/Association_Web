<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title></title>
  </head>
  
  <body bgcolor="#71CABF"> 
    <s:form action="login" method="post" theme="simple">
    	<table>
    		<caption>�û���¼</caption>
    		<tr>
    			<td>��¼��<s:textfield name="user.name" size="20"/></td>
    		</tr>
    		<tr>
    			<td>��&nbsp;&nbsp;��<s:password name="user.password" size="21"/></td>
    		</tr>
    		<tr>
    			<td>
    				<s:submit value="��½"/>
    				<s:reset value="����"/>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>

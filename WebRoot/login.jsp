<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title></title>
  </head>
  
  <body bgcolor="#71CABF"> 
    <s:form action="login" method="post" theme="simple">
    	<table>
    		<caption>用户登录</caption>
    		<tr>
    			<td>登录名<s:textfield name="user.name" size="20"/></td>
    		</tr>
    		<tr>
    			<td>密&nbsp;&nbsp;码<s:password name="user.password" size="21"/></td>
    		</tr>
    		<tr>
    			<td>
    				<s:submit value="登陆"/>
    				<s:reset value="重置"/>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>

<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>µÇÂ½³É¹¦</title>
  </head>
  
  <body>
    <table>
    	<tr>
    		<th>id</th><th>name</th><th>gender</th>
    		<th>email</th><th>phone</th><th>photo</th>
    		<th>avatar</th><th>info</th>
    	</tr>
    	<s:iterator value="#request.user" id="user">
    		<tr>
    			<td><s:property value="#user.id"/></td>
    			<td><s:property value="#user.name"/></td>
    		</tr>
    	</s:iterator>
    </table>
    hello
  </body>
</html>

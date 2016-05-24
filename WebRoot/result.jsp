<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>result</title>
  </head>
  
  <body>
    <table>
    	<tr>
    		<th>id</th><th>name</th><th>associationId</th>
    		<th>class</th><th>info</th><th>photo</th><th>time</th>
    	</tr>
    	<s:iterator value="#request.list" id="activity">
    		<tr>
    			<td><s:property value="#activity.id"/></td>
    			<td><s:property value="#activity.name"/></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>

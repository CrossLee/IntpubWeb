<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/maxheight.js" type="text/javascript"></script>

</head>

<body>
<div id="infos" class="inner">
	<h2 id="item_list">
		<s:property value="selectedPart.partName"/>
	</h2>
	<ul class="list2">
		<s:iterator value="infos" var="info" status="s">
			<li><s:property value="title"/></li>
		</s:iterator>
	</ul>
</div>

</body>
</html>
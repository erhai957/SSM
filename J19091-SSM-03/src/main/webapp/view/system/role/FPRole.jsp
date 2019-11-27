<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form action="<%=basePath%>RoleController/FPRole.do" method="post">
		<input type="hidden" name="id" value="${user_db.id }">
		<div class="panel admin-panel">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>分配角色: <font
					color="red">${user_db.name }</font></strong> ${message }
			</div>
			<div class="body-content">
				<c:forEach items="${role_dbList }" var="role">
					<div class="field">
						<input type="radio" name="roleId" value="${role.roleId }"style="width: auto;" id="${role.roleId }"<c:if test="${role.roleId==role_dbXZ.roleId}">checked="checked"</c:if>>${role.roleName }
						<div class="tips"></div>
					</div>
				</c:forEach>

			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<input type="submit" value="提交"
					class="button bg-main icon-check-square-o">
			</div>
		</div>
	</form>
</body>
</html>
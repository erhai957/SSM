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
	<form action="<%=basePath%>PermissionController/FPPermission.do" method="post">
		<input type="hidden" name="roleId" value="${role_db.roleId }">
		<div class="panel admin-panel">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>分配菜单: <font
					color="red">${role_db.roleName }</font></strong> ${message }
			</div>
			<div class="body-content">
				<c:forEach items="${permission_dbList }" var="permission">
					<div class="field">
						<input type="checkbox" name="permission_ids" value="${permission.permissionId }"
							style="width: auto;" id="${permission.permissionId}">${permission.name }
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
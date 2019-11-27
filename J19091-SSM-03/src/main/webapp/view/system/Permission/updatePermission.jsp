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
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>permissionController?method=update">
				<input type="hidden" name="permission_id"
					value="${permission_db.permission_id }">

				<div class="form-group">
					<div class="label">
						<label>父ID：</label>
					</div>
					<div class="field">
						<select id="xzp_id" name="xzp_id">
							<option>------请选择父级节点------</option>
							<c:forEach items="${permission_dbList }" var="permission">
								<c:if test="${permission.permission_id == permission_db.p_id }"
									var="anth">
									<option value="${permission.permission_id }"
										selected="selected">${permission.name }</option>
								</c:if>
								<c:if test="${permission.permission_id != permission_db.p_id }"
									var="anth">
									<option value="${permission.permission_id }">${permission.name }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permission_db.name }" name="name"
							data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permission_db.type }" name="type"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${permission_db.url }"
							name="url" data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permission_db.percode }" name="percode"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>状态：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${permission_db.available }" name="available"
							data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>



				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
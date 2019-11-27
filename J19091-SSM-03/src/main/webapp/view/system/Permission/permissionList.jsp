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
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 权限管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button> <!--      <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button> -->
						<a href="<%=basePath%>permissionController?method=addUI"
						class="button border-red">增加</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<td>ID</td>
					<td>父ID</td>
					<td>名称</td>
					<td>类型</td>
					<td>URL</td>
					<td>权限码</td>
					<td>状态</td>
					<td>创建时间</td>
					<td colspan="2">操作</td>
				</tr>

				<c:forEach items="${permission_dbList }" var="permission">
					<tr>
						<td>${permission.permissionId }</td>
						<td>${permission.pId }</td>
						<td>${permission.name }</td>
						<td>${permission.type }</td>
						<td>${permission.url }</td>
						<td>${permission.percode }</td>
						<td>${permission.available }</td>
						<td><fmt:formatDate value="${permission.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><a
							href="<%=basePath%>permissionController?method=delete&permission_id=${permission.permissionId }"
							class="button border-red">删除</a> <a
							href="<%=basePath%>permissionController?method=updateUI&permission_id=${permission.permissionId }"
							class="button border-red">修改</a></td><!-- &后面的相当于选择对应ID的表数据 -->
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8"><div class="pagelist">
							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
								href="">3</a><a href="">下一页</a><a href="">尾页</a>
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>
<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-pagefmt" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	
	<title>listDictCatalog.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<pageFmt:import />
</head>
<body class="bodyCenter">
	<pageFmt:head title="字典表添加" expand="true" />
	<html:form action="/dictCatalogEditor.do?method=preSaveDictCatalog"
		method="post">
		<table class="contentTable">
			<tr>
				<td>
					名称
				</td>
				<td>
					<html:text property="tablename" />
				</td>
			</tr>
			<tr>
				<td>
					描述
				</td>
				<td>
					<html:text property="tabledesc" />
				</td>
			</tr>
			<tr>
				<td>
					性质
				</td>
				<td>
					<select name="style">
						<option value="1">
							列表型
						</option>
						<option value="0">
							树型
						</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					编码格式
				</td>
				<td>
					<html:text property="pattern" />
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					<html:submit value="提 交" />
				</td>
			</tr>
		</table>
	</html:form>
	<pageFmt:tail
		prev="/dictEditor/dictEditor.do?method=listAllDictCatalog" />
</body>
</html:html>

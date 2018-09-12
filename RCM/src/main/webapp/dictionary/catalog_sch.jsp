<html:html>
<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="http://www.qtrmoon.com/tags-pagefmt" prefix="pageFmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<title>listDictCatalog.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<pageFmt:import />
	<script>
	function addDict(){
		document.loaction='/${projectName}/dictEditor/dictCatalogEditor.do?method=preSaveDictCatalog';
	}
	</script>
</head>
<body>
	<pageFmt:head title="��ά�����ֵ�" button="����ֵ��,javascript:addDict()" tableClass="list"/>
	<table class="sortable">
		<thead>
			<tr>
				<th>
					���
				</th>
				<th>
					�ֵ������
				</th>
				<th>
					�ֵ������
				</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="row">
			<c:set var="style" value="${row.style}"></c:set>
			<tr>
				<td>
					${row.id}
				</td>
				<td>
					<a href="/${projectName}/dictEditor/dict.do?method=schTreeDict&dictId=${row.id}&group=${param.group}">${row.tabledesc}</a>
				</td>
				<td>
					<c:if test="${isList=='true'}">
						<img src="imgs/list.gif" /> �б���
					</c:if>
					<c:if test="${isList!='true'}">
						<img src="imgs/tree.gif" /> ����
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<pageFmt:tail />
</body>
</html:html>

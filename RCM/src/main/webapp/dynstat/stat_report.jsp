<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
response.setCharacterEncoding("UTF-8");
response.setContentType("application/vnd.ms-word");
response.addHeader("Content-Disposition", "attachment;filename=report.doc");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<style>
	@page {
	  size: 21cm 29.7cm;
	  margin:2cm;
	}
	table{border-collapse:collapse;}
	table td{border:black 1px solid;}
	table th{border:black 1px solid;}
	</style>
</head>
<body>

${tableHTML}
</body>
</html>

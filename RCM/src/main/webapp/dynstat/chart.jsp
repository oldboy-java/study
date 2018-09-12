<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
	<!-- JS Scripts-->
	<script src="js/echarts.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/qct.js"></script>
	<script type="text/javascript">
		$.get("./defdata/bar1.txt",function(data){
			data.dom=$('.qtrchart').get(0);
			data.theme="";
			new bar1(data);
		});
	</script>
</body>
</html>
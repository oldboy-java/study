<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/jquery.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/flexpaper_flash.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/portal/js/flexpaper_flash_debug.js"></script>  
<style type="text/css" media="screen">   
            html, body  { height:100%; }  
            body { margin:0; padding:0; overflow:auto; }     
            #flashContent { display:none; }  
        </style>   
  
<title>文档在线预览系统</title>  
</head>  
<body>   
        <div style="position:absolute;left:50px;top:10px;">  
            <a id="viewerPlaceHolder" style="width:820px;height:650px;display:block"></a>  
              
            <script type="text/javascript">   
                var fp = new FlexPaperViewer(     
                         '/${projectName}/portal/jsp/space/FlexPaperViewer',  
                         'viewerPlaceHolder', { config : {  
                         SwfFile : escape('${swfpath}'),  
                         Scale : 0.6,   
                         ZoomTransition : 'easeOut',  
                         ZoomTime : 0.5,  
                         ZoomInterval : 0.2,  
                         FitPageOnLoad : true,  
                         FitWidthOnLoad : false,  
                         FullScreenAsMaxWindow : false,  
                         ProgressiveLoading : false,  
                         MinZoomSize : 0.2,  
                         MaxZoomSize : 5,  
                         SearchMatchAll : false,  
                         InitViewMode : 'SinglePage',  
                           
                         ViewModeToolsVisible : true,  
                         ZoomToolsVisible : true,  
                         NavToolsVisible : true,  
                         CursorToolsVisible : true,  
                         SearchToolsVisible : true,  
                          
                         localeChain: 'en_US'  
                         }});  
            </script>              
        </div>  
</body>  
</html>  
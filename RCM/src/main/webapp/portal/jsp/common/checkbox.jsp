<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
  <div class="all-content index-logo">
     <img src="<%=request.getContextPath()%>/portal/img/logo.png" title="教学资源平台">
    <form class="search-form" action="#" method="post" onsubmit="return false;">
      <!-- <select class="index-select" id="wjgs" name="wjgs">
         <option value="">格&nbsp;&nbsp;式</option>
      </select> -->
      <div class="layui-form-item">
        <div class="layui-input-inline">
          <input type="text" id="zymc" name="zymc" class="layui-input" placeholder="请输入关键字" autocomplete="off" value=${zy.zymc }>
        </div>
        <button  id="_searchBtn" class="layui-btn"  type="button" onclick="doSearch('${param.ssxkid}','${name }','${param.wjgs}','${param.type}');"><span class="icon-seach"></span></button>
      </div>
    </form>
  </div>
  

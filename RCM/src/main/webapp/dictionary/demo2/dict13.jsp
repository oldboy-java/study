<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��ѡǶ����</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<pageFmt:import />
		<pageFmt:dictInit/>
		<style>
		span{color:#ddd}
		#catalog{display:none;}
		</style>
		<script>
		function doNodeEvent(id,info,exp,leaf){
            alert("ID:"+id+"\nlabel:"+info+"\n�ڵ��Ƿ�չ����"+exp+"\n�ڵ��Ƿ�Ҷ�ӣ�"+leaf);
        }
        function collect(){
        	var datas=TEST_DQBMTree.getCheckedNodes();
        	var res="";
        	for(var i=0,ii=datas.length;i<ii;i++){
        		res+=datas[i].id+",";
        	}
        	res=res.substring(0,res.length-1);
        	return res;
        }
        function selectAll(){
        	TEST_DQBMTree.checkAllNodes(true);
        }
        function selectOther(){
        	TEST_DQBMTree.checkAllNodes(false);
        }
		</script>
	</head>
	<body>
		��ѡǶ����
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		Ajax��ѡǶ����
		<div style="height:300px;width:300px;float:left;">
		<pageFmt:dictIncludeAjaxTree dictId="TEST_TREE" style="checkbox" value="150100,150200"  expand="1" context="yes"/>
		</div>
		<div style="height:300px;width:300px;float:left;">
		<pageFmt:dictIncludeAjaxTree dictId="TEST_TREE_AJAX" style="checkbox" value="150100,150200"  expand="1" context="auto_no"/>
		</div>
		<div style="clear:both;"></div>
		
		ע�⣺context=[yes|no|auto_yes|auto_no]��yes��no������С����auto��ʾС�������ϡ�
		<br/>
		<br>
		
		
		<div onclick="catalog.style.display='block'" style="color:#f60;cursor:pointer;">_catalog.xml</div>
		<div id="catalog">
		<br>
		&nbsp; &lt;table&gt;
		<br>
		&nbsp;&nbsp;&nbsp; &lt;id&gt;DQBM_LIST&lt;/id&gt;<span>��Ŀ��ʹ�õı�����һ�������Է��ݳ������ͬ���ֵ䣬����ͽ�һ�������ֵ�Ĳ����������б��ֵ䡣</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;tablename&gt;DM_XZQH&lt;/tablename&gt;<span>���ݿ�ı���</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;tabledesc&gt;��������&lt;/tabledesc&gt;
		<br>
		&nbsp;&nbsp;&nbsp; &lt;style&gt;L#D#A&lt;/style&gt;<span>������1�����б��ͣ�Ҳ����д��L#D#N��L��list�б��ͣ�D��Database���ݿ�洢��A��AI����ƥ�䡣</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;root&gt;130100&lt;/root&gt;<span>����ֻȡ�ֵ��130100�µ����ݣ�ʵ���Ͽ�����һ�����ṹ���ֵ䣬����ȡһ��������List�͡�</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;pattern&gt;2&lt;/pattern&gt;<span>ά���ֵ�ʱʹ�õ���������ģ�壬��������Ϊ1012003ģ��Ϊ2,2,3������һ���ֵ���������1012004��</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;mode&gt;0&lt;/mode&gt;<span>��ʾ�ֵ���id,pid,lable��������,id,���,lable������</span>
		<br>
		&nbsp;&nbsp;&nbsp; &lt;mapping&gt;<span>id,pid,label�����ݿ�ӳ�䡣</span>
		<br>
		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &lt;id&gt;XZQHDM&lt;/id&gt;
		<br>
		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &lt;pid&gt;SJDWDM&lt;/pid&gt;
		<br>
		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &lt;label&gt;XZQMC&lt;/label&gt;
		<br>
		&nbsp;&nbsp;&nbsp; &lt;/mapping&gt;
		<br>
		&nbsp; &lt;/table&gt;
		<br>
		</div>
		
		<div onclick="jsp.style.display='block'" style="color:#f60;cursor:pointer;">JSPҳ��</div>
		<div id="jsp" style="display:none;"> 
		&lt;pageFmt:dict dictId=&quot;DQBM_LIST&quot; style=&quot;radio&quot;/&gt;
		</div>
	</body>
</html>

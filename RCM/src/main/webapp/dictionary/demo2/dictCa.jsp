<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib uri="/WEB-INF/tlds/PageFormat.tld" prefix="pageFmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style>
			body{padding:50px;font-size:14px;line-height:22px;text-indent:2em;}
			div{font-size:14px;line-height:22px;text-indent:2em;}
			h1{font-size:20px;text-indent:0em;}
			h2{font-size:16px;text-indent:0em;}
		</style>
		<script>
		</script>
	</head>
	<body>

<p align="center" style="text-align: center;" class="MsoNormal"><b style=""><span style="font-size: 26pt; font-family: 宋体;">字典表配置详解</span></b><b style=""><span lang="EN-US" style="font-size: 26pt;"><O:P></O:P></span></b></p>

<p style="text-indent: 21pt;" class="MsoNormal"><span style="font-family: 宋体;">字典表模块支持数据库存储和</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">存储两种存储方式的字典。数据类型支持列表、树两种类型。数据获取支持同步和</span><span lang="EN-US">Ajax</span><span style="font-family: 宋体;">异步两种方式。页面表现形式支持</span><span lang="EN-US">select</span><span style="font-family: 宋体;">、弹出树、</span><span lang="EN-US">chechebox</span><span style="font-family: 宋体;">、</span><span lang="EN-US">radio</span><span style="font-family: 宋体;">四种类型，其中</span><span lang="EN-US">select</span><span style="font-family: 宋体;">又细分为一般</span><span lang="EN-US">select</span><span style="font-family: 宋体;">、</span><span lang="EN-US">select</span><span style="font-family: 宋体;">树、上下文约束异步</span><span lang="EN-US">select</span><span style="font-family: 宋体;">、智能输入匹配</span><span lang="EN-US">select</span><span style="font-family: 宋体;">，弹出树也分为单选弹出树、多选弹出树、</span><span lang="EN-US">Ajax</span><span style="font-family: 宋体;">异步弹出树和页面嵌入树。</span><span lang="EN-US"><O:P></O:P></span></p>

<p style="text-indent: 21pt;" class="MsoNormal"><span style="font-family: 宋体;">配置文件包括一个统一的</span><span lang="EN-US">_catalog.xml</span><span style="font-family: 宋体;">目录配置和</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">类字典的数据</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">，如果字典不是</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">存储的则没有后者</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">文件。</span><span lang="EN-US"><O:P></O:P></span></p>

<h1><span style="font-family: 宋体;">综述</span><span lang="EN-US"><O:P></O:P></span></h1>

<p class="MsoNormal"><span style="font-family: 宋体;">字典是树型还是列表型，字典的数据结构，字典的存储方式，都包含在字典的目录文件</span><span lang="EN-US">_catalog.xml</span><span style="font-family: 宋体;">中。有些字典有明确的父子字段来表述树型关系，我们默认使用的是这一类。而有些字典通过一个字段的编码来表述父子关系，就需要告诉程序编码的格式，几位为一个层级。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">最初的字典模块使用</span><span lang="EN-US">id,pid,label</span><span style="font-family: 宋体;">三个字段来描述字典，这也是程序使用的一个默认配置。通过完善后，可以使用其他三个名称的字段来表述字典。</span><span lang="EN-US"><O:P></O:P></span></p>

<h1><span lang="EN-US">catalogTables</span><span style="font-family: 宋体;">根</span><span lang="EN-US"><O:P></O:P></span></h1>

<h1><span lang="EN-US">table<O:P></O:P></span></h1>

<p class="MsoNormal"><span style="font-family: 宋体;">字典表元素配置根。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">id<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典的标识，工程通过该标示访问字典。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">tablename<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典映射的实际数据库表名或视图名。如果是</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">存储类字典，填写该</span><span lang="EN-US">xml</span><span style="font-family: 宋体;">文件的名称。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">tabledesc<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典表的描述。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">root<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">如果某字典是树型字典，则可配置使用该字典树的某个分支，这里填写分支的</span><span lang="EN-US">Id</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">例如可以单一设定：</span><span lang="EN-US">130000<O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">枚举和范围设定：</span><span lang="EN-US">2-12,20,26<O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">style<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典的类型。例如：</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">普通</span><span lang="EN-US">select</span><span style="font-family: 宋体;">：</span><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;sysOrgan3&quot; name=&quot;organ4&quot;
value=&quot;2&quot;/&gt;L#D# N<O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">智能</span><span lang="EN-US">select</span><span style="font-family: 宋体;">：</span><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;sysOrgan4&quot; name=&quot;organ5&quot;
value=&quot;2&quot;/&gt;L#D#A<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">box</span><span style="font-family: 宋体;">：</span><span lang="EN-US">&lt;pageFmt:dict dictId=&quot;sysOrgan3&quot;
name=&quot;organ3&quot; value=&quot;2&quot;
style=&quot;checkbox&quot;/&gt;L#D#N<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">radio</span><span style="font-family: 宋体;">：</span><span lang="EN-US">&lt;pageFmt:dict dictId=&quot;sysOrgan3&quot;
name=&quot;organ3&quot; value=&quot;2&quot; style=&quot;radio&quot;/&gt;L#D# N<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US"><O:P>&nbsp;</O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">单弹树：</span><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;sysOrgan2&quot; name=&quot;organ2&quot; value=&quot;2&quot;/&gt;<span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>T#D#P<span style="">&nbsp;&nbsp;&nbsp; </span><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">多弹树：</span><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;sysOrgan2&quot; name=&quot;organ2&quot; value=&quot;2&quot;
style=&quot;checkbox&quot;/&gt;T#D#P<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">Ajax</span><span style="font-family: 宋体;">单弹树：</span><span lang="EN-US">&lt;pageFmt:dict dictId=&quot;sysOrgan5&quot;
name=&quot;organ2&quot; value=&quot;2&quot;/&gt;<span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>T#D#X<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">Ajax</span><span style="font-family: 宋体;">多弹树：</span><span lang="EN-US">&lt;pageFmt:dict dictId=&quot;sysOrgan5&quot; name=&quot;organ2&quot;
value=&quot;2&quot; style=&quot;checkbox&quot;/&gt;<span style="">&nbsp; </span>T#D#X<O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">分离树：</span><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;sysOrgan2&quot; name=&quot;organ2&quot; value=&quot;2&quot;/&gt;<span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>T#D#S<O:P></O:P></span></p>

<p class="MsoNormal"><b style=""><span lang="EN-US"><O:P>&nbsp;</O:P></span></b></p>

<p class="MsoNormal"><span lang="EN-US">Style</span><span style="font-family: 宋体;">老版使用</span><span lang="EN-US">0</span><span style="font-family: 宋体;">表示树型，</span><span lang="EN-US">1</span><span style="font-family: 宋体;">表示字典型，依然可用，等同于</span><span lang="EN-US">L#D#N</span><span style="font-family: 宋体;">、</span><span lang="EN-US">T#D#P</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">Style</span><span style="font-family: 宋体;">由三个字母标示：</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">第一个字母是数据类型是列表（</span><span lang="EN-US">L:List</span><span style="font-family: 宋体;">）还是树（</span><span lang="EN-US">T:Tree</span><span style="font-family: 宋体;">）。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">第二个字母意思是存储方式是数据库</span><span lang="EN-US">(D:database)</span><span style="font-family: 宋体;">还是</span><span lang="EN-US">Xml</span><span style="font-family: 宋体;">文件</span><span lang="EN-US">(X:xml)</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">第三个字母是表现形式</span><span lang="EN-US">N:</span><span style="font-family: 宋体;">普通、</span><span lang="EN-US">A:</span><span style="font-family: 宋体;">智能、</span><span lang="EN-US">P:</span><span style="font-family: 宋体;">弹出、</span><span lang="EN-US">X:Ajax</span><span style="font-family: 宋体;">、</span><span lang="EN-US">S:</span><span style="font-family: 宋体;">分离。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">checkbox</span><span style="font-family: 宋体;">和</span><span lang="EN-US">radio</span><span style="font-family: 宋体;">形式同一个字典可能使用</span><span lang="EN-US">select</span><span style="font-family: 宋体;">或</span><span lang="EN-US">checkbox</span><span style="font-family: 宋体;">所以不在</span><span lang="EN-US">catalog</span><span style="font-family: 宋体;">里约束，在使用时才给以指定。而其他的例如字典的数据量大小决定是否使用</span><span lang="EN-US">Ajax</span><span style="font-family: 宋体;">和智能匹配等在</span><span lang="EN-US">catalog</span><span style="font-family: 宋体;">里指定更合适。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">pattern<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">用于维护字典数据时使用的配置，对于列表型该属性无用。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">树型字典时，配置树编码的层级，例如</span><span lang="EN-US">2,2,3</span><span style="font-family: 宋体;">的配置表示根两位码，二层四位码，三层</span><span lang="EN-US">7</span><span style="font-family: 宋体;">位码，各层分别用</span><span lang="EN-US">2,2,3</span><span style="font-family: 宋体;">的位数描述本层的数据。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">例如有</span><span lang="EN-US">1011</span><span style="font-family: 宋体;">编码的下一个兄弟码是</span><span lang="EN-US">1012</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">1011023</span><span style="font-family: 宋体;">编码的下一个兄弟码是</span><span lang="EN-US">1011024</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">orderBy<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典数据的排序，按照字典表的某个列排序，该字段可以是表的任何字段，不一定是支持字典的属性。可以不配置。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">mode<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典的数据的模式。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">模式一，</span><span lang="EN-US">mode=0</span><span style="font-family: 宋体;">。是一直使用的</span><span lang="EN-US">id,pid,label</span><span style="font-family: 宋体;">的存储方式的字典。该字典数据有明确的父子字段来记录父子关系。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span style="font-family: 宋体;">模式二，</span><span lang="EN-US">mode=1</span><span style="font-family: 宋体;">。是使用</span><span lang="EN-US">id,sequence,label</span><span style="font-family: 宋体;">的存储方式。该字典的父子关系通过</span><span lang="EN-US">sequence</span><span style="font-family: 宋体;">序列编码来体现，类似</span><span lang="EN-US">pattern</span><span style="font-family: 宋体;">配置的思想，需要通过</span><span lang="EN-US">sequence</span><span style="font-family: 宋体;">间接获取到</span><span lang="EN-US">pid</span><span style="font-family: 宋体;">再转化为模式一。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">edit<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">是否允许用户维护字典数据。</span><span lang="EN-US">true
or false</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">sql<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">对字典数据的查询条件。例如</span><span lang="EN-US">&lt;sql&gt;and
t.isshow=&rsquo;<ST1:CHMETCNV w:st="on" tcsc="0" numbertype="1" negative="False" hasspace="False" sourcevalue="1" unitname="’">1&rsquo;</ST1:CHMETCNV>&lt;/sql&gt;<O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">group<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">非</span><span lang="EN-US">Xml</span><span style="font-family: 宋体;">配置属性。属于</span><span lang="EN-US">catalog</span><span style="font-family: 宋体;">的类属性，记着该字典的配置属于哪个</span><span lang="EN-US">_catalog</span><span style="font-family: 宋体;">文件。存储的是&ldquo;</span><span lang="EN-US">_catalog_xxx.xml</span><span style="font-family: 宋体;">&rdquo;文件名。</span><span lang="EN-US"><O:P></O:P></span></p>

<h2 style="text-indent: 16pt;"><span lang="EN-US">mapping<O:P></O:P></span></h2>

<p class="MsoNormal"><span style="font-family: 宋体;">字典字段的映射，字典默认使用</span><span lang="EN-US">id</span><span style="font-family: 宋体;">、</span><span lang="EN-US">pid</span><span style="font-family: 宋体;">、</span><span lang="EN-US">label</span><span style="font-family: 宋体;">作为数据库的字段。某些数据库可能不一致，这样需要指定</span><span lang="EN-US">id</span><span style="font-family: 宋体;">对应哪个字段、</span><span lang="EN-US">pid</span><span style="font-family: 宋体;">对应哪个字段。类似的有模式二使用的</span><span lang="EN-US">code</span><span style="font-family: 宋体;">、</span><span lang="EN-US">sequence</span><span style="font-family: 宋体;">、</span><span lang="EN-US">label</span><span style="font-family: 宋体;">的映射配置。</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">code<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">模式二时使用的主键映射</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">sequence<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">模式二时使用的序列映射</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">label<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">字典记录的显示列映射</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">depth<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">模式二时使用的树型层级配置，思想类似</span><span lang="EN-US">pattern</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">id<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">模式一时使用的主键映射</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">pid<O:P></O:P></span></h3>

<p class="MsoNormal"><span style="font-family: 宋体;">模式一时使用的父映射</span><span lang="EN-US"><O:P></O:P></span></p>

<h3 style="text-indent: 32.15pt;"><span lang="EN-US">Xml</span><span style="font-family: 宋体;">字典实例</span><span lang="EN-US"><O:P></O:P></span></h3>

<p align="left" style="text-align: left;" class="MsoNormal"><span style="font-size: 10pt; font-family: 宋体; color: black;">最简单的配置一个列表型的字典</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>QDXX</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>ZD_YZ_DLBZ_QDXX</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span style="font-size: 10pt; font-family: 宋体; color: black;">道路区段信息</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>1</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>2</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;<O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span style="font-size: 10pt; font-family: 宋体; color: black;">配置一个树型字典，其使用</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>id,pid,label</span><span style="font-size: 10pt; font-family: 宋体; color: black;">三个字段来表述。</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>ZD_XZQH</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>ZD_XZQH</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span style="font-size: 10pt; font-family: 宋体; color: black;">行政区</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>0</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>2</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;<O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span style="font-size: 10pt; font-family: 宋体; color: black;">配置一个列表型字典，其使用</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>TLXLID,XLMC</span><span style="font-size: 10pt; font-family: 宋体; color: black;">两个字段来表述，树型的话也要配置</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>pid</span><span style="font-size: 10pt; font-family: 宋体; color: black;">，不配置的话将使用默认&ldquo;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>pid</span><span style="font-size: 10pt; font-family: 宋体; color: black;">&rdquo;名称。</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>JZ_TLXL</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>QLZY_JZ_TLXL</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span style="font-size: 10pt; font-family: 宋体; color: black;">铁路线路</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>1</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>1</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mode</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>0</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mode</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mapping</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>TLXLID</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pid</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pid</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>label</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>XLMC</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>label</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mapping</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;<O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span style="font-size: 10pt; font-family: 宋体; color: black;">配置一个以单一序号字段描述树型结构的字典。</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>Mode1</span><span style="font-size: 10pt; font-family: 宋体; color: black;">是树型特有的类型，只要定义了</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>model1</span><span style="font-size: 10pt; font-family: 宋体; color: black;">则</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>style</span><span style="font-size: 10pt; font-family: 宋体; color: black;">中是否配置树类型就不重要了。</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>DY_DFZY</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>id</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>LB_DY_DFZY</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tablename</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span style="font-size: 10pt; font-family: 宋体; color: black;">地方专业</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>tabledesc</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>T#D#P</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>style</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>2</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>pattern</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>orderBy</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>MC</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>orderBy</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mode</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>1</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mode</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mapping</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>code</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>NM</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>code</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>sequence</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>XH</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>sequence</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>label</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'>MC</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>label</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>depth</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>depth</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p align="left" style="text-align: left;" class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>mapping</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New";'><O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: black;'><span style="">&nbsp;&nbsp;&nbsp; </span></span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&lt;/</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: rgb(63, 127, 127);'>table</span><span lang="EN-US" style='font-size: 10pt; font-family: "Courier New"; color: teal;'>&gt;</span><span lang="EN-US"><O:P></O:P></span></p>

<h1><span style="font-family: 宋体;">标签使用方法</span><span lang="EN-US"><O:P></O:P></span></h1>

<p class="MsoNormal"><span lang="EN-US">&lt;pageFmt:dict
dictId=&quot;TEST_DICT_EXP&quot; style=&quot;selectTree&quot;/&gt;<O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">Style= radio</span><span style="font-family: 宋体;">、</span><span lang="EN-US">checkbox</span><span style="font-family: 宋体;">、</span><span lang="EN-US">checkboxInList</span><span style="font-family: 宋体;">、</span><span lang="EN-US">select(default)</span><span style="font-family: 宋体;">、</span><span lang="EN-US">selectTree</span><span style="font-family: 宋体;">。</span><span lang="EN-US"><O:P></O:P></span></p>

<p class="MsoNormal"><span lang="EN-US">dynroot</span><span style="font-family: 宋体;">属性可定义根，此根可动态配置字典子集，例如根据不同用户显示不同的树。</span><span lang="EN-US"><O:P></O:P></span></p>

</body>
</html>

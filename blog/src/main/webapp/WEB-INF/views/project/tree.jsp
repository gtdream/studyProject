<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="/blog/resources/syntax/js/shCore.js"></script>
<script type="text/javascript" src="/blog/resources/_shared/js/lib/jquery.js"></script>
<script type="text/javascript" src="/blog/resources/_shared/js/lib/jquery.cookie.js"></script>
<script type="text/javascript" src="/blog/resources/_shared/js/lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/blog/resources/_shared/js/lib/jquery.jstree.js"></script>
<script type="text/javascript" src="/blog/resources/syntax/js/shBrushJava.js"></script>
<link href="/blog/resources/syntax/css/shCore.css" rel="stylesheet" type="text/css" />
<link href="/blog/resources/syntax/css/shThemeDefault.css" rel="stylesheet" type="text/css" />
<title>Tree Test</title>
</head>
<body>
<div id="treeView" class="treeView" style="width:200px;height:500px;float:left"></div>
<script type="text/javascript">
$(function () {
	$("#treeView").jstree({ 
		"html_data" : {
			"ajax" : {
				"url" : "/blog/treeView?project=c:\temp",
				"data" : function (n) { 
					return { id : n.attr ? n.attr("id") : 0 }; 
				}
			}
		},
		"plugins" : [ "themes", "html_data" ],
		"themes": {"theme": "apple","dots": true,"icons": true}
	});
});
</script>
<div id="sourceContents" style="width:600px;Height:600px;overflow:auto"></div>
</body>
<script type="text/javascript">
function showContent(projectName,fileName){
	$.ajax({
		type:"POST",
		url: "/blog/contentsView",
		dataType: "html",
		data:"projectName="+projectName+"&fileName="+fileName,
		success: function(msg){
			$("#sourceContents").html("<pre class=\"brush:java\"> " + msg + "</pre>");
			SyntaxHighlighter.config.bloggerMode = true;
			SyntaxHighlighter.highlight();
		},
		fail: function(msg){
			alert('fail');
		}
	});
}
</script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
    function doDelete(){
			var rows = $('#grid').datagrid("getSelections");
			if(rows.length<1){
			    $.messager.alert("警告","必须至少选中1行");
			    return;
			}
        $.messager.confirm('确认对话框','你确定要删除吗？',function(r){
            if(r==true){
                var ids ="";
                for(var i=0;i<rows.length;i++){
                    ids+=rows[i].id+",";
                }
                $.ajax({
                    url:"../../fuction/deleteFuction?ids="+ids,
                    type:"post",
                    success:function(){
                        $.messager.show({
                            title:"删除成功",
                            msg:'消息将在5秒后关闭。',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#dg').datagrid('reload');
                    },
                    error:function(){
                     alert("删除失败");
                    }
                });
            }
        });




    }


	$(function(){
		$("#grid").datagrid({
			toolbar : [
				{
					id : 'add',
					text : '添加权限',
					iconCls : 'icon-add',
					handler : function(){
						location.href='${pageContext.request.contextPath}/page/admin/function_add';
					}
				},{
                    id : 'button-delete',
                    text : '删除',
                    iconCls : 'icon-cancel',
                    handler : doDelete
                }
			],
            pageList: [3,5,10],
            pagination : true,
			url : '${pageContext.request.contextPath}/fuction/pageQuery',
			columns : [[
                {field:'ck',checkbox:true},
                {
                    field : 'id',
                    title : '编号',
                    width : 200,
                    hidden:true
                },
			  {
				  field : 'code',
				  title : '编号',
				  width : 200
			  },
			  {
				  field : 'name',
				  title : '名称',
				  width : 200
			  },  
			  {
				  field : 'description',
				  title : '描述',
				  width : 200
			  },  
			  {
				  field : 'generatemenu',
				  title : '是否生成菜单',
				  width : 200
			  },  
			  {
				  field : 'zindex',
				  title : '优先级',
				  width : 200
			  },  
			  {
				  field : 'page',
				  title : '路径',
				  width : 200
			  }
			]]
		});
	});
</script>	
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
	<table id="grid"></table>
</div>
</body>
</html>
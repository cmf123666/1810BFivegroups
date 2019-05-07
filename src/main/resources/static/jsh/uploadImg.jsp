<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="<%=request.getContextPath() %>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/my97/WdatePicker.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css"/>
    <script src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css"/>
    <script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>

</body>

<script type="text/javascript">
    var editor = null;
    KindEditor.ready(function (K) {//将编辑器添加到文档中
        editor = K.create('#content', {
            cssPath: '<%=request.getContextPath()%>/js/kindeditor/plugins/code/prettify.css',//指定编辑器iframe document的CSS文件，用于设置可视化区域的样式。
            uploadJson: '<%=request.getContextPath()%>/js/kindeditor/jsp/upload_json.jsp', //指定上传文件的服务器端程序。
            fileManagerJson: '<%=request.getContextPath()%>/js/kindeditor/jsp/file_manager_json.jsp',//指定浏览远程图片的服务器端程序。
            allowFileManager: true,  //true时显示浏览远程服务器按钮 ;默认值: false
            afterCreate: function () {
                var self = this;
                K.ctrl(document, 13, function () {
                    self.sync();
                    document.forms['example'].submit();
                });
                K.ctrl(self.edit.doc, 13, function () {
                    self.sync();
                    document.forms['example'].submit();
                });
            }
        });
        prettyPrint();
    });

    //上传插件
    $("#uploadify").uploadify({
        //插件自带  不可忽略的参数
        'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
        //前台请求后台的url 不可忽略的参数                          //*****要修改路经
        'uploader': '<%=request.getContextPath()%>/easyui/upload.do',
        //给div的进度条加背景 不可忽略
        'queueID': 'fileQueue',
        //上传文件文件名
        'fileObjName': 'img',
        //给上传按钮设置文字
        'buttonText': '上传图片',
        //设置文件是否自动上传
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': false,
        //上传后队列是否消失
        'removeCompleted': true,
        //允许上传的文件后缀
        'fileExt': '*.jpg;*.gif;*.png',
        //
        'cancelImg': '<%=request.getContextPath()%>/js/uploadify/uploadify-cancel.png',
        //队列消失时间
        'removeTimeout': 1,
        //上传文件的个数，项目中一共可以上传文件的个数
        'uploadLimit': -1,
        'fileTypeExts': '*.jpg;*.png',
        //开始执行上传
        'onUploadStart': function (files) {
            //$.messager.progress({ title:'提示',msg:'上传中...' });
        },
        //上传失败
        'onUploadError': function () {
            //$.messager.progress('close');
            //$.messager.alert('提示','上传失败');
            alert("上传失败");
        },
        //成功回调函数 file：文件对象。data后台输出数据
        'onUploadSuccess': function (file, data, response) {
            //$.messager.progress('close');
            //  alert(data+file.name)
            var imgurl = "http://<%= request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/" + data
            $("#testimg").attr("src", imgurl);
            $('#hideImg').val(imgurl);
        }

    });
</script>
</html>

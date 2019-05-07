//上传插件
$("#uploadify").uploadify({
    //插件自带  不可忽略的参数
  	'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
	//前台请求后台的url 不可忽略的参数
	'uploader': '<%=request.getContextPath()%>/user/upload.do',
    //给div的进度条加背景 不可忽略
    'queueID': 'fileQueue',
    //上传文件文件名
    'fileObjName' : 'img',
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
    'removeTimeout' : 1,
    //上传文件的个数，项目中一共可以上传文件的个数
    'uploadLimit':  -1,
    'fileTypeExts': '*.jpg;*.png',
    //开始执行上传
    'onUploadStart':function(files){
    	//$.messager.progress({ title:'提示',msg:'上传中...' });
    },
    //上传失败
    'onUploadError':function(){
    	//$.messager.progress('close');
    	//$.messager.alert('提示','上传失败');
    	alert("上传失败");
    },
	//成功回调函数 file：文件对象。data后台输出数据
    'onUploadSuccess':function(file,data,response){
    	//$.messager.progress('close');
	  	//  alert(data+file.name)
	  	var imgurl = "http://<%= request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"+data
	    $("#testimg").attr("src",imgurl);
	  	$('#hideImg').val(imgurl);
    }
});
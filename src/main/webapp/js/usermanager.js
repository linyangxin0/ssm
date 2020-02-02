// JavaScript Document
$(function($){
	$('#usertab').bootstrapTable({
		ajax:function(request){
			$.ajax({
				type:"GET",
				url:"/List/findAll",
				data:{},
				contentType:'application/json',
				dataType:"json",
				success:function (data) {
					// var jsonStr = JSON.stringify(data);
					// alert(jsonStr);
					// request.success({
					// 	row : data
					// });
					$('#usertab').bootstrapTable('load', data);
				},
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					// 状态码
					console.log(XMLHttpRequest.status);
					// 状态
					console.log(XMLHttpRequest.readyState);
					// 错误信息
					console.log(textStatus);
					alert("错误");
				}
			});
		},
		height:'600px',
		columns:[
			{
				field:'select',
				checkbox:true,
				align:"center",
				valign:'middle',
			},
			{
				field:'id',
				title:'编号',
				align:"center",
				valign:'middle',
			},
			{
				field:'user_name',
				title:'用户名',
				align:"center",
				valign:'middle',
			},
			{
				field:'sex',
				title:'性别',
				align:"center",
				valign:'middle',
				// formatter:function(value){
				// 	if (value==1)
				// 		return "男";
				// 	else if(value==2)
				// 		return "女";
				// 	else
				// 		return "谜";
				// }
			},
			{
				field:'age',
				title:'年龄',
				align:"center",
				valign:'middle',
			},
			{
				field:'mobile_phone',
				title:'电话',
				align:"center",
				valign:'middle',
			},
			{
				field:'address',
				title:'住址信息',
				align:"center",
				valign:'middle',
			}
		]
	});

	// 	function addUser(){
	// 		var userName=$("#username").val();
	// 		var password=$("#password").val();
	// 		var sex=$("#sex").val();
	// 		var age=$("#age").val();
	// 		var mobilephone=$("#mobilephone").val();
	// 		var address=$("#address").val();
	//
	// 		var param={
	// 				userName:userName,
	// 				password:password,
	// 				sex:sex,
	// 				age:age,
	// 				mobilephone:mobilephone,
	// 				address:address
	// 		};
	// 		$.ajax({
	// 			url:"/UserManager/addUserController.do",
	// 			data:param,
	// 			success:function(data){
	// 				if((typeof(data)!="undefined")&&(data==0)){
	// 					$table.bootstrapTable('refresh');
	// 				}
	// 		},complete:function(){
	// 			$('#myModal').modal('hide');
	// 		},
	// 		context:this
	// 		});
	// 	}
	// $("#add_user_Btn").bind("click",addUser);
	//
	// function delUser(){
	// 	var selects=$table.bootstrapTable("getSelections");
	// 	if(selects.length==0){
	// 		return;
	// 	}
	//
	// 	var userIds="";
	// 	for(var i=0;i<selects.length;i++){
	// 		userIds=userIds+selects[i].id+",";
	// 	}
	// 	var param={
	// 			userIds:userIds
	// 	};
	// 	$.ajax({
	// 		url:"/UserManager//deleteUsersController.do",
	// 		data:param,
	// 		success:function(data){
	// 			if((typeof(data)!="undefined")&&(data==0)){
	// 				$table.bootstrapTable('refresh');
	// 			}
	// 			$("#remove").attr("disabled","disabled");
	// 		},
	// 		context:this
	// 	});
	// }
	// $("#remove").bind("click",delUser);
});
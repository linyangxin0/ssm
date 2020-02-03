// JavaScript Document
$(function($){
	$('#userTable').bootstrapTable({
		url:"/List/findAll",
		method:"GET",
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
				// title:'编号',
				align:"center",
				valign:'middle',
			},
			{
				field:'user_name',
				// title:'用户名',
				align:"center",
				valign:'middle',
			},
			{
				field:'sex',
				// title:'性别',
				align:"center",
				valign:'middle',
				formatter:function(value){
					if (value==1)
						return "男";
					else
						return "女";
				}
			},
			{
				field:'age',
				// title:'年龄',
				align:"center",
				valign:'middle',
			},
			{
				field:'mobile_phone',
				// title:'电话',
				align:"center",
				valign:'middle',
			},
			{
				field:'address',
				// title:'住址信息',
				align:"center",
				valign:'middle',
			}
		],
	});
});

//模态框添加用户
function addUser(){
	var userName=$("#user_name").val();
	// var password="123";
	var sex=$("#sex").val();
	var age=$("#age").val();
	var mobilephone=$("#mobile_phone").val();
	var address=$("#address").val();

	var param={
		user_name:userName,
		password:"123",
		sex:sex,
		age:age,
		mobile_phone:mobilephone,
		address:address
	};
	$.ajax({
		url:"/List/addUser",
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
				alert("添加成功,默认密码为“123”");
			}

		},complete:function(){
			$('#myModal').modal('hide');
		},
		context:this
	});
}
// $("#addUser_btn").bind("click",addUser());


// 删除用户
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
// 		userIds:userIds
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
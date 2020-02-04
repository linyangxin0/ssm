// JavaScript Document
function addFunctionAlty(value, row, index) {
	return [
		'<button id="edit_btn" type="button" class="btn btn-default">编辑</button>'
	].join('');
}
window.operateEvents = {
	'click #edit_btn': function (e, value, row, index) {
		$("#editModal").modal('show');
		$('#edit_id').attr("value",row.id);
		$('#edit_user_name').attr("value",row.user_name);
		$('#edit_sex').val(row.sex);
		$('#edit_age').attr("value",row.age);
		$('#edit_mobile_phone').attr("value",row.mobile_phone);
		$('#edit_address').attr("value",row.address);
	},
};

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
			},{
				field: 'operate',
				// title: '操作',
				events: operateEvents,//给按钮注册事件
				formatter: addFunctionAlty//表格中增加按钮
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

	if(userName==""||sex==""||age==""||mobilephone==""||address==""||userName==null||sex==null||age==null||mobilephone==null||address==null){
		alert("请正确输入账户信息");
		return;
	}

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


//删除用户
function delUser(){
	var selects=$('#userTable').bootstrapTable("getSelections");
	if(selects.length==0){
		return;
	}
	var myArray=new Array();
	for(var i=0;i<selects.length;i++)
		myArray[i]=selects[i].id;
	var param={
		userIds:myArray
	};
	$.ajax({
		url:"/List/delUser",
		contentType : 'application/json;charset=utf-8',
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
			}
			alert("删除成功");
		},
		error:function () {
			alert("删除失败");
		}
	});
}

//修改账户信息
function editUser() {
	var id=$("#edit_id").val();
	var userName=$("#edit_user_name").val();
	var sex=$("#edit_sex").val();
	var age=$("#edit_age").val();
	var mobilephone=$("#edit_mobile_phone").val();
	var address=$("#edit_address").val();

	var param={
		id:id,
		user_name:userName,
		sex:sex,
		age:age,
		mobile_phone:mobilephone,
		address:address
	};

	$.ajax({
		url:"/List/editUser",
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
				alert("修改成功”");
			}
		},
		error:function(){
			alert("修改失败");
		},
		complete:function(){
			$('#editModal').modal('hide');
		},
		context:this
	});
}


function logout() {
	$.ajax({
		url:"/account/logoutAjax",
		success:function () {
			window.location.href="login.jsp";
		}
	})
}

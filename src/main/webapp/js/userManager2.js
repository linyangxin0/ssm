function to_page(pn){
	$.ajax({
		url:"/List/findAll",
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			build_user_table(result);
		}
	});
}

to_page(1);

function build_user_table(result){
	$("#userTable tbody").empty();
	var user = result;
	$.each(user,function(index,item){
		if (item.sex==1)
			item.sex="male";
		else
			item.sex="female";
		var userIdTd = $("<td></td>").append(item.id);
		var userNameTd = $("<td></td>").append(item.user_name);
		var sexTd = $("<td></td>").append(item.sex);
		var ageTd = $("<td></td>").append(item.age);
		var mobile_phoneTd = $("<td></td>").append(item.mobile_phone);
		var addressTd = $("<td></td>").append(item.address);
		var delBtn = $("<button></button>").addClass("btn btn-danger del-btn").attr("del-id",item.userId).append("delete");
		var editBtn = $("<button></button>").addClass("btn btn-success edit-btn").attr("edit-id",item.userId).append("edit");
		var BtnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
		$("<tr></tr>").append(userIdTd)
			.append(userNameTd)
			.append(sexTd)
			.append(ageTd)
			.append(mobile_phoneTd)
			.append(addressTd)
			.append(BtnTd)
			.appendTo("#userTable tbody");
	});
}

// $('#add').on('click',function(){
// 	$('#myModal').modal({
// 		backdrop:'static'
// 	});
// })
//
// $("#addUser_btn").on("click",function(){
// 	$.ajax({
// 		url:"/List/addUser",
// 		data:$("#myModal form").serialize(),
// 		type:"POST",
// 		success:function(result){
// 			to_page(1);
// 			$('#myModal').modal('hide');
// 		}
// 	})
// })
//
// /*edit按钮的操作 弹出修改模态框*/
// $(document).on("click",".edit-btn",function(){
// 	getRole('#EditUserModal select');
// 	getUser($(this).attr("edit-id"));
// 	$("#updateBtn").attr("edit-id",$(this).attr("edit-id"));
// 	$('#EditUserModal').modal({
// 		backdrop:'static'
// 	});
// })


function addUser() {
	var userNmame=$("#user_name").val();
	var sex=$("#sex").val();
	var age=$("#age").val();
	var phone=$("#mobile_phone").val();
	var address=$("#address").val();

	var param={
		user_name:userNmame,
		sex:sex,
		age:age,
		mobile_phone:phone,
		address:address
	};

	$.ajax({
		uri:"/List/addUser",
		data: param,
		success:function () {
				// $("#userTable").bootstrapTable('refresh');
				alert("成功");
		},complete:function () {
			$('#myModal').modal('hide');
		},
		context:this
	});
	$("#addUser_btn").bind("click",addUser)
}
//
// $("#addUser_btn").on("click",function () {
// 	$.ajax({
// 		url: "/List/addUser",
// 		data:
// 	})
// })
// // JavaScript Document
// $(function($) {
// 	$("#loginbtn").on("click",function(e)
// 	{
// 		// var userName=document.getElementById("username").value;
// 		// var passwd=document.getElementById("userpwd").value;
//
// 		$.post({
// 			url:"accout/loginAjax",
// 			cache:false,
// 			data:{"user_name":$("#user_name").val(),"password":$("#password").val()},
// 			error:function()
// 			{
// 				alert("服务器超时");
// 			},
// 			success:function(data)
// 			{
// 				// window.location.href="userList.jsp";
// 				alert(data);
// 			}
// 		});
// 	});
// });
function check() {
    $.post({
        url:"account/loginAjax",
        data:{"user_name":$("#user_name").val(),"password":$("#password").val()},
        success:function (data) {
            if(data.equals!=null){
                alert(data);
            }        }
    })
}
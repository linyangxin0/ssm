function check() {
    $.post({
        url:"account/loginAjax",
        data:{"user_name":$("#user_name").val(),"password":$("#password").val()},
        success:function (data) {
            if(data!=""){
                alert(data);
            }else {
                window.location.href="index.jsp";
            }
        }
    })
}

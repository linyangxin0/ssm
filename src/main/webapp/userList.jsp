<%--
  Created by IntelliJ IDEA.
  User: 12271
  Date: 2020/1/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">

    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap-table-locale-all.min.js"></script>

    <script><%@include file="/js/userManager2.js" %></script>


</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        用户信息管理
    </div>
    <div id="toolbar">
        <button id="add" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            添加
        </button>
    </div>
<%--    <table id="usertab"--%>
<%--           data-toolbar="toolbar"--%>
<%--           data-show-refresh="true"--%>
<%--           data-show-toggle="true"--%>
<%--           data-show-columns="ture">--%>

<%--    </table>--%>
    <table class="table table-hover" id="userTable"
           data-toolbar="toolbar"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="ture">
        <thead>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>住址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
                    用户信息
                </h4>
            </div>
            <form>
            <div class="modal-body">
                <div class="row">
                    <label for="user_name" class="col-sm-4 control-label">
                        姓名:
                    </label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="user_name" placeholder="请输入姓名"/>
                    </div>
                </div>

                <div class="row">
                    <label for="sex" class="col-sm-4 control-label">
                        性别:
                    </label>
                    <div class="col-sm-8">
                        <select id="sex" class="form-control">
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <label for="age" class="col-sm-4 control-label">
                        年龄:
                    </label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="age" placeholder="请输入年龄"/>
                    </div>
                </div>

                <div class="row">
                    <label for="mobile_phone" class="col-sm-4 control-label">
                        电话:
                    </label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="mobile_phone" placeholder="请输入电话"/>
                    </div>
                </div>

                <div class="row">
                    <label for="address" class="col-sm-4 control-label">
                        住址:
                    </label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="address" placeholder="请输入住址"/>
                    </div>
                </div>

            </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="addUser_btn">
                    添加
                </button>
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>

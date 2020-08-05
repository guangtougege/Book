<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>

    <!--静态包含base标签-->
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        //页面加载完成之后
        $(function () {
                //给验证码图片绑定单机事件
            $("#code_img").click(function () {
                this.src = "${basePath}/kaptcha.jpg";
            });
            //给注册绑定单击事件
            //sub_btn  注册的id

            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取用户名输入框的内容,val()它可以设置和获取表单项的 value 属性值。
                let usernameText = $("#username").val();
                //2.创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3.使用test方式验证
                if (!usernamePatt.test(usernameText)) {
                    //4.提示用户结果,span输入多少显示多少
                    $("span.errorMsg").text("用户名不合法!");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                let passwordText = $("#password").val();
                //2.创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3.使用test方式验证
                if (!passwordPatt.test(passwordText)) {
                    //4.提示用户结果,span输入多少显示多少
                    $("span.errorMsg").text("密码不合法!");
                    return false;
                }
                // 验证确认密码：和密码相同 
                //1.确认密码内容,val获取输入框的内容
                let repwdText = $("#repwd").val();
                //2.和密码确认
                if (repwdText != passwordText) {
                    //3.提示用户
                    $("span.errorMsg").text("密码不一致");
                    return false;
                }

                //邮箱验证：xxxxx@xxx.com
                //1.获取邮箱内容
                let emailTest = $("#email").val();
                //2.使用正则表达式对象
                var emailPatt = /^\w+([\.\-]\w+)*\@\w+([\.\-]\w+)*\.\w+$/;
                //3.使用test方法验证是否一致
                if (!emailPatt.test(emailTest)) {
                    //4.提示用户
                    $("span.errorMsg").text("请使用正确的邮箱");
                    return false;
                }
                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                let codeText = $("#code").val();
                //去掉验证码中的空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText == "") {
                    //4.提示用户
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }


                //合法应该去掉
                $("span.errorMsg").text("");
            });

        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册小mo会员</h1>
                    <span class="errorMsg">
                       ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <!--  修改信息,使得注册页面传入的信息放入RegistServlet类去处理-->
                    <form action="userServlet" method="post">
                        <!--隐藏域-->
                        <input type="hidden" name="action" value="regist" />
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value="${requestScope.username}"
                               autocomplete="off" tabindex="1"
                               name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               value="${requestScope.email}"
                               autocomplete="off" tabindex="1"
                               name="email" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:110px;height:30px ">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<!--静态包含页脚内容-->
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
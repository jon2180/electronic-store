<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/WEB-INF/layout/icd_meta.jsp"/>
    <title>卓尔商城-会员登录</title>
    <jsp:include page="/WEB-INF/layout/icd_link.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/layout/icd_top.jsp"></jsp:include>

<!-- 主内容 -->
<div class="wrapper" style="min-height: 500px;">
    <div class="panel" style="margin-top: 20px">
        <div class="panel-heading" style="font-size: 18px">
            <strong>会员登录</strong>
        </div>
        <div class="panel-body row">
            <div class="col-xs-3"></div>

            <div class="col-xs-6" style="padding: 30px 60px">
                <div class="panel" style="border: none;">
                    <div class="panel-heading" style="background: none;">
                        <strong>已有帐号</strong>
                    </div>
                    <div class="panel-body">
                        <form action="${ctx}/member_login" method="post" onsubmit="return validate()">
                            <c:if test="${!empty msg}">
                                <div class="form-group">
                                    <div id="formError" class="alert alert-danger">${msg}</div>
                                </div>
                                <c:remove var="msg"/>
                            </c:if>
                            <!-- 格式验证提示 -->
                            <div class="form-group" id="errorContainer" style="display: none">
                                <div id="formValidateNotice" class="alert alert-danger"></div>
                            </div>

                            <!-- 实际内容 -->
                            <div class="form-group">
                                <input type="text" name="mobile" id="mobile" value=""
                                       placeholder="请输入手机号" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="password" name="pwd" id="pwd" value=""
                                       placeholder="请输入密码" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="captcha" id="captcha"
                                       placeholder="请输入验证码" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <img src="${pageContext.request.contextPath}/tool/captcha/" alt="验证码">
                            </div>

                            <button type="submit" class="btn btn-primary btn-wider btn-lg">登录</button>
                            &nbsp; &nbsp;<a href="${ctx}/member_register.jsp">注册</a>&nbsp;
                            &nbsp; <a href="${ctx}/forgot_password">忘记密码</a>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-xs-3"></div>

        </div>
    </div>
</div>
<!-- /主内容 -->

<jsp:include page="/WEB-INF/layout/icd_bottom.jsp"></jsp:include>

<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
<script>
    function validate() {
        const mobile = $('#mobile').val()
        const password = $('#pwd').val();

        const $container = $('#errorContainer');
        const $notice = $('#formValidateNotice');

        if (!validator.phoneNumber(mobile) || !validator.password(password)) {
            $container.show();
            $notice.text('表单输入内容存在格式错误，验证失败，请查证后再提交');
            return false;
        }

        $container.hide();
        $notice.text('');
        return true;
    }
</script>

</body>
</html>
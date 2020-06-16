<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Floating labels example · Bootstrap</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/floating-labels/">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/bootstrap/dist/css/bootstrap.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/floating-labels.css" rel="stylesheet">
</head>
<body>
<form class="form-signin" action="${pageContext.request.contextPath}/member/sign-in" method="post" onsubmit="return validate()">
    <div class="text-center mb-4">
        <img class="mb-4" src="${pageContext.request.contextPath}/static/bootstrap/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Floating labels</h1>
        <p>Build form controls with floating labels via the <code>:placeholder-shown</code> pseudo-element. <a
                href="https://caniuse.com/#feat=css-placeholder-shown">Works in latest Chrome, Safari, and Firefox.</a>
        </p>
    </div>

    <div class="form-label-group">
        <input type="text" id="inputMobile" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputMobile">Email address</label>
    </div>

    <div class="form-label-group">
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <label for="inputPassword">Password</label>
    </div>

    <div class="form-label-group">
        <input type="text" id="inputCaptcha" class="form-control" placeholder="Captcha" required>
        <label for="inputCaptcha">Captcha</label>
    </div>

    <div class="form-label-group">
        <img src="${pageContext.request.contextPath}/tool/captcha/" alt="captcha">
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2020</p>
</form>

<script src="static/jquery-v3.5.1/jquery.min.js"></script>
<script src="assets/js/common.js"></script>
<script>

    function validate() {
        // 验证
        return true;
    }

</script>
</body>
</html>

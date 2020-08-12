<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Logowanie</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="https://ibb.co/n3pXdN0">People vector created by ddraw - www.freepik.com"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">

    <!--===============================================================================================-->
</head>


<body>

<jsp:include page="/WEB-INF/fragments/header.jspf"/>


<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
<img src="https://i.ibb.co/n3pXdN0/544.jpg" alt="IMG" border="0" />
            </div>

            <form action="j_security_check" method="post">

					<span class="login100-form-title"> Logowanie </span>

                <div class="wrap-input100 validate-input" >
                    Login:
                    <input name="j_username" type="text" class="form-control" placeholder="Nazwa uzytkownika" required autofocus>


                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                 Hasło:
                    <input name="j_password" type="password" class="form-control" placeholder="Hasło" required>



                </div>

                <div class="container-login100-form-btn">
                    <button class="buttonJumbotron">
                        Zaloguj
                    </button>
                </div>

                <div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
                    <a class="txt2" href="#">
                        Username / Password?
                    </a>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="/Avtrka/register">
                        Zarejestruj się
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>




<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/tilt/tilt.jquery.min.js"></script>
<script >
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

<%@ include file ="/WEB-INF/fragments/footer.jspf" %>


</body>
</html>
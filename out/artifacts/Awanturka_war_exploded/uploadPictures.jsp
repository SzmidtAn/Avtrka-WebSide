<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Rejestracja</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
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
    <div class="container-login100"  >
        <div class="wrap-login100" style="padding-top: 100px; position: relative ">



            <form action="upload" method="post" enctype="multipart/form-data">

                <span class="login100-form-title"> Dodaj zdjęcia</span>

                <div class="wrap-input100 validate-input" data-validate = "Description is required">

                <label>Wgraj pliki</label><br>
                <input type="file" name="fileName"/>
                <br>
                <input type="file" name="fileName"/>
                <br>
                <input type="file" name="fileName"/>
                <br>
                </div>

                <br>
                <br>

                <div class="container-login100-form-btn">
                    <button type="submit" class="login100-form-btn">
                        Dodaj
                    </button>
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





<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produkt</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>

        .row{
            background-color: #efefef;
            padding-left: 50px;
            padding-right: 50px;
            padding-top: 100px;
            padding-bottom: 50px;
            size: auto;

        }

        .is-wide .container {
            width: 1280px;
            padding-right: 20px;
            padding-left: 20px;
        }

        .container {
            position: relative;
            width: 960px;
            max-width: 100%;
            margin: 0 auto;
            box-sizing: border-box;
        }

        div {
            display: block;
        }


        .btn{
            border-style: solid;
            border-color: #ff9999;
            font-size: 14px;
            background-color: #ff9999;
            color: white;

            float: bottom;
            text-align: center;
            padding: 5px;
            text-decoration: none;


        }

        .gallery {
            -webkit-column-count: 3;
            -moz-column-count: 3;
            column-count: 3;
            -webkit-column-width: 33%;
            -moz-column-width: 33%;
            column-width: 33%; }
        .gallery .pics {
            -webkit-transition: all 350ms ease;
            transition: all 350ms ease; }
        .gallery .animation {
            -webkit-transform: scale(1);
            -ms-transform: scale(1);
            transform: scale(1); }

        @media (max-width: 450px) {
            .gallery {
                -webkit-column-count: 1;
                -moz-column-count: 1;
                column-count: 1;
                -webkit-column-width: auto;
                -moz-column-width: auto;
                column-width: auto;
            }
        }

        @media (max-width: 400px) {
            .btn.filter {
                padding-left: 1.1rem;
                padding-right: 1.1rem;
            }
            img {
                filter: gray; /* IE6-9 */
                -webkit-filter: grayscale(1); /* Google Chrome, Safari 6+ & Opera 15+ */
                -webkit-box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
                -moz-box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
                box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
                margin-bottom:20px;
            }

            img:hover {
                filter: none; /* IE6-9 */
                -webkit-filter: grayscale(0); /* Google Chrome, Safari 6+ & Opera 15+ */

            }

        }

    </style>
    <!--===============================================================================================-->
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



<div class="container-fluid ">
    <div class="row">

        <c:if test="${not empty requestScope.products}" >
            <c:forEach var="product" items="${requestScope.products}" >
                <c:if test="${product.id == param['id']}">


                <div class="col-md-4">
             <img class="img" src="images/<c:out value="${product.pictureName}" />" />
                        </div>

           <div class="col-md-4">
             <img class="img" src="images/<c:out value="${product.pictureName}" />" />
                        </div>

                <div class="col-md-4">




            <div class="card" >
                <div class="card-body">




                    <p class="card-text" style="font-size: xx-large"><c:out value="${product.pris}" /> zł</p>
                    <br>
                    <p class="card-text" style="font-size: x-large; font-weight: bold;"><c:out value="${product.name}" /></p>
                    <p class="card-text" style="font-size: small; font-weight: bold;">Marka: <c:out value="${product.brand}" /></p>
                    <p class="card-text" style="font-size: small; font-weight: bold;">Stan oceniam na: <c:out value="${product.condition}" /></p>

                    <br>
                    <p class="card-text" style="font-size: medium; ;"><c:out value="${product.description}" /></p>


                    <br>
                    <br>
                </div>

                <div class="card-footer">
                    <a href="#" type="button"  class="btn btn-block" style="border-color: #ff9999; background-color: white; color: #ff9999;"
                    >Zapytaj o przedmiot</a>

                    <a href="#" type="button" id="pinkButton" class="btn btn-block" >Dodaj do ulubionych</a>

                </div>



        </c:if>
            </c:forEach>
        </c:if>

    </div>
</div>
</div>
</div>
</div>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/tilt/tilt.jquery.min.js"></script>

<!--===============================================================================================-->
<script src="js/main.js"></script>


<%@ include file ="/WEB-INF/fragments/footer.jspf" %>


</body>
</html>
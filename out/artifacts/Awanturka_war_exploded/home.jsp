<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
 <html>
 <head>
     <title>AVTRKA - najlepszy portal dla awanturników</title>
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


    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>

    <section class="jumbotron">
        <h1>A Ty?</h1>
        <p>Kiedy zaczniesz zarabiać?</p>
        <a href="${pageContext.request.contextPath}/add" class="buttonJumbotron">Sprzedaj ubrania</a>
    </section>


 <div class="container">
     <div class="row">

<c:if test="${not empty requestScope.products}" >
    <c:forEach var="product" items="${requestScope.products}" >



        <div class="col-sm-3">

             <div class="card-img-top" >
                 <div class="panel-body" >

                     <a href=" <c:url  value="/productCard">
        <c:param name="id" value="${product.id}"/> </c:url>">

                         <img  src="images/<c:out value="${product.pictureName}" />" alt="skirt-5185571-1920" border="0" class="img-responsive"
                     style=" height: 350px; width: 250px" alt="Image"></a>

                 </div>
                 <div class="panel-footer">
                     <c:out value="${product.pris}" /> zł
                 </div>
             </div>


         </div>


    </c:forEach>
</c:if>

     </div>
 </div><br>

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

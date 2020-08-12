<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>

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
</style>

</head>

<body>

<jsp:include page="/WEB-INF/fragments/header.jspf"/>


<div class="container">
    <div class="row">

        <div class="col-md-9">

         <div class="col-md-3 col-sm-4 col-xs-6"><img class="img-responsive" src="http://th03.deviantart.net/fs70/200H/f/2010/256/0/9/painting_of_nature_by_dhikagraph-d2ynalq.jpg" /></div>
        <div class="col-md-3 col-sm-4 col-xs-6"><img class="img-responsive" src="http://2.bp.blogspot.com/-H6MAoWN-UIE/TuRwLbHRSWI/AAAAAAAABBk/89iiEulVsyg/s400/Free%2BNature%2BPhoto.jpg" /></div>
        <div class="col-md-3 col-sm-4 col-xs-6">





<div class="card" >
    <div class="card-body">




        <p class="card-text" style="font-size: xx-large"><c:out value="${product.pris}" /> zł</p>
        <br>
        <br>
        <p class="card-text" style="font-size: x-large; font-weight: bold;"><c:out value="${product.name}" /></p>

        <p class="card-text" style="font-size: medium; ;"><c:out value="${product.description}" /></p>


        <br>
        <br>
    </div>

    <div class="card-footer">
        <a href="#" type="button"  class="btn btn-block" style="border-color: #ff9999; background-color: white; color: #ff9999;"
        >Zapytaj o przedmiot</a>

        <a href="#" type="button" id="pinkButton" class="btn btn-block" >Dodaj do ulubionych</a>

    </div>
    </div>


        </div>
    </div>
</div>
</div>




<%@ include file ="/WEB-INF/fragments/footer.jspf" %>

</body>
</html>  
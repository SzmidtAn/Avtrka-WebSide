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



            <form class="form-signin row" method="post" action="add" enctype="multipart/form-data">

                <span class="login100-form-title"> Sprzedaj ubranie </span>
                <br>

                <div class="wrap-input100 validate-input" data-validate = "Title is required">
                    <label for="productName">
                        Tytuł
                    </label>
                        <input type="text" class="form-control" name="inputName"
                               id="productName" placeholder="Wprowadź nazwę produktu"/>

                </div>

                <br>



                <div>

                <label for="category"></label>
                <select  class="custom-select " id="category" name="inputCategory"
                         data-width="auto">
                    <option disabled selected>Wybierz kategorię</option>
                    <option >Kobiety</option>
                    <option >Mężczyźni</option>
                    <option >Dzieci</option>
                </select>
                </div>
                <br>

                <div>

                    <select required class="custom-select"  name="inputBrand"
                            id="brand" data-style="btn-warning" >
                <label for="brand"></label>
                        <option disabled selected>Dodaj markę</option>
                        <option >Reserved</option>
                        <option >H&M</option>
                        <option >Inne</option>
                    </select>
                <br>
                </div>

                <div>

                    <label for="conditio"></label>
                    <select  class="custom-select " id="conditio" name="inputCondition"
                             data-width="auto">
                        <option disabled selected>Określ stan ubrania</option>
                        <option >Nowe</option>
                        <option >Używane</option>
                        <option >Dobry</option>
                    </select>
                </div>




                <br>
                <br>



            <div class="wrap-input100 validate-input" data-validate = "Description is required">
                    <label for="description">Opisz swój przedmiot:</label>
                    <textarea class="form-control" id="description"
                              rows="15" name="description"
                              placeholder="np. Założone kilka razy, rozmiar zawyżony" required autofocus></textarea>
                </div>



                <br>
                <br>




                <div>

                    <label>Wgraj pliki</label><br>
                    <input type="file" name="fileName"  accept="image/jpeg,image/gif">

                    <br>
                    <input type="file" name="fileName2"/>
                    <br>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Pris is required">
                    <label for="pris">Cena</label>
                    <input type="text"  step="any" min="0" id="pris" class="form-control"
                           name="inputPris" placeholder="0,00 zł" required autofocus >
                </div>

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



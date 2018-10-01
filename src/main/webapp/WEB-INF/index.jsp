<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <title>Add bird</title>
</head>
<body>
<div class="container-fluid">
    <h4>Add Bird</h4>
    <h5>Можно добавить следующие типы птиц: duck,chicken,quail,turkey</h5>
    <form action="/add">
        <div class="form group">
            <div class="col-4">
                <%--<select name="typeBird">--%>
                <%--<option>duck</option>--%>
                <%--<option>chicken</option>--%>
                <%--<option>quail</option>--%>
                <%--<option>turkey</option>--%>
                <%--</select>--%>
                <label for="typeBird" class="col-form-label-sm">Type:</label>
                <input type="text" class="form-control col-form-label-sm" id="typeBird" name="typeBird"
                       placeholder="enter type">
                <label for="totalWeight" class="col-form-label-sm">Weight:</label>
                <input type="text" class="form-control col-form-label-sm" id="totalWeight" name="totalWeight"
                       placeholder="enter weight">
                <label for="totalPrice" class="col-form-label-sm">Price per unit:</label>
                <input type="text" class="form-control col-form-label-sm" id="totalPrice" name="totalPrice"
                       placeholder="enter price per unit">
            </div>
        </div>
        <br>
        <input class=" btn btn-outline-primary btn-sm" type="submit" value="Add Bird">
    </form>
    <h4>Скидки:</h4>
    Курица: от 20 до 40 кг = -1$, больше 40 кг = -2$
    <br>
    Утка: от 15 до 25 кг = -1$, больше 25 кг = -2$
    <br>
    Индюк: от 5 до 20 кг = -1$, больше 20 кг = -2$
    <br>
    Перепёлка: от 18 до 30 кг = -1$, больше 40 кг = -2$

    <br>
    <c:if test="${!empty birdList}">
    <h4>All Bird</h4>
    <div class="row">
        <div class="col-6">
            <div class="table-responsive-sm">
                <table class="table table-sm table-bordered">
                    <thead>
                    <tr align="center" class="table-active">
                        <th>Type</th>
                        <th>Weight</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${birdList}" var="bird">
                        <tr align="center">
                            <td>${bird.typeBird}</td>
                            <td>${bird.totalWeight}</td>
                            <td>${bird.totalPrice}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
<form action="/getAllBirdToShop">
    <div class="form group">
        <div class="col-4">
            <input class=" btn btn-outline-primary btn-sm" type="submit" value="Get all bird to shop">
        </div>
    </div>
</form>
</body>
</html>

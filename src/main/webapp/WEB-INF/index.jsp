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
<c:if test="${price==0}">
    <br>
    <h2>Установить цену за 1 кг птицы</h2>
    <form action="/set">
        <div class="form group">
            <div class="col-6">
            </div>
        </div>
        <br>
        <input class=" btn btn-outline-primary btn-sm" type="submit" value="SET PRICE">
    </form>
</c:if>
<c:if test="${price>0}">
<h4>Add Bird</h4>
    <br>
    <form action="/add">
        <div class="form group">
            <div class="col-6">
                <%--<label for="typeBird" class="col-form-label-sm">Type:</label>--%>
                <%--<input type="text" class="form-control col-form-label-sm" id="typeBird" name="typeBird"--%>
                <%--placeholder="enter type">--%>
                <select name="typeBird">
                    <option>duck</option>
                    <option>eagl</option>
                    <option>parrot</option>
                </select>
                    <br>
                    <br>
                <label for="weight" class="col-form-label-sm">Weight:</label>
                <input type="text" class="form-control col-form-label-sm" id="weight" name="weight"
                       placeholder="enter weight">
                <label for="health" class="col-form-label-sm">Health:</label>
                <input type="text" class="form-control col-form-label-sm" id="health" name="health"
                       placeholder="enter health">
            </div>
        </div>
        <br>
        <input class=" btn btn-outline-primary btn-sm" type="submit" value="Add Bird">
    </form>
    <br>

    <c:if test="${!empty birdList}">
    <h4>All Bird</h4>
    <div class="row">
        <div class="col-6">
                <%--<c:if test="${!empty studentList}">--%>
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
                            <td>${bird.weight}</td>
                            <td>${bird.pricePerUnit}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
</c:if>
</body>
</html>

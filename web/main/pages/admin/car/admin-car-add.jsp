<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="main/css/admin-page.css" rel="stylesheet">
    <title>Admin</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-admin.jsp" %>
    <section class="body">
        <div class="container">
            <div class="input">
                <form action="${pageContext.request.contextPath}/admin/car/add/post" method="POST">
                    <div class="item">
                        <label for="name">Имя категории</label>
                        <input type="text" id="name" name="name" placeholder="Текст" value="${car.getName()}">
                    </div>
                    <div class="item">
                        <label for="price">Цена</label>
                        <input type="text" id="price" name="price" placeholder="Текст" value="${car.getPrice()}">
                    </div>
                    <div class="item">
                        <label for="jpg">Фото</label>
                        <input type="text" id="jpg" name="jpg" placeholder="Текст" value="${car.getJpg()}">
                    </div>
                    <div class="item">
                        <label for="desc">Описание</label>
                        <input type="text" id="desc" name="desc" placeholder="Текст" value="${car.getDesc()}">
                    </div>
                    <div class="item">
                        <label for="label_name">Марки машин</label>
                        <div class="select">
                            <select name="label_name" class="form__month form__input small">
                                <c:forEach items="${allLabels}" var="label">
                                    <option value = "<c:out value="${label.getId()}"/>" name="<c:out value="${label.getName()}"/>">
                                        <c:out value="${label.getName()}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="item">
                        <label for="level_name">Классы машин</label>
                        <div class="select">
                            <select name="level_name" class="form__month form__input small">
                                <c:forEach items="${allLevels}" var="level">
                                    <option value = "<c:out value="${level.getId()}"/>" name="<c:out value="${level.getName()}"/>">
                                        <c:out value="${level.getName()}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="edit-three__set">
                        <button class="add" type="submit">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-admin.jsp" %>
</div>
</body>
</html>
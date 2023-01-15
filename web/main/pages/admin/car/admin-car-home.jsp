<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/admin-page.css">
    <title>Admin</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-admin.jsp" %>
    <section class="body">
        <div class="container">
            <div class="edit">
                <div class="edit__item head">
                    <p class="small">№</p>
                    <p class="small">Имя</p>
                    <p class="small">Цена(за час)</p>
                    <p class="small">Фото</p>
                    <p class="big">Описание</p>
                    <p class="small">Марка</p>
                    <p class="small">Качество</p>
                    <a href="${pageContext.request.contextPath}/admin/car/add" class="header__link">
                        <p class="add">Добавить</p>
                    </a>
                </div>
                <c:forEach items="${allCars}" var="car">
                    <div class="edit__item">
                        <p class="small"><c:out value="${car.getId()}"/></p>
                        <p class="small"><c:out value="${car.getName()}"/></p>
                        <p class="small"><c:out value="${car.getPrice()}"/></p>
                        <p class="small"><c:out value="${car.getJpg()}"/></p>
                        <p class="big"><c:out value="${car.getDesc()}"/></p>
                        <p class="small"><c:out value="${car.getLabel().getName()}"/></p>
                        <p class="small"><c:out value="${car.getLevel().getName()}"/></p>
                        <div class="edit__set">
                            <a href="${pageContext.request.contextPath}/admin/car/update?id=${car.getId()}"
                               class="header__link">
                                <input type="submit" class="edit_btn" value="Редактировать"/>
                            </a>
                            <form method="POST"
                                  action="${pageContext.request.contextPath}/admin/car/delete?id=${car.getId()}">
                                <input type="submit" class="delete" value="Удалить">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-admin.jsp" %>
</div>
</body>
</html>
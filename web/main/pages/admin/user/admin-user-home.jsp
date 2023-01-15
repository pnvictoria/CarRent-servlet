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
                    <p class="small">Фамилия</p>
                    <p class="small">Пол</p>
                    <p class="small">Дата Рождение</p>
                    <p class="big">Почта</p>
                    <p class="small">Роль</p>
                </div>
                <c:forEach items="${allUsers}" var="user">
                    <div class="edit__item">
                        <p class="small"><c:out value="${user.getId()}"/></p>
                        <p class="small"><c:out value="${user.getName()}"/></p>
                        <p class="small"><c:out value="${user.getSurname()}"/></p>
                        <p class="small"><c:out value="${user.isSex()}"/></p>
                        <p class="small"><c:out value="${user.getDate()}"/></p>
                        <p class="big"><c:out value="${user.getEmail()}"/></p>
                        <p class="small"><c:out value="${user.getRole().getName()}"/></p>
                        <div class="edit__set">
                            <form action="${pageContext.request.contextPath}/admin/user/delete?id=${user.getId()}" method="POST">
                                <input class="delete" type="submit" value="Удалить"></input>
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
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
            <div class="edit-three">
                <div class="edit__item head">
                    <p class="small">№</p>
                    <p class="big">Пользователь</p>
                    <p class="big">Телефон</p>
                    <p class="big">Машина</p>
                    <p class="big">Состояние</p>
                </div>

                <c:forEach items="${allOrders}" var="order">
                    <div class="edit__item">
                        <p class="small"><c:out value="${order.getId()}"/></p>
                        <p class="big"><c:out value="${order.getUser().getName()}"/></p>
                        <p class="big"><c:out value="${order.getPhone()}"/></p>
                        <p class="big"><c:out value="${order.getCar().getName()}"/></p>
                        <p class="big"><c:out value="${order.getState().getName()}"/></p>
                        <div class="edit__set">
                            <form method="POST"
                                  action="${pageContext.request.contextPath}/admin/order/approve?id=${order.getId()}">
                                <input type="submit" class="edit_btn" value="Принять">
                            </form>
                            <form method="POST"
                                  action="${pageContext.request.contextPath}/admin/order/block?id=${order.getId()}">
                                <input type="submit" class="delete" value="Отказ">
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
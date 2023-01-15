<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header-auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/items.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/user-page.css">
    <title>User page</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-user.jsp" %>
    <section class="body">
        <div class="container">
            <section class="body">
                <c:forEach items="${orderList}" var="order">
                    <div class="items">
                        <div class="items__item">
                            <div class="rent">
                                <p><span>Car: </span> <c:out value="${order.getCar().getName()}"/></p>
                                <p><span>Phone: </span> <c:out value="${order.getPhone()}"/></p>
                                <p><span>State: </span> <c:out value="${order.getState().getName()}"/></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </section>
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
</div>
</body>
</html>
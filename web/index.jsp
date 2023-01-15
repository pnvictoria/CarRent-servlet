<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="main/css/footer.css" rel="stylesheet">
    <link href="main/css/header-auth.css" rel="stylesheet">
    <link href="main/css/global.css" rel="stylesheet">
    <link href="main/css/items.css" rel="stylesheet">
    <link href="main/css/global.css" rel="stylesheet">
    <title>CarRent</title>
</head>
<body>
<div class="wrapper">
    <% User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.getRole().getId() == 1) { %>
    <%@ include file="/main/pages/comn/header-admin.jsp" %>
    <% } else if (user != null && user.getRole().getId() == 2) { %>
    <%@ include file="/main/pages/comn/header-user.jsp" %>
    <% } else { %>
    <%@ include file="/main/pages/comn/header-guest.jsp" %>
    <%} %>
    <section class="body">
        <section>
            <div class="container">
                <div class="filter">
                    <form action="${pageContext.request.contextPath}/filter/car/post" method="POST">
                        <div class="filter__wrapper">
                            <div class="filter__params">
                                <input type="text" name="name" placeholder="поиск за именем">
                                <div class="select">
                                    <select name="label_id">
                                        <option value="">Все</option>
                                        <c:forEach items="${allLabels}" var="label">
                                            <option value="<c:out value="${label.getId()}"/>"
                                                    name="<c:out value="${label.getName()}"/>">
                                                <c:out value="${label.getName()}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="select">
                                    <select name="level_id">
                                        <option value="">Все</option>
                                        <c:forEach items="${allLevels}" var="level">
                                            <option value="<c:out value="${level.getId()}"/>"
                                                    name="<c:out value="${level.getName()}"/>">
                                                <c:out value="${level.getName()}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="filter__price">
                                <p>Поиск за ценой</p>
                                <div>
                                    <input type="text" name="price_from" placeholder="от">
                                    <input type="text" name="price_to" placeholder="до">
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="Фильтрация">
                    </form>
                </div>
            </div>
        </section>

        <section>
            <c:forEach items="${filterList}" var="filter">
                <div class="items">
                    <div class="items__item">
                        <div class="items__img">
                                <%--<img src="${pageContext.request.contextPath}/main/images/oil.png" alt="oil">--%>
                        </div>
                        <div class="items__info">
                            <h3><c:out value="${filter.getName()}"/></h3>
                            <p><span>Level: </span> <c:out value="${filter.getLevel().getName()}"/></p>
                            <p><span>Label: </span> <c:out value="${filter.getLabel().getName()}"/></p>
                            <p><c:out value="${filter.getDesc()}"/></p>
                        </div>
                        <div class="items__price">
                            <div>
                                <p><span><c:out value="${filter.getPrice()}"/>  UAN </span>/ 1h</p>
                            </div>
                            <div>
                                <% if (user != null && user.getRole().getId() == 2) { %>
                                <a href="${pageContext.request.contextPath}/user/car-rent?carId=${filter.getId()}">
                                    <div class="items__next">
                                        <svg width="8" height="11" viewBox="0 0 8 11" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <line x1="1.54344" y1="1.02639" x2="6.71428" y2="6.19723" stroke="white"
                                                  stroke-width="2.33947" stroke-linejoin="round"></line>
                                            <line x1="6.22117" y1="5.02024" x2="1.54222" y2="9.69919" stroke="white"
                                                  stroke-width="2.33947" stroke-linejoin="round"></line>
                                        </svg>
                                    </div>
                                    <p>RENT</p>
                                </a>
                                <%} %>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
    </section>
    <% if (user != null && user.getRole().getId() == 1) { %>
    <%@ include file="/main/pages/comn/footer-admin.jsp" %>
    <% } else { %>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
    <%} %>
</div>
</body>
</html>
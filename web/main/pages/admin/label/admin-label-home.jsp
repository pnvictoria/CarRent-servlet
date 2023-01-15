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
                <div class="edit-three__item head">
                    <p class="small">№</p>
                    <p class="big">Имя категории</p>
                    <p class="small"></p>
                    <a href="${pageContext.request.contextPath}/admin/label/add" class="header__link">
                        <p class="add">Добавить</p>
                    </a>
                </div>
                <c:forEach items="${allLabels}" var="label">
                    <div class="edit-three__item">
                        <p class="small"><c:out value="${label.getId()}"/></p>
                        <p class="big"><c:out value="${label.getName()}"/></p>
                        <p class="small"></p>
                        <div class="edit-three__set">
                            <a href="${pageContext.request.contextPath}/admin/label/update?id=${label.getId()}"
                               class="header__link">
                                <input type="submit" class="edit_btn" value="Редактировать"/>
                            </a>
                            <form method="POST"
                                  action="${pageContext.request.contextPath}/admin/label/delete?id=${label.getId()}">
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
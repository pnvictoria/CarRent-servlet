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
            <div class="about">
                <div class="about__wrapper">
                    <%if (userObj.getAvatar() == null || userObj.getAvatar().isEmpty()) {%>
                    <img src="${pageContext.request.contextPath}/main/images/avatar.png" alt="avatar"
                         class="about__avatar">
                    <%} else {%>
                    <img src="${pageContext.request.contextPath}/main/upload/${user.getAvatar()}" alt="avatar"
                         class="about__avatar" width="250" height="250">
                    <%}%>
                    <div class="about__info">
                        <h1>${user.getName()} ${user.getSurname()}</h1>
                        <p>Украина, соискатель</p>
                    </div>
                </div>
            </div>
            <div class="setting">
                <div class="setting__wrapper">
                    <h2>Настройки</h2>
                    <div class="setting__images" hidden>
                        <div class="setting__img-info">
                            <%if (userObj.getAvatar() == null || userObj.getAvatar().isEmpty()) {%>
                            <img src="${pageContext.request.contextPath}/main/images/avatar.png" alt="avatar"
                                 class="about__avatar">
                            <%} else {%>
                            <img src="${pageContext.request.contextPath}/main/upload/${user.getAvatar()}" alt="avatar"
                                 class="about__avatar" width="250" height="250">
                            <%}%>
                            <p>./avatar.jpg</p>
                        </div>
                        <span>Изменить</span>
                    </div>
                    <div class="setting__info">
                        <div class="setting__item">
                            <p>Имя</p>
                            <p>${user.getName()} ${user.getSurname()}</p>
                            <span>Изменить</span>
                        </div>
                        <div class="setting__item">
                            <p>Почта</p>
                            <p>${user.getEmail()}</p>
                            <span>Изменить</span>
                        </div>
                        <div class="setting__item">
                            <p>Фото</p>
                            <form action="${pageContext.request.contextPath}/upload/post" method="post" class="user_photo"
                                  enctype="multipart/form-data">
                                <input type="file" name="file"/>
                                <input type="submit" value="Upload"/>
                            </form>
                        </div>
                    </div>
                    <div class="setting__discard">
                        <p><a href="${pageContext.request.contextPath}/sign-out">Выйти из аккаунта</a></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
</div>
</body>
</html>
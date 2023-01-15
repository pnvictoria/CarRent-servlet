<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/sign-in.css">
    <title>Sign In</title>
</head>
<body>



    <div class="wrapper">
        <%@ include file="/main/pages/comn/header-guest.jsp" %>
        <section class="body">
            <div class="container sign-in">
                <div class="background">
                    <img src="${pageContext.request.contextPath}/main/images/background.webp" alt="background" draggable="false">
                </div>
                <div class="form-wrap sign-in">
                    <p class="sign-up">Вход</p>

                    <form action="${pageContext.request.contextPath}/sign-in/post" method="POST" class="form sign-in">
                        <div class="form__mail item">
                            <label for="email"><span>Электронная почта</span></label>
                            <input class="form__input big" placeholder="Текст" name="email" id="email">
                        </div>
                        <div class="form__pswd item">
                            <label for="password"><span>Пароль</span></label>
                            <input class="form__input big" placeholder="Текст" type="password" name="password" id="password">
                        </div>
                        <div class="form__submit item">
                            <button class="form__btn green" type="submit" value="login">Войти</button>
                        </div>
                    </form>

                </div>
            </div>
        </section>
        <%@ include file="/main/pages/comn/footer-user.jsp" %>
    </div>
</body>
</html>
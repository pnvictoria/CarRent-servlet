<%@ page import="entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/sign-in.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/items.css" >

    <title>Sign In</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-user.jsp" %>
    <section class="body">
        <section>
            <div class="items">
                <div class="items__item">
                    <div class="items__img">
                        <%--<img src="${pageContext.request.contextPath}/main/images/oil.png" alt="oil">--%>
                    </div>
                    <div class="items__info">
                        <h3>${car.getName()}</h3>
                        <p><span>Level: </span> ${car.getLevel().getName()}</p>
                        <p><span>Label: </span> ${car.getLabel().getName()}</p>
                        <p>${car.getDesc()}</p>
                    </div>
                    <div class="items__price">
                        <div>
                            <p><span>${filter.getPrice()} UAN </span>/ 1h</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <hr>
        <section>
            <div class="items">
                <div class="items__item">
                    <div class="container sign-in">
                        <form action="${pageContext.request.contextPath}/user/car-rent/post" method="POST"
                              class="form sign-in">
                            <div class="form__mail item">
                                <input class="form__input big" name="car_id" id="car_id" value="${car.getId()}" type="hidden">
                            </div>
                            <div class="form__mail item">
                                <label for="name"><span>Имя</span></label>
                                <input class="form__input big" name="name" id="name" value="${user.getName()}">
                            </div>
                            <div class="form__mail item">
                                <label for="surname"><span>Фамилия</span></label>
                                <input class="form__input big" name="name" id="surname" value="${user.getSurname()}">
                            </div>
                            <div class="form__mail item">
                                <label for="phone"><span>Номер телефона</span></label>
                                <input class="form__input big" placeholder="Номер телефона" name="phone" id="phone"
                                       required>
                            </div>
                            <div class="form__submit item">
                                <button class="form__btn green" type="submit" value="login">Отправить запрос</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </section>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
</div>
</body>
</html>
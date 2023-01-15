<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/sign-up.css">
    <title>Sign Up</title>
</head>
<body>
    <div class="wrapper">
        <%@ include file="/main/pages/comn/header-guest.jsp" %>
        <section class="body">
            <div class="container">
                <div class="background">
                    <img src="${pageContext.request.contextPath}/main/images/background.webp" alt="background" draggable="false">
                </div>
                <div class="form-wrap">
                    <p class="sign-up">Регистрация</p>
                    <form action="${pageContext.request.contextPath}/sign-up/post" method="POST" class="form">
                        <div class="form__name item">
                            <label for="name"><span>Имя</span></label>
                            <input class="form__input big" placeholder="Текст" type="text" id="name" name="name" required>
                        </div>
                        <div class="form__second-name item">
                            <label for="surname"><span>Фамилия</span></label>
                            <input class="form__input big" placeholder="Текст" type="text" id="surname" name="surname" required>
                        </div>
                        <div class="form__sex item">
                            <span>Пол</span>
                            <div class="form__sex-wrap">
                                <div>
                                    <input type="radio" class="radio__female-input" id="female" name="female" value="female">
                                    <label class="radio__female-label" for="female">
                                        <p class="radio sex">Женский</p>
                                    </label>
                                </div>
                                <div>
                                    <input type="radio" class="radio__male-input" id="male" name="male" value="male">
                                    <label class="radio__male-label" for="male">
                                        <p class="radio sex">Мужской</p>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form__birthday item">
                            <label for="day"><span>Дата рождения</span></label>
                            <div class="form__birthday-input">
                                <input class="form__input small" placeholder="День" type="text" id="day" name="day" required>
                                <div class="select">
                                    <select class="form__month form__input small">
                                        <option selected disabled>Месяц</option>
                                        <option value="Январь">Январь</option>
                                        <option value="Февраль">Февраль</option>
                                        <option value="Март">Март</option>
                                        <option value="Апрель">Апрель</option>
                                        <option value="Май">Май</option>
                                        <option value="Июнь">Июнь</option>
                                        <option value="Июль">Июль</option>
                                        <option value="Август">Август</option>
                                        <option value="Сентябрь">Сентябрь</option>
                                        <option value="Октябрь">Октябрь</option>
                                        <option value="Ноябрь">Ноябрь</option>
                                        <option value="Декабрь">Декабрь</option>
                                    </select>
                                </div>
                                <input class="form__input small" placeholder="Год" type="text" id="year" name="year" required>
                            </div>
                        </div>
                        <div class="form__mail item">
                            <label for="email"><span>Электронная почта</span></label>
                            <input class="form__input big" placeholder="Текст" type="email" name="email" id="email">
                        </div>
                        <div class="form__pswd item">
                            <label for="password"><span>Пароль</span></label>
                            <input class="form__input big" placeholder="Текст" type="password" name="password" id="password">
                        </div>
<%--                        <div class="form__acc-type item">--%>
<%--                            <span>Тип аккаунта</span>--%>
<%--                            <div class="form__type-wrap">--%>
<%--                                <label>--%>
<%--                                    <input type="radio" name="type" value="employer"><p class="radio">Работодатель</p>--%>
<%--                                </label>--%>
<%--                                <label>--%>
<%--                                    <input type="radio" name="type" value="applicant"><p class="radio">Работодатель 2</p>--%>
<%--                                </label>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="form__submit item">
                            <button class="form__btn green" type="submit">Отправить</button>
                            <button class="form__btn gray" type="reset">Отмена</button>
                        </div>
                        <p>Регистрируясь, Вы соглашаетесь с <a href="#">Пользовательским соглашением</a></p>
                    </form>
                </div>
            </div>
        </section>
        <%@ include file="/main/pages/comn/footer-user.jsp" %>
    </div>
</body>
</html>
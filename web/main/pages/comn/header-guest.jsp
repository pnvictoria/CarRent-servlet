<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header.css" type="text/css"/>
    <title>Sign Up</title>
</head>
<body>
    <header class="header">
        <div class="header__container">
            <nav class="header__nav">
                <div class="header__logo">
                    <svg width="13" height="19" viewBox="0 0 13 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.5232 5.7838C11.8535 5.7838 12.1103 5.92503 12.2937 6.20748C12.4405 6.48993 12.4405 6.77239 12.2937 7.05484L5.83628 17.788C5.65283 18.0705 5.396 18.2117 5.06579 18.2117C4.77227 18.2117 4.51544 18.1058 4.36868 17.8939C4.18523 17.6821 4.14854 17.4349 4.22192 17.1525L5.90966 10.303H1.54354C1.25002 10.303 1.02988 10.2324 0.883122 10.0206C0.699671 9.84405 0.626291 9.63221 0.662981 9.34976L1.83706 0.876202C1.83706 0.664363 1.94713 0.487831 2.13058 0.346605C2.27734 0.205379 2.49749 0.134766 2.71763 0.134766H8.001C8.29452 0.134766 8.51466 0.275992 8.69811 0.487831C8.84487 0.699669 8.91825 0.946815 8.84487 1.19396L7.30389 5.7838H11.5232Z"
                              fill="white"></path>
                    </svg>
                </div>
                <a href="${pageContext.request.contextPath}/" class="header__link">Главная</a>
            </nav>
            <div class="header__sign">
                <a href="${pageContext.request.contextPath}/sign-in" class="header__btn green">Вход</a>
                <a href="${pageContext.request.contextPath}/sign-up" class="header__btn white">Регистрация</a>
            </div>
        </div>
    </header>
</body>
</html>
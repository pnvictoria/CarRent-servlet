<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/admin-page.css">
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
            <a href="${pageContext.request.contextPath}/admin/user/home" class="header__link">Пользователи</a>
            <a href="${pageContext.request.contextPath}/admin/role/home" class="header__link">Роли</a>
            <a href="${pageContext.request.contextPath}/admin/car/home" class="header__link">Машини</a>
            <a href="${pageContext.request.contextPath}/admin/level/home" class="header__link">Классы машин</a>
            <a href="${pageContext.request.contextPath}/admin/label/home" class="header__link">Марки машин</a>



            <a href="${pageContext.request.contextPath}/admin/order/home" class="header__link">Заказы</a>

        </nav>
        <a href="${pageContext.request.contextPath}/sign-out">
            <div class="header__avatar">
                <svg width="42" height="43" viewBox="0 0 42 43" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <circle cx="21" cy="21.0073" r="20.5" stroke="#322B57"></circle>
                    <path d="M25.5723 12.7505H18.0723C17.3763 12.7513 16.7091 13.0281 16.2169 13.5202C15.7248 14.0123 15.448 14.6796 15.4473 15.3755V20.2505H22.6365L20.1671 17.7807C20.0324 17.6389 19.9584 17.4501 19.9609 17.2545C19.9634 17.059 20.0422 16.8721 20.1805 16.7338C20.3188 16.5955 20.5057 16.5167 20.7012 16.5142C20.8968 16.5117 21.0856 16.5857 21.2274 16.7204L24.9774 20.4704C25.118 20.611 25.1969 20.8017 25.1969 21.0005C25.1969 21.1994 25.118 21.3901 24.9774 21.5307L21.2274 25.2807C21.0856 25.4154 20.8968 25.4894 20.7012 25.4869C20.5057 25.4844 20.3188 25.4056 20.1805 25.2673C20.0422 25.129 19.9634 24.9421 19.9609 24.7466C19.9584 24.551 20.0324 24.3622 20.1671 24.2204L22.6365 21.7505H15.4473V26.6255C15.4473 28.1279 17.0312 29.2505 18.4473 29.2505H25.5723C26.2682 29.2498 26.9355 28.973 27.4276 28.4809C27.9197 27.9888 28.1965 27.3215 28.1973 26.6255V15.3755C28.1965 14.6796 27.9197 14.0123 27.4276 13.5202C26.9355 13.0281 26.2682 12.7513 25.5723 12.7505Z"
                          fill="#322B57"></path>
                    <path d="M10.9474 20.2501C10.7485 20.2501 10.5577 20.3292 10.4171 20.4698C10.2764 20.6105 10.1974 20.8012 10.1974 21.0001C10.1974 21.199 10.2764 21.3898 10.4171 21.5305C10.5577 21.6711 10.7485 21.7501 10.9474 21.7501H15.4474V20.2501H10.9474Z"
                          fill="#322B57"></path>
                </svg>
            </div>
        </a>
    </div>
</header>

</body>
</html>
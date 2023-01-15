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
    <title>ERROR</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-guest.jsp" %>
    <section class="body">
        <div class="error">
            <img src="${pageContext.request.contextPath}/main/images/error.png" alt="background" draggable="false">
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
</div>
</body>
</html>
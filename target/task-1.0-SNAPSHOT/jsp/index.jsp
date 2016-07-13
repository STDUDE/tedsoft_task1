<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная страница</title>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.5.1.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <hr>
    <h2 class = "content bgcolor-4">Ключевое слово</h2>
    <hr>
    <input type="text" size="40" class = "info" id = "keyword" name="keyword">
    <hr>
    <input type="button" name="turn_button" id = "turn_button" value="Включить" class="button">

    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>

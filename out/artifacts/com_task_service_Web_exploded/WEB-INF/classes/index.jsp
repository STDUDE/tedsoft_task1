<%@ page import="com.task.domain.Classes" %>
<%@ page import="com.task.domain.Keywords" %>
<%@ include file="css/style.css"%>
<%@ include file="js/main.js"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная страница</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<table align="center">
    <caption>Сотрудники</caption>
    <thead>
    <tr>
        <td>ФИ сотрудника </td>
        <td>Дата наема</td>
        <td>Опыт работы, лет</td>
        <td>Отдел</td>
        <td>Должность</td>
    </tr>
    </thead>
    <tbody>
    <hr>
    <h2 class = "content bgcolor-4">Ключевое слово</h2>
    <input type="text" size="40" class = "info" name="keyword">
    <input type="submit" value="Включить/выключить">
    <hr>
    </tbody>
</table>
</body>
</html>

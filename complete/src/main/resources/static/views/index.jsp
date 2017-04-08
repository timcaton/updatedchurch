<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="church-app">
<head>
    <meta charset="utf-8">
    <title>Church</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:import url="css.jsp"/>
</head>
<body>

<div class="generic-container">
    <div ui-view=""></div>
    <!-- Libraries -->
    <c:import url="libraries.jsp"/>

    <!-- Utilities -->
    <c:import url="utilities.jsp"/>

    <!-- Services -->
    <c:import url="services.jsp"/>

    <!-- Controllers -->
    <c:import url="controllers.jsp"/>

    <!-- Directives -->
    <c:import url="directives.jsp"/>

    <!-- Filters -->
    <c:import url="filters.jsp"/>

    <!-- Models -->
    <c:import url="models.jsp"/>

    <!-- App -->
    <c:import url="app.jsp"/>

    <!-- States -->
    <c:import url="states.jsp"/>

</div>
</body>

</html>

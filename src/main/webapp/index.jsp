<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <style>
        <%@include file="/WEB-INF/css/main.css"%>
    </style>
</head>
<body>
<div class="container header_container">
    <div class="head_container">
        <h1 class="main_title">Задания второй недели стажировки</h1>
    </div>
</div>
<div class="container nav_container">
    <nav class="nav">
        <ul class="nav_list">
            <li class="direction_item">
                <a href="first/home" class="nav_link">
                    Home (without parameters)
                </a>
                <a href="first/home?name=Viacheslav" class="nav_link">
                    Home (with parameters)
                </a>
            </li>
            <li>
                <a class="nav_link" href="calc/calculator">
                    Calculator
                </a>
            </li>
            <li>
                <a class="nav_link" href="guns">
                    Guns
                </a>
            </li>
            <li>
                <a class="nav_link" href="office">
                    Office
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>

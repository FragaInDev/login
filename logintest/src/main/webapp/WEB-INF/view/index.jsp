<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Efetue o Login</h1>
    <br/>
    <form action="index" method= "post">
        <table>
            <tr>
                <input class="input" id="email" name="email" placeholder="Digite seu email">
            </tr>
            <tr>
                <input type="password" id="senha" name="senha" placeholder="Digite sua senha">
            </tr>
            <tr>
                <input type="submit" id="btn" name="btn" value="logar">
            </tr>
        </table>
    </form>
</body>
</html>

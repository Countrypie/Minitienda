<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="carrito" class="carrito.CarritoBean" scope="session"/>
<html>
    <head>
        <title>Caja</title>
        <meta charset="UTF-8">
        <style>
            input[type=image] {
                border: 2px solid transparent;
            }
            input[type=image]:hover {
                border: 2px solid purple;
            }
            .informacion td{
                text-align: center;
            }
        </style>
    </head>
    <body bgcolor="#FDF5E6">
        <h1 align="center">Caja</h1>
        <form action="finalizar">
            <table class="informacion" align="center" border="1" bgcolor="white">
                <tr><th>INFORMACIÓN DEL PEDIDO</th></tr>
                <tr><td>Importe total</td><td>
                    <fmt:formatNumber value="${carrito.importe}" type="number" maxFractionDigits="2" />€
                </td></tr>
                <tr><td>Cuenta asociada</td><td>${carrito.propietario}</td></tr>
                <tr><td>Número de pedido</td><td>${carrito.pedido}</td></tr>
            </table>
            <hr>
            <div align="center">
                <input type="image" name="pagar" src="./Imagenes/partitura.png" width="200px" alt="Pagar y volver a la página principal">
                <br>Pagar y volver a la página principal
            </div>
        </form>
    </body>
</html>
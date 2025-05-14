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
            .caja_confirmacion {
                position: fixed;
                top: calc(50% - 250px);
                left: calc(50% - 170px);
                background-color: #c0b398;
                border: solid black 3px;
                padding: 20px;
                border-radius: 10px;
                width: 300px;
            }
            .caja_confirmacion h2{
                font-size: 30px;
                text-align: center;
            }
            input[type="submit"]{
                display: block;
                font-size: 20px;
                margin: 20px auto 5px;
                width: auto;
            }
        </style>
    </head>
    <body bgcolor="#FDF5E6">
        <h1 align="center">Caja</h1>
       <form action="pagar">
            <table class="informacion" align="center" border="1" bgcolor="white">
                <tr><th>Total a pagar</th></tr>
                <tr><td><fmt:formatNumber value="${carrito.importe}" type="number" maxFractionDigits="2" />€</td></tr>
            </table>
            <hr>
            <div align="center">
                <input type="image" name="pagar" src="./Imagenes/partitura.png" width="200px" alt="Pagar la selección">
                <br>Pagar la selección
            </div>
        </form>
    </body>
</html>

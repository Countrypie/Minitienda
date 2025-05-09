<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="carrito" class="carrito.CarritoBean" scope="session"/>
<html>
    <head>
        <title>Carrito de la compra</title>
        <meta charset="UTF-8">
        <style>
            input[type=image] {
                border: 2px solid transparent;
            }
            input[type=image]:hover {
                border: 2px solid purple;
            }
            .caja_iniciar_sesion {
                position: fixed;
                top: calc(50% - 200px);
                left: calc(50% - 190px);
                background-color: #c0b398;
                border: solid black 3px;
                padding: 20px;
                border-radius: 10px;
                width: 300px;
            }
            .caja_iniciar_sesion h2{
                font-size: 30px;
                text-align: center;
            }
            .caja_iniciar_sesion input{
                font-size: 20px;
                width: 90%;
                margin: 2px;
            }
            .caja_iniciar_sesion input.boton{
                font-size: 20px;
                margin: 5px;
                width: auto;
            }
            .caja_iniciar_sesion input.boton_crear{
                display: block;
                font-size: 20px;
                margin: 20px auto 5px;
                width: auto;
            }
        </style>
    </head>
    <body bgcolor="#FDF5E6">
        <h1 align="center">Carrito de la compra</h1>
        <form action="eliminar">
            <table align="center" border="1" bgcolor="white">
                <tr>
                    <th>TITULO DEL CD</th>
                    <th>Cantidad</th>
                    <th>Importe</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="cd" items="${carrito.cds}">
                    <tr>
                        <td>${cd.key}</td>
                        <td align="center">${cd.value.cantidad}</td>
                        <td align="right">
                            <fmt:formatNumber value="${cd.value.importe}" type="number" maxFractionDigits="2" />
                        </td>
                        </td>
                        <td align="center">
                            <input type="radio" name="seleccion" value="${cd.value.descripcion}">
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2" align="right"><b>IMPORTE TOTAL</b></td>
                    <td align="right">
                        <fmt:formatNumber value="${carrito.importe}" type="number" maxFractionDigits="2" />
                    </td>
                    <td><input type="submit" value="Eliminar"></td>
                </tr>
            </table>
        </form>

        <hr>
        <table align="center" border="0">
            <tr>
                <td>
                    <form action="volver">
                        <input type="image" src="./Imagenes/carrito.png" alt="Sigo comprando" width="200px"><br>
                    </form>
                </td>
                <td>
                    <form action="pagar">
                        <input type="image" src="./Imagenes/caja.png" alt="Me largo a pagar" width="200px"><br>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Sigo comprando</td>
                <td>Me largo a pagar</td>
            </tr>
        </table>
    </body>
</html>

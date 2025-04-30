<%@ page language="java" import="jakarta.servlet.*, jakarta.servlet.http.*, carrito.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    HttpSession sesion = request.getSession();
    Carrito carrito = (Carrito) sesion.getAttribute("Carrito");
%>
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
        </style>
    </head>
    <body bgcolor="#FDF5E6">
        <h1 align="center">Caja</h1>
        <form action="finalizar">
            <table align="center" border="1" bgcolor="white">
                <tr><th>TOTAL A PAGAR</th></tr>
                <tr><td align="center"><%= String.format("%.2f", carrito.getImporteTotal()) %></td></tr>
            </table>
            <hr>
            <div align="center">
                <input type="image" name="pagar" src="./Imagenes/partitura.png" width="200px" alt="Pagar y volver a la página principal">
                <br>Pagar y volver a la página principal
            </div>
        </form>
    </body>
</html>
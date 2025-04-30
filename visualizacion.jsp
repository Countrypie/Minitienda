<%@ page language="java" import="java.util.*, jakarta.servlet.*, jakarta.servlet.http.*, carrito.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    HttpSession sesion = request.getSession();
    Carrito carrito = (Carrito) sesion.getAttribute("Carrito");
%>
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
                <%
                    for (String cd : carrito.getCds().keySet()) {
                        int cantidad = carrito.getCds().get(cd);
                        double importe = carrito.getImporte(cd);
                %>
                <tr>
                    <td><%= cd %></td>
                    <td align="center"><%= cantidad %></td>
                    <td align="right"><%= String.format("%.2f", importe) %></td>
                    <td align="center">
                        <input type="radio" name="seleccion" value="<%= cd %>">
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td colspan="2" align="right"><b>IMPORTE TOTAL</b></td>
                    <td align="right"><%= String.format("%.2f", carrito.getImporteTotal()) %></td>
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

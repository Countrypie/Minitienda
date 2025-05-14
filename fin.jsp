<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="caja.jsp"%>

<div class="caja_confirmacion">        
    <h2>Confirmación de la compra</h2>
    <c:choose>
    <c:when test="${carrito.pedido == -1}">
        <div style="color: red; text-align: center; margin-bottom: 10px;">
            No se ha podido realizar el pedido, inténtelo de nuevo más tarde.
        </div>
        <c:remove var="mensajeError"/>
    </c:when>
    <c:otherwise>
        <table class="informacion" align="center" border="1" bgcolor="white">
            <tr><th>INFORMACIÓN DEL PEDIDO</th></tr>
            <tr><td>Importe total</td><td>
                <fmt:formatNumber value="${importe}" type="number" maxFractionDigits="2" />€
            </td></tr>
            <tr><td>Cuenta asociada</td><td>${carrito.propietario}</td></tr>
            <tr><td>Número de pedido</td><td>${carrito.pedido}</td></tr>
        </table>
    </c:otherwise>
    </c:choose>
    
    <form action="volver">
        <div align="center">
            <input type="submit" value="Volver a la página principal">
        </div>
    </form>
</div>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="visualizacion.jsp" %>

<div class="caja_iniciar_sesion">
    <h2>Crear Usuario</h2>
    <form action="crearYPagar" method="get">
        <input type="email" name="correo" placeholder="Correo electrónico" required>
        <input type="text" name="nombre" placeholder="Nombre de usuario" required>
        <input type="text" name="tipo" placeholder="Tipo de tarjeta" required>
        <input type="text" name="numero" placeholder="Número de tarjeta" required pattern="\d+">
        <input type="submit" value="Entrar" class="boton">
    </form>
    <c:if test="${not empty mensajeError}">
        <div style="color: red; text-align: center; margin-bottom: 10px;">
            ${mensajeError}
        </div>
        <c:remove var="mensajeError"/>
    </c:if>
</div>
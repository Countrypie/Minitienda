<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="visualizacion.jsp" %>

<div class="caja_iniciar_sesion">
    <h2>Iniciar sesión</h2>
    <form action="iniciar" method="get">
        <input type="email" name="correo" placeholder="Correo electrónico" required>
        <input type="text" name="nombre" placeholder="Nombre de usuario" required>
        <input type="text" name="tipo" placeholder="Tipo de tarjeta de crédito" required>
        <input type="text" name="numero" placeholder="Número de tarjeta de crédito" required>
        <input type="submit" value="Entrar" class="boton">
    </form>
    <form action="crear" method="get">
        <input type="submit" value="Crear nuevo usuario" class="boton_crear">
    </form>
    <c:if test="${not empty mensajeError}">
        <div style="color: red; text-align: center; margin-bottom: 10px;">
            ${mensajeError}
        </div>
        <c:remove var="mensajeError"/>
    </c:if>
</div>
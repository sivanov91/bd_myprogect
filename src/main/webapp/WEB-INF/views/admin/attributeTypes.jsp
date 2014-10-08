<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Аттрибуты типа товара
<table>
    <c:forEach var="attributeType" items="${attributeTypes}">
        <tr>
            <td>
                <a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes/${attributeType.attributeId}/edit">${attributeType.name}</a>
            </td>
                <%--<td><a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes/${productType.typeId}/del">Удалить</a></td>--%>
        </tr>


    </c:forEach>
    <tr>
        <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/attributeTypes/${typeId}/add">Добавить новый тип товара</a>
        </td>
    <tr>
    <tr>
        <td>
            <a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes/${typeId}/edit">Вернутся к редактированию
                типа</a>
        </td>
    <tr>
</table>

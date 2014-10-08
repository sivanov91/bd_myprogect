<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <c:forEach var="product" items="${products}">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title"> ${category.name} » ${product.productName}</td>
                </tr>

                <tr>
                    <td>

                        Продукт: ${product.productName} <br/>
                        Описание: ${product.description} <br/>

                        Цена: ${product.price} <br/>
                        Доступное количество: ${product.qty - product.qtyReserve - product.qtyHold} <br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/basket/add/${product.productId}">Добавить в корзину</a>
                    </td>
                </tr>
            </table>
        </td>
    <tr>
        </c:forEach>
</table>


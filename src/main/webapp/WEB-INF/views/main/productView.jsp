<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br/>
Продукт: ${product.productName} <br/>
Описание: ${product.description} <br/>

Цена: ${product.price} <br/>
Доступное количество: ${product.qty - product.qtyReserve - product.qtyHold} <br/>
<a href="/<%=GlobalSettings.getPrefix()%>/basket/add/${product.productId}">Добавить в корзину</a>
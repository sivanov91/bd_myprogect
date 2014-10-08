<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.myproject.web.domain.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    Collection<Product> products = (Collection<Product>) session.getAttribute("orders");

    if (products == null) {
        products = new ArrayList<Product>();
        session.setAttribute("orders", products);
    }

%>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Корзина</td>
                </tr>
                <tr>
                    <td>
                        <%if (products.size() > 0) {%>

                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Название товара</td>
                                <td class="content-table-title">Количество</td>
                            </tr>

                            <c:forEach var="product" items="<%=products%>">
                                <tr>
                                    <td>${product.productName}</td>
                                    <td>${product.qty}</td>
                                </tr>
                            </c:forEach>

                        </table>
                        <a href="/<%=GlobalSettings.getPrefix()%>/basket/save">Оформить заказ</a>
                        <a href="/<%=GlobalSettings.getPrefix()%>/basket/clean">Очистить в корзину</a>
                        <%} else {%>
                        Корзина пуста
                        <%}%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

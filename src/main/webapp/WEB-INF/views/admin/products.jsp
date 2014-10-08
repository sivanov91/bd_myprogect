<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Товары</td>
                </tr>

                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Название</td>
                                <td class="content-table-title">Цена</td>
                                <td class="content-table-title">Количество</td>
                                <td class="content-table-title">Описание</td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/products/${product.productId}/edit">${product.productName}</a>
                                    </td>
                                    <td>${product.price}</td>
                                    <td>${product.qty}</td>
                                    <td>${product.description}</td>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/products/${product.productId}/del">Удалить</a>
                                    </td>
                                </tr>


                            </c:forEach>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/products/add">Добавить новогй товар</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>

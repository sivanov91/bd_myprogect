<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="com.myproject.web.domain.UOrder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Заказы</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Дата заказа</td>
                                <td class="content-table-title">Покупатель</td>
                                <td class="content-table-title">Сумма</td>
                                <td class="content-table-title">Статус заказа</td>
                                <td class="content-table-title"></td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="order" items="${orders}">

                                <tr>
                                    <td>${order.createDate}</td>
                                    <td>${order.firstName}</td>
                                    <td>${order.total}</td>
                                    <td>${order.orderStatusId}</td>
                                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/orders/${order.orderId}/edit">Редактировать</a>
                                    </td>
                                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/orders/${order.orderId}/del">Удалить</a>
                                    </td>
                                </tr>

                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

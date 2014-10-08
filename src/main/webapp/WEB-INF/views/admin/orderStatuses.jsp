<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Статусы заказов</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Название</td>
                                <td class="content-table-title">Описание</td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="orderStatus" items="${orderStatuses}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/orderStatuses/${orderStatus.orderStatusId}/edit">${orderStatus.name}</a>
                                    </td>
                                    <td>${orderStatus.description}</td>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/orderStatuses/${orderStatus.orderStatusId}/del">Удалить</a>
                                    </td>
                                </tr>


                            </c:forEach>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/orderStatuses/add">Добавить статус заказа</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="top-menu" align="left" width="100%">
                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/">Главная</a></td>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/basket">Корзина</a></td>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <td><a href="/<%=GlobalSettings.getPrefix()%>/myOrders">
                            <nobr>Мои заказы</nobr>
                        </a></td>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/">Админпанель</a></td>
                    </sec:authorize>

                    <td width="100%"></td>
                    <sec:authorize access="isAnonymous()">
                        <td><a href="/<%=GlobalSettings.getPrefix()%>/login">Вход</a></td>
                        <td><a href="/<%=GlobalSettings.getPrefix()%>/registration">Регистрация</a></td>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <td>
                            <noBr>Вы вошли как: <a
                                    href="/<%=GlobalSettings.getPrefix()%>/user/${userName}">${userName}</a></noBr>
                        </td>
                        <td></td>
                        <td><a href="/<%=GlobalSettings.getPrefix()%>/logout">Выход</a></td>
                    </sec:authorize>


                </tr>
            </table>
        </td>
    </tr>
</table>
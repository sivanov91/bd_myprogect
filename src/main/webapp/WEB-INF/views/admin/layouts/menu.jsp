<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">

    <tr>
        <td>
            <table class="menu">
                <tr>
                    <td class="menu-title">Навизация</td>
                </tr>
                <tr>
                    <td class="menu-body">
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/">Главная</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

    <tr>
        <td>
            <table class="menu">
                <tr>
                    <td class="menu-title">Пользователи</td>
                </tr>
                <tr>
                    <td class="menu-body">
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/users">Пользователи</a><br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/groups">Группы</a><br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/statuses">Статус</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

    <tr>
        <td>
            <table class="menu">
                <tr>
                    <td class="menu-title">Товары</td>
                </tr>
                <tr>
                    <td class="menu-body">
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/products">Товары</a><br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes">Типы товара</a><br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/categories">Категории</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

    <tr>
        <td>
            <table class="menu">
                <tr>
                    <td class="menu-title">Заказы</td>
                </tr>
                <tr>
                    <td class="menu-body">
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/orderStatuses">Статусы заказа</a><br/>
                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/orders">Заказы</a><br/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

</table>


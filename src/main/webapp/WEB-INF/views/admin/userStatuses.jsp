<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Статусы пользователя</td>
                </tr>

                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Имя</td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="status" items="${statuses}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/statuses/${status.statusId}/edit">${status.name}</a>
                                    </td>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/statuses/${status.statusId}/del">Удалить</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>

                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/statuses/add">Добавить новогый статус пользователя</a></td>
                </tr>

            </table>
        </td>
    </tr>
</table>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>

            <table class="content">
                <tr>
                    <td class="content-title">Группы</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Имя</td>
                                <td class="content-table-title">Описание</td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="group" items="${groups}">
                                   <tr>
                                       <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/groups/${group.groupId}/edit">${group.name}</a></td>
                                       <td>${group.descroption}</td>
                                       <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/groups/${group.groupId}/del">Удалить</a></td>
                                   </tr>
                               </c:forEach>
                        </table>
                    </td>
                </tr>

                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/groups/add">Добавить новую группу</a></td>
                </tr>

            </table>

        </td>
    </tr>
</table>

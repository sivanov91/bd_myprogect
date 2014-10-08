<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ModelMap model;
    model = (ModelMap) request.getAttribute("model");
    //String msg = (String) model.get("message");
    User user = (User) request.getAttribute("user");
%>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">
                        Пользователи » ${user.userName}
                    </td>
                </tr>

                <tr>
                    <td>

                        <table class="content-form">
                            <form:form method="POST" modelAttribute="user" commandName="user">
                                <form:hidden path="userId"/>


                                <tr>
                                    <td><form:label path="userName">Ник: </form:label></td>
                                    <td><form:input path="userName"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="firstName">Имя: </form:label></td>
                                    <td><form:input path="firstName"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="lastName">Фамилия: </form:label></td>
                                    <td><form:input path="lastName"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="patronymic">Отчество: </form:label></td>
                                    <td><form:input path="patronymic"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="password">Пароль: </form:label></td>
                                    <td><form:input path="password"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="email">Email: </form:label></td>
                                    <td><form:input path="email"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="code">Код: </form:label></td>
                                    <td><form:input path="code"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="groupId">Группа: </form:label></td>
                                    <td>
                                        <form:select path="groupId" id="qwe">
                                            <%--<form:options items="${groupsMap}" />--%>
                                            <c:forEach var="group" items="${userGroups}">
                                                <form:option value="${group.groupId}">${group.name}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><form:label path="userStatusId">Статус: </form:label></td>
                                    <td><form:select path="userStatusId" id="qwe">
                                        <%--<form:options items="${groupsMap}" />--%>
                                        <c:forEach var="status" items="${userStatuses}">
                                            <form:option value="${status.statusId}">${status.name}</form:option>
                                        </c:forEach>
                                    </form:select>

                                            <%--<form:input path="userStatusId"/>--%>

                                    </td>
                                </tr>


                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Сохранить"/>

                                    </td>
                                </tr>
                            </form:form>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

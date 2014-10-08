<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
      private Long userId;
          private String userName;
          private String password;
          private String firstName;
          private String lastName;
          private String patronymic;
          private String email;
          private String code;
          private String ip;
          private Long approved;

        --%>


<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Пользователи</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Логин</td>
                                <td class="content-table-title">Имя</td>
                                <td class="content-table-title">Фамилия</td>
                                <td class="content-table-title">Email</td>
                                <td class="content-table-title"></td>
                            </tr>

                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/users/${user.userId}/edit">${user.userName}</a>
                                    </td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/users/${user.userId}/del">Удалить</a></td>
                                </tr>


                            </c:forEach>


                        </table>
                    </td>
                </tr>
                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/users/add">Добавить нового
                        пользователя</a></td>
                <tr>
            </table>
        </td>
    </tr>
</table>



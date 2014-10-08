<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ModelMap model;
    model = (ModelMap) request.getAttribute("model");
    String msg = (String) model.get("message");
    User user = (User) request.getAttribute("user");
%>

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

<form:form method="POST" modelAttribute="user" commandName="user">
    <form:hidden path="userId"/>

    <table border="1">
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
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="code">Код: </form:label></td>
            <td><form:input path="code"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Save"/>

            </td>
        </tr>

    </table>
</form:form>

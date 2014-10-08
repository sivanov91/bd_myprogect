<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form method="POST" modelAttribute="typeAttribute" commandName="typeAttribute">
    <form:hidden path="typeId"/>

    <table border="1">
        <tr>
            <td><form:label path="name">Имя: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="value">Значение по умолчанию: </form:label></td>
            <td><form:input path="value"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" name="ok"  value="Save"/>

            </td>
        </tr>

    </table>
</form:form>
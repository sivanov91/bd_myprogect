<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Статусы пользователя » ${status.name}</td>
                </tr>
                <tr>
                        <td>
                            <table class="content-form">
                                <form:form method="POST" modelAttribute="status" commandName="status">
                                    <form:hidden path="statusId"/>
                                    <tr>
                                        <td><form:label path="name">Имя: </form:label></td>
                                        <td><form:input path="name"/></td>
                                    </tr>


                                    <tr>
                                        <td colspan="2">
                                            <input type="submit" name="ok" value="Сохранить"/>

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
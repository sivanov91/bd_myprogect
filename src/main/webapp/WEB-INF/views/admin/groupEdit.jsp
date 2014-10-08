<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Группы » ${group.name}</td>
                </tr>

                <tr>
                    <td>
                        <form:form method="POST" modelAttribute="group" commandName="group">
                            <form:hidden path="groupId"/>

                            <table class="content-form">

                                <tr>
                                    <td><form:label path="name">Имя: </form:label></td>
                                    <td><form:input path="name"/></td>
                                </tr>

                                <tr>
                                    <td><form:label path="descroption">Описание: </form:label></td>
                                    <td><form:input path="descroption"/></td>
                                </tr>


                                <tr>
                                    <td colspan="2">
                                        <input type="submit" name="ok" value="Сохранить"/>

                                    </td>
                                </tr>

                            </table>
                        </form:form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


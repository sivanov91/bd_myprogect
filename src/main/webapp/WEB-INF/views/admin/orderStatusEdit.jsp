<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Статусы заказов » ${orderStatus.name}</td>
                </tr>
                <tr>
                    <td>
                        <form:form method="POST" modelAttribute="orderStatus" commandName="orderStatus">
                            <form:hidden path="orderStatusId"/>

                            <table class="content-form">
                                <tr>
                                    <td><form:label path="name">Название: </form:label></td>
                                    <td><form:input path="name"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="description">Описание: </form:label></td>
                                    <td><form:input path="description"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Save"/>

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
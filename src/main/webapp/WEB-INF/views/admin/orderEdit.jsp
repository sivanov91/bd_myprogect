<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
<tr>
<td>
<table class="content">
<tr>
    <td class="content-title">Редактирование заказа</td>
</tr>
<tr>
<td>
<form:form method="POST" modelAttribute="order" commandName="order">
    <form:hidden path="orderId"/>
    <form:hidden path="userId"/>

    <table class="content-form">

        <tr>
            <td><form:label path="firstName">Имя: </form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Фамилия: </form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>


        <td><form:label path="orderStatusId">Группа: </form:label></td>
        <td>
            <form:select path="orderStatusId" id="qwe">
                <%--<form:options items="${groupsMap}" />--%>
                <c:forEach var="orderStatus" items="${orderStatuses}">
                    <form:option value="${orderStatus.orderStatusId}">${orderStatus.name}</form:option>
                </c:forEach>

            </form:select>
        </td>

        <tr>
            <td><form:label path="orderStatusId">Статус:</form:label></td>
            <td><form:input path="orderStatusId"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="telephone">Телефон: </form:label></td>
            <td><form:input path="telephone"/></td>
        </tr>
        <tr>
            <td>Цена:</td>
            <td>${uOrder.total}<form:input path="total"/></td>
        </tr>
            <%--orderProducts--%>

        <tr>
            <td colspan="2">
                <input type="submit" value="Сохранить"/>

            </td>
        </tr>

    </table>
    </td>
    </tr>
    </table>
    </td>
    </tr>
    </table>


    <table>
        <c:forEach var="orderProduct" items="${orderProducts}">
            <tr>
                <td>${orderProduct.orderProductId}</td>
            </tr>

            <%--
             <tr>
                 <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/users/${user.userId}/edit">${user.userName}</a></td>
                 <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/users/${user.userId}/del">Удалить</a></td>
             </tr>
             --%>

        </c:forEach>

    </table>
</form:form>
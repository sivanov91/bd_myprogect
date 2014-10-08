<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Оформление заказа</td>
                </tr>
                <tr>
                    <td>
                        <form:form method="POST" modelAttribute="uOrder" commandName="uOrder">
                            <table class="content-form">

                                <tr>
                                    <td><form:label path="firstName">Имя: </form:label></td>
                                    <td><form:input path="firstName"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="lastName">Фамилия: </form:label></td>
                                    <td><form:input path="lastName"/></td>
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
                                    <td>${uOrder.total}</td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Оформить"/>

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





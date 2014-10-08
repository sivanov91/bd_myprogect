<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Регистрация</td>
                </tr>
                <tr>
                    <td>

                        <c:choose>
                            <c:when test="${isRegistred}">
                                <br/>
                                Вы успешно зарегистрировались.
                            </c:when>

                            <c:otherwise>
                                <form:form method="POST" modelAttribute="user" commandName="user">

                                    <table class="content-form">
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
                                            <td colspan="2">
                                                <input type="submit" value="Отправить"/>

                                            </td>
                                        </tr>

                                    </table>
                                </form:form>
                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>

            </table>
        </td>
    </tr>
</table>

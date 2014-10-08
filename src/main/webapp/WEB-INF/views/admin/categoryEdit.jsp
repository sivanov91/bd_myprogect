<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
    private Long categoryId;
    private String name;
    private String description;
    private Long parent;
--%>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Категории товаров » ${category.name}</td>
                </tr>
                <tr>
                    <td>
                        <form:form method="POST" modelAttribute="category" commandName="category">
                            <form:hidden path="categoryId"/>

                            <table class="content-form">
                                <tr>
                                    <td><form:label path="name">Имя: </form:label></td>
                                    <td><form:input path="name"/></td>
                                </tr>

                                <tr>
                                    <td><form:label path="description">Описание: </form:label></td>
                                    <td><form:input path="description"/></td>
                                </tr>

                                <tr>
                                    <td><form:label path="identifier">Идентификатор: </form:label></td>
                                    <td><form:input path="identifier"/></td>
                                </tr>

                                <tr>
                                    <td><form:label path="parent">Родительская категория: </form:label></td>
                                    <td><form:select path="parent" id="qwe">
                                        <%--<form:options items="${groupsMap}" />--%>

                                        <form:option value="">Нет</form:option>
                                        <c:forEach var="category" items="${categories}">
                                            <form:option value="${category.categoryId}">${category.name}</form:option>
                                        </c:forEach>
                                    </form:select></td>
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

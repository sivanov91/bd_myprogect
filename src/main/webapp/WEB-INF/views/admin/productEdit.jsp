<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Товары » ${product.productName}</td>
                </tr>
                <tr>
                    <td>
                        <form:form method="POST" modelAttribute="product" commandName="product">
                            <form:hidden path="productId"/>

                            <table class="content-form">

                                <tr>
                                    <td><form:label path="productName">Имя: </form:label></td>
                                    <td><form:input path="productName"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="categoryId">Категория: </form:label></td>
                                    <td><form:select path="categoryId" id="qwe">
                                        <%--<form:options items="${groupsMap}" />--%>
                                        <%--<form:option value="">Нет</form:option> --%>
                                        <c:forEach var="category" items="${categories}">
                                            <form:option value="${category.categoryId}">${category.name}</form:option>
                                        </c:forEach>
                                    </form:select></td>
                                </tr>
                                <tr>
                                    <td><form:label path="price">Цена: </form:label></td>
                                    <td><form:input path="price"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="description">Описание: </form:label></td>
                                    <td><form:input path="description"/></td>
                                </tr>

                                <tr>
                                    <td><form:label path="qty">Количество: </form:label></td>
                                    <td><form:input path="qty"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="qtyReserve">Зарезервированно: </form:label></td>
                                    <td><form:input path="qtyReserve"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="qtyHold">Заблокираванно: </form:label></td>
                                    <td><form:input path="qtyHold"/></td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Сохранить"/>

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


<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Категории товаров</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Имя</td>
                                <td class="content-table-title">Описание</td>
                                <td class="content-table-title">Идентификатор</td>
                                <td class="content-table-title"></td>
                            </tr>

                            <c:forEach var="category" items="${categories}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/categories/${category.categoryId}/edit">${category.name}</a>
                                    </td>

                                    <td>${category.description}</td>
                                    <td>${category.identifier}</td>

                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/categories/${category.categoryId}/del">Удалить</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td><a href="/<%=GlobalSettings.getPrefix()%>/admin/categories/add">Добавить новую категорию</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>

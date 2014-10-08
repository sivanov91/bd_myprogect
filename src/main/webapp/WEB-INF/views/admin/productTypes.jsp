<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Типы товара</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Название</td>
                                <td class="content-table-title">Описание</td>
                                <td class="content-table-title"></td>
                            </tr>
                            <c:forEach var="productType" items="${productTypes}">
                                <tr>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes/${productType.typeId}/edit">${productType.name}</a>
                                    </td>
                                    <td>${productType.description}</td>
                                    <td>
                                        <a href="/<%=GlobalSettings.getPrefix()%>/admin/productTypes/${productType.typeId}/del">Удалить</a>
                                    </td>
                                </tr>


                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
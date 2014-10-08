<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form method="POST" modelAttribute="product" commandName="product">
    <form:hidden path="productId"/>
                 <%--
    <table width="100%">
        <tr>
            <td>
                <table class="content">
                    <tr>
                        <td class="content-title">zzz</td>
                    </tr>
                    <tr>
                        <td>zzz</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>   --%>

    <table border="1">

        <tr>
            <td colspan="2">Товар: ${product.productName}</td>
        </tr>

        <tr>
            <td><form:label path="qty">Количество: </form:label></td>
            <td><form:input path="qty"/></td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" value="Save"/>

            </td>
        </tr>

    </table>
</form:form>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page import="com.myproject.web.domain.Category" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="java.util.List" %>

<%--
	Model model;
    model = (Model)request.getAttribute("model");
    User user = (User)model.asMap().get("USER");

    //String Name = user.getName();
    String Name = "qwe";//user.getName();
    if(user != null){
        Name = user.getNikname();
    }



--%>

<%
    List<Category> categoryes = (List<Category>) Factory.getCategoryDAO().getAll();
%>

<table width="100%">
    <tr>
        <td>

            <table style="border: 1px solid #7d7d7d; width: 100%">
                <tr>
                    <td class="menu-title" style="background-color: #3E3E3E;">Категории</td>
                </tr>

                <% for (Category category : categoryes) {%>
                <tr>
                    <td>
                        <a href="/<%=GlobalSettings.getPrefix()%>/catalog/<%=category.getIdentifier()%>"><%=category.getName()%>
                        </a>
                    </td>
                </tr>
                <%}%>
            </table>
        </td>
    </tr>

</table>

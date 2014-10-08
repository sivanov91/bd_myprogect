<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.myproject.web.GlobalSettings" %>

<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<style>

    a:link {
        color: #434343;
        text-decoration: none;
    }

        /* unvisited link */
    a:visited {
        color: #434343;
        text-decoration: none;
    }

        /* visited link */
    a:hover {
        color: #434343;
        text-decoration: underline;
    }

        /* mouse over link */

    a:active {
        color: #434343;
        text-decoration: underline;
    }

    .menu-title {
        background-color: #3E3E3E;
        color: #e0e0e0;
        padding-left: 5px;
    }

    .menu-body {
        padding-left: 5px;
    }

    .menu {

        border: 1px solid #7d7d7d;
        width: 100%;

        /* color: #BDBDBD;
        background-color: #3E3E3E */
    }

    .menu a:link {
        color: #434343;
        text-decoration: none;
    }

        /* unvisited link */
    .menu a:visited {
        color: #434343;
        text-decoration: none;
    }

        /* visited link */
    .menu a:hover {
        color: #434343;
        text-decoration: underline;
    }

        /* mouse over link */

    .menu a:active {
        color: #434343;
        text-decoration: underline;
    }

        /* selected link */

    .content-title {
        background-color: #3E3E3E;
        color: #e0e0e0;
        padding-left: 5px;
    }

    .content {
        border: 1px solid #7d7d7d;
        width: 100%;
        color: #434343;
    }

    .content-table {
        /* border: 1px solid #7d7d7d;  */
        color: #434343;
        width: 100%;
    }

    .content-table-title {
        background-color: #c9c9c9;
        color: #434343;
        padding-left: 5px;
    }

    .content-form {
        color: #434343;
    }

    .top-menu {
        background-color: #3E3E3E;
        color: #e0e0e0;
        padding-left: 5px;
    }

    .top-menu a:link {
        color: #e0e0e0;
        text-decoration: none;
    }

        /* unvisited link */
    .top-menu a:visited {
        color: #e0e0e0;
        text-decoration: none;
    }

        /* visited link */
    .top-menu a:hover {
        color: #e0e0e0;
        text-decoration: underline;
    }

        /* mouse over link */

    .top-menu a:active {
        color: #e0e0e0;
        text-decoration: underline;


    }

    .top-menu td {
        /* padding-left: 5px; */
        padding-right: 10px;
    }

    .header {
        border: 1px solid;
        border-color: #c0c0c0;
        width: 100%;
    }

        /* selected link */
</style>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=GlobalSettings.getTitle()%>
    </title>
</head>
<body>

<table STYLE="padding: 0px; margin: 0px;" cellpadding=0 cellspacing=0 border=0px width=100% height=100%>

    <tr>
        <td  colspan=2 hight=20% width=100%>
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>

    <tr>
        <td colspan="2"><tiles:insertAttribute name="topMenu"/></td>
    </tr>

    <tr>
        <td height=90% width=15% valign=top><tiles:insertAttribute
                name="menu"/></td>
        <td height=90% width=85% valign=top><tiles:insertAttribute
                name="content"/></td>
    </tr>

</table>

</body>
</html>


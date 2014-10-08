<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .login-title {
        background-color: #3E3E3E;
        color: #e0e0e0;
        padding-left: 5px;
    }

    .login-body a:link {
        color: #434343;
        text-decoration: none;
    }

        /* unvisited link */
    .login-body a:visited {
        color: #434343;
        text-decoration: none;
    }

        /* visited link */
    .login-body a:hover {
        color: #434343;
        text-decoration: underline;
    }

        /* mouse over link */

    .login-body a:active {
        color: #434343;
        text-decoration: underline;
    }

</style>


<sec:authorize access="isAnonymous()">
    <div style="position: absolute; top: 30%; left: 40% ">
        <table style="border: 1px solid; border-color: #000000;">

            <tr>
                <td class="login-title">Вход</td>
            </tr>

            <tr>
                <td>
                    <table class="login-body" style="margin: 5px; padding: 5px;">

                                <form action="/<%=GlobalSettings.getPrefix()%>/j_spring_security_check" method="post">

                                    <tr>
                                        <td><label for="j_username">Логин</label></td>
                                        <td><input id="j_username" name="j_username" type="text"/></td>
                                    </tr>

                                    <tr>
                                        <td><label for="j_password">Пароль</label></td>
                                        <td><input id="j_password" name="j_password" type="password"/></td>
                                    </tr>

                                    <tr>
                                        <td colspan="2" align="center">
                                            <table width="100%">
                                                <tr>
                                                    <td align="left"><a href="/<%=GlobalSettings.getPrefix()%>/forgot">Забыли
                                                        пароль?</a>
                                                    </td>
                                                    <td align="right"><input type="submit" value="Вход"/></td>
                                                </tr>
                                            </table>

                                        </td>
                                    </tr>
                                </form>

                    </table>

                </td>
            </tr>


        </table>
    </div>
</sec:authorize>


<%
    String sid = SecurityContextHolder.getContext().getAuthentication().getName();

    Long id = null;
    try {
        id = new Long(sid);
    } catch (Exception e) {
    }

    if (id != null) {

        User user = Factory.getUserDAO().getById(new Long(id));

        if (user != null) {

            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userId", user.getUserId());

            String redirectURL = "/myproject/";
            response.sendRedirect(redirectURL);

        }
    }

    //out.println("id: " + id + " " + );

    /*
    //out.println(id);

    User user = Factory.getUserDAO().getById(new Long(id));

    //out.println(user != null);
    if (user != null) {
        //System.out.println(user.getName());

        session.setAttribute("userName", GlobalSettings.lRStrip(user.getUserName()));
        session.setAttribute("userId", user.getUserId());

        session.setAttribute("edit", false);

        String redirectURL = "/myproject/";
        response.sendRedirect(redirectURL);
    }else{
        out.println("Че-то не логинится =(((");
    }
    */
%>
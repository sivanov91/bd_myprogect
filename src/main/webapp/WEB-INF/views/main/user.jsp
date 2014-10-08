<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.myproject.web.GlobalSettings" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="org.springframework.ui.ModelMap" %>



<%
    ModelMap model;
    model = (ModelMap) request.getAttribute("model");

    User user = (User) request.getAttribute("user");
    String pathUserName = (String) model.get("pathUserName");
%>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Профиль</td>
                </tr>
                <tr>
                    <td>
                        <%if (user != null) {%>
                        <table>

                            <tr>
                                <td>Логин:</td>
                                <td><%=user.getUserName()%>
                                </td>
                            </tr>

                            <tr>
                                <td>Имя:</td>
                                <td><%=user.getFirstName()%>
                                </td>
                            </tr>

                            <tr>
                                <td>Фамилия:</td>
                                <td><%=user.getLastName()%>
                                </td>
                            </tr>

                            <tr>
                                <td>Отчество:</td>
                                <td><%=user.getPatronymic()%>
                                </td>
                            </tr>

                            <tr>
                                <td>Email:</td>
                                <td><%=user.getEmail()%>
                                </td>
                            </tr>


                            <%--
                            <%if(uid != null && uid.equals(user.getUserId())){%>
                            <tr>
                                <td colspan = "2">
                                    <form:form method="POST" commandName="user">
                                        <input type="submit" value="edit" />
                                    </form:form>
                                </td>
                            </tr>
                            --%>

                        </table>
                        <%} else {%>
                        User '<%=pathUserName%>' no found
                        <%}%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>





<%--
private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String code;
    private String ip;
    private Long approved;
--%>



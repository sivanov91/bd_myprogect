<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="com.myproject.web.domain.User" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.myproject.web.GlobalSettings"%>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="org.springframework.ui.ModelMap" %>


<%--
    String nikName = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = Factory.getUserDAO().getByNikName(nikName);


	Model model;
    model = (Model)request.getAttribute("model");
    User mUser = (User)model.asMap().get("USER");
--%>

<%--
    //model.addAttribute("USER",(Object)user); //asMap().put("USER",(Object)user);
    //request.setAttribute("model", model);
    //String Name = user.getName();

    mUser.setNikname(GlobalSettings.lRStrip(user.getNikname()));
    mUser.setName(GlobalSettings.lRStrip(user.getName()));
    mUser.setSecondName(GlobalSettings.lRStrip(user.getSecondName()));
    //request.setAtt
--%>


Профиль<br>

<%
    ModelMap model;
    model = (ModelMap)request.getAttribute("model");
    String msg = (String)model.get("message");
    User user = (User)request.getAttribute("user");
%>


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

<%if(user != null){%>
<table>

    <tr>
        <td>ID:</td>
        <td><%=user.getUserId()%></td>
    </tr>

    <tr>
        <td>Ник:</td>
        <td><%=user.getUserName()%></td>
    </tr>

    <tr>
        <td>Имя:</td>
        <td><%=user.getFirstName()%></td>
    </tr>

    <tr>
        <td>Фамилия:</td>
        <td><%=user.getLastName()%></td>
    </tr>

    <tr>
        <td>Отчество:</td>
        <td><%=user.getPatronymic()%></td>
    </tr>

    <tr>
        <td>Email:</td>
        <td><%=user.getEmail()%></td>
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
<%}%>

<%--
<%if(msg.equals("")){%>

<table>

    <tr>
        <td>ID:</td>
        <td><%=user.getUserId()%></td>
    </tr>

    <tr>
        <td>Ник:</td>
        <td><%=user.getNikname()%></td>
    </tr>

    <tr>
        <td>Имя:</td>
        <td><%=user.getName()%></td>
    </tr>

    <tr>
        <td>Фамилия:</td>
        <td><%=user.getSecondName()%></td>
    </tr>

    <tr>
        <td>Отчество:</td>
        <td><%=user.getPatronymic()%></td>
    </tr>

    <tr>
        <td>Email:</td>
        <td><%=user.getEmail()%></td>
    </tr>

    <tr>
        <td>Телефон:</td>
        <td><%=user.getPhone()%></td>
    </tr>

    <%if(uid != null && uid.equals(user.getUserId())){%>
    <tr>
        <td colspan = "2">
            <form:form method="POST" commandName="user">
                <input type="submit" value="edit" />
            </form:form>
        </td>
    </tr>
    <%}%>

</table>

 <%
 }else{%>
<%=msg%>
<%}%>
<%if(edit){%>
       <form:form method="POST" modelAttribute="user" commandName="user">
           <form:hidden path="UserId" />

            <table border = "1">
                <tr>
                    <td><form:label path="Nikname">Nikname: </form:label></td>
                    <td><form:input path="Nikname" /></td>
                </tr>
                <tr>
                    <td><form:label path="Name">Name: </form:label></td>
                    <td><form:input path="Name"/></td>
                </tr>
                <tr>
                    <td><form:label path="SecondName">SecondName: </form:label></td>
                    <td><form:input path="SecondName" /></td>
                </tr>
                <tr>
                    <td><form:label path="Patronymic">Patronymic: </form:label></td>
                    <td><form:input path="Patronymic" /></td>
                </tr>
                <tr>
                    <td><form:label path="Email">Email: </form:label></td>
                    <td><form:input path="Email" /></td>
                </tr>
                <tr>
                    <td><form:label path="Phone">Phone: </form:label></td>
                    <td><form:input path="Phone" /></td>
                </tr>
                <tr>
                    <td colspan = "2">
                        <input type="submit" value="Save" />



                    </td>
                </tr>
            </table>
           </form:form>

<%}%>



        --%>
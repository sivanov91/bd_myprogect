<%@ page import="org.springframework.ui.Model" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.myproject.web.domain.UOrder" %>
<%@ page import="com.myproject.web.domain.OrderStatus" %>
<%@ page import="com.myproject.web.util.Factory" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Model model;
    model = (Model) request.getAttribute("model");
    Collection<UOrder> uOrders = (Collection) model.asMap().get("uOrders");

    Collection<OrderStatus> orderStatuses = Factory.getOrderStatusDAO().getAll();
    Map<Long, String> statusMap = new HashMap<Long, String>();

    for (OrderStatus orderStatus : orderStatuses)
        statusMap.put(orderStatus.getOrderStatusId(), orderStatus.getName());

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //Date date = dt.parse(date_s);

    //User mUser = (User) model.asMap().get("USER");
%>

<table width="100%">
    <tr>
        <td>
            <table class="content">
                <tr>
                    <td class="content-title">Мои заказы</td>
                </tr>
                <tr>
                    <td>
                        <table class="content-table">
                            <tr>
                                <td class="content-table-title">Дата заказа</td>
                                <td class="content-table-title">Цена</td>
                                <td class="content-table-title">Статус</td>
                            </tr>

                            <%for (UOrder uOrder : uOrders) {%>
                            <tr>
                                <td><%=dateFormat.format(uOrder.getCreateDate())%>
                                </td>
                                <td><%=uOrder.getTotal()%>
                                </td>
                                <td><%=statusMap.get(uOrder.getOrderStatusId())%>
                                </td>
                            </tr>

                            <%}%>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
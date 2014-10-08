package com.myproject.web;

import com.myproject.web.dao.UserDAO;
import com.myproject.web.dao.UserGroupDAO;
import com.myproject.web.dao.UserStatusDAO;
import com.myproject.web.dao.impl.UserDAOImpl;
import com.myproject.web.dao.impl.UserGroupDAOImpl;
import com.myproject.web.dao.impl.UserStatusDAOImpl;
import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.UserGroup;
import com.myproject.web.domain.UserStatus;
import com.myproject.web.util.Factory;
import com.myproject.web.domain.User;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;


public class Test {

    UserDAO userDAO = new UserDAOImpl();
    UserGroupDAO userGroupDAO = new UserGroupDAOImpl();
    UserStatusDAO userStatusDAO = new UserStatusDAOImpl();

    public void userCreate(String userName, String password, String firstName, String lastName, String patronymic) {

        String email = userName + "@email.local";
        String code = "123456";
        String addDate = "";
        String editDate = "";
        String ip = "ip";
        Long approved = new Long(1);
        Long status = new Long(1);
        Long group = new Long(1);

        User user = new User();

        //user.setUserId(new Long(id));
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setEmail(email);
        user.setCode(code);
        user.setCreatedDate(new Date());
        user.setEditDate(new Date());
        user.setCreatedBy("zzz");
        user.setEditBy("zzz");
        user.setIp(ip);
        user.setApproved(approved);
        user.setUserStatusId(status);
        user.setGroupId(group);


        userDAO.add(user);

    }

    public void userAdd() {

        UserStatus userStatus = new UserStatus();
        userStatus.setName("активен");
        userStatusDAO.add(userStatus);

        UserGroup userGroup = new UserGroup();
        userGroup.setName("admin");
        userGroup.setDescroption("Admin group");
        userGroupDAO.add(userGroup);

        /*
        users = [
          [1,  "admin",  "admin",  "admin"],
          [2,  "Mishel", "mishel", "Penson"],
          [3,  "Андрей", "andrei", "КАЦ"],
          [4,  "Тим",    "tim",    "Роббинс"],
          [5,  "Мрган",  "morgan", "Фриман"],
          [6,  "Боб",    "bob",    "Гантон"],
          [7,  "Уильям", "uil",    "Сэдлер"],
          [8,  "Кленси", "klen",   "Браун"],
          [9,  "Джилл",  "djil",   "Беллоуз"],
          [10, "Марк",   "mark",   "Ролсьлн"]
          */

        userCreate("admin", "21232f297a57a5a743894a0e4a801fc3", "admin", "admin", "none");
        userCreate("mishel", "21232f297a57a5a743894a0e4a801fc3", "mishel", "Penson", "none");
        userCreate("andrei", "21232f297a57a5a743894a0e4a801fc3", "Андрей", "КАЦ", "none");
        userCreate("tim", "21232f297a57a5a743894a0e4a801fc3", "Тим", "Роббинс", "none");

    }

    public void orderStatusAdd(String name, String decription){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(name);
        orderStatus.setDescription(decription);

        Factory.getOrderStatusDAO().add(orderStatus);
    }

    public void orderStatusFill(){
        orderStatusAdd("Не оформлен","Не оформленный заказ");
        orderStatusAdd("Ожидание проверки","Оформленный заказ ожидающий проверки");
        orderStatusAdd("Проверенный заказ","Заказ проверен ожидает доставки");
        orderStatusAdd("Доставлен","Доставленный заказ");

    }

    public static void main(String[] argv) throws SQLException {


        Test test = new Test();

        test.userAdd();

        test.orderStatusFill();
        //UserDAO userDAO = new UserDAOImpl();
        //System.out.println(userDAO.getById(new Long(1)).getUserName());

        /*
        Collection<User> users = Factory.getUserDAO().getAll();

        for (User user: users){
            System.out.println("User: " + user.getName());
        }
        */

        //User user = Factory.getUserDAO().getByNikName("mishel");
        //System.out.println(user.getUserId());

        //String example = "|qweqwe                       |";
        //;
        //System.out.println(example);
        //System.out.println(example.replaceAll("^|\\s*(\\w+)\\s*|$", "$1"));
        //System.out.println((new Integer(1)).toString());

    }
}

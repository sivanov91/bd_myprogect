package com.myproject.app;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import com.myproject.app.dao.BasketIthemDAO;
import com.myproject.app.dao.Factory;
import com.myproject.app.dao.RoleDAO;
import com.myproject.app.domain.*;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */

public class Main {
    public static void main( String [] argv) throws SQLException {

        /*
        Collection <User> users = Factory.getInstance().getUserDAO().getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user: users){
            System.out.println("id: " + user.getUserId() + " Name: " + user.getName());
        }*/

        /*
        Collection <Role> roles = Factory.getInstance().getRoleDAO().getAllRoles();
        System.out.println("Список всех Ролей:");
        for (Role role: roles){
            System.out.println("id: " + role.getRoleId() + " Name: " + role.getRoleName());
        }*/


        /*
        Collection <Role> roles = Factory.getInstance().getRoleDAO().getAllRoles();
        for (Role role: roles){
            System.out.println("Роль: " + role.getRoleName());
            Collection <User> users = Factory.getInstance().getUserDAO().getUsersByRole(role);
            for (User user: users){
                System.out.println("id: " + user.getUserId() + " Name: " + user.getName());
            }
        }
        */
        /*
        Collection <AppResource> appResources = Factory.getInstance().getAppResourceDAO().getAllAppResource();
        for ( AppResource appResource: appResources){
            System.out.println("id: " + appResource.getAppResourceId() + " accses_type: " + appResource.getAccessType());
        }*/

        /*
        Collection <Role> roles = Factory.getInstance().getRoleDAO().getAllRoles();
        for (Role role: roles){
            System.out.println("Роль: " + role.getRoleName());
            Collection <AppResource> appResources = Factory.getInstance().getAppResourceDAO().getAppResourceByRole(role);

            for (AppResource appResource: appResources){
                System.out.println("id: " + appResource.getAppResourceId() + " accses_type: " + appResource.getAccessType());
            }

        }
        */


        /*
        Collection <User> users = Factory.getInstance().getUserDAO().getAllUsers();
        for (User user: users){
            System.out.println("User: " + user.getName());
            Collection <UserComplaint> userComplaints = Factory.getInstance().getUserComplaintDAO().getUserComplaintByUser(user);

            for (UserComplaint userComplaint: userComplaints){
                System.out.println("Id: " + userComplaint.getUserComplaintId() + " Complaint: " + userComplaint.getComplaint());
            }

        }

        Collection <BasketIthem> basketIthems = Factory.getInstance().getBasketIthemDAO().getAllBasketIthem();
        for (BasketIthem basketIthem: basketIthems){
            System.out.println("BasketId: " + basketIthem.getBasketId() + " ProductId: " + basketIthem.getProductId() + " Qantity: " + basketIthem.getQuantity());
        }*/

        Collection <User> users = Factory.getInstance().getUserDAO().getAllUsers();
        for (User user: users){
            System.out.println("User: " + user.getName());

            Collection <Queue> queues = Factory.getInstance().getQueueDAO().getQueueByUser(user);
            for ( Queue queue: queues ){
                System.out.println("Id: " + queue.getQueueId() + "ok");
            }

        }


    }
}


package com.myproject.app.dao;

import com.myproject.app.domain.Queue;
import com.myproject.app.domain.User;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 8:13
 * To change this template use File | Settings | File Templates.
 */
public interface QueueDAO {
    public void addQueue(Queue queue);
    public void updateQueue(Queue queue);
    public Queue getQueueById(Long queueId);
    public Collection getAllQueue();
    public void deleteQueue(Queue queue);
    public Collection getQueueByUser(User user);
}

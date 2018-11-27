package com.spencer.statemachine.service;

import com.spencer.statemachine.constant.OrderStatusChangeEvent;
import com.spencer.statemachine.dao.OrderTestMapper;
import com.spencer.statemachine.entity.OrderTest;
import com.spencer.statemachine.handler.PersistStateMachineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author lichao
 * @date 2018/11/27 3:21 PM
 **/
@Component
public class OrderStateService {
    private PersistStateMachineHandler handler;


    public OrderStateService(PersistStateMachineHandler handler) {
        this.handler = handler;
    }

    @Resource
    private OrderTestMapper orderTestMapper;


    public String listDbEntries() {
        List<OrderTest> orders = orderTestMapper.listOrder();
        StringJoiner sj = new StringJoiner(",");
        for (OrderTest order : orders) {
            sj.add(order.toString());
        }
        return sj.toString();
    }


    public boolean change(int order, OrderStatusChangeEvent event) {
        OrderTest o = orderTestMapper.selectByPrimaryKey(order);
        return handler.handleEventWithState(MessageBuilder.withPayload(event).setHeader("order", order).build(), o.getStatus());
    }

}

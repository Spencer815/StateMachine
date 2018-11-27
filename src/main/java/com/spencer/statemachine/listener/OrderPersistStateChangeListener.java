package com.spencer.statemachine.listener;

import com.spencer.statemachine.constant.OrderStatus;
import com.spencer.statemachine.constant.OrderStatusChangeEvent;
import com.spencer.statemachine.dao.OrderTestMapper;
import com.spencer.statemachine.entity.OrderTest;
import com.spencer.statemachine.handler.PersistStateMachineHandler;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import javax.annotation.Resource;

/**
 * @author lichao
 * @date 2018/11/27 3:52 PM
 **/
public class OrderPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {
    @Resource
    private OrderTestMapper orderTestMapper;


    @Override
    public void onPersist(State<OrderStatus, OrderStatusChangeEvent> state, Message<OrderStatusChangeEvent> message,
                          Transition<OrderStatus, OrderStatusChangeEvent> transition, StateMachine<OrderStatus, OrderStatusChangeEvent> stateMachine) {
        if (message != null && message.getHeaders().containsKey("order")) {
            Integer order = message.getHeaders().get("order", Integer.class);
            OrderTest orderTest = orderTestMapper.selectByPrimaryKey(order);
            OrderStatus status = state.getId();
            orderTest.setStatus(status);
            orderTestMapper.insert(orderTest);

        }
    }
}

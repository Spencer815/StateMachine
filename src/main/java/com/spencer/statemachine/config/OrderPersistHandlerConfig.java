package com.spencer.statemachine.config;

import com.spencer.statemachine.constant.OrderStatus;
import com.spencer.statemachine.constant.OrderStatusChangeEvent;
import com.spencer.statemachine.handler.PersistStateMachineHandler;
import com.spencer.statemachine.listener.OrderPersistStateChangeListener;
import com.spencer.statemachine.service.OrderStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

/**
 * @author lichao
 * @date 2018/11/27 4:08 PM
 **/
@Configuration
public class OrderPersistHandlerConfig {
    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> stateMachine;


    @Bean
    public OrderStateService persist() {
        PersistStateMachineHandler handler = persistStateMachineHandler();
        handler.addPersistStateChangeListener(persistStateChangeListener());
        return new OrderStateService(handler);
    }

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        return new PersistStateMachineHandler(stateMachine);
    }

    @Bean
    public OrderPersistStateChangeListener persistStateChangeListener(){
        return new OrderPersistStateChangeListener();
    }

}

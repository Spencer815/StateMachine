package com.spencer.statemachine.config;

import com.spencer.statemachine.constant.OrderStatus;
import com.spencer.statemachine.constant.OrderStatusChangeEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 状态极配置类
 * StateMachineStateConfigurer < S, E> 配置状态集合以及初始状态，泛型参数S代表状态，E代表事件。
 * StateMachineTransitionConfigurer 配置状态流的转移，可以定义状态转换接受的事件
 * @author lichao
 * @date 2018/11/27 3:27 PM
 **/

@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states)
            throws Exception {
        states.withStates()
                // 定义初始状态
                .initial(OrderStatus.WAIT_PAYMENT)
                // 定义所有状态集合
                .states(EnumSet.allOf(OrderStatus.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions)
            throws Exception {
        transitions.withExternal()
                .source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER)
                .event(OrderStatusChangeEvent.PAYED)
                .and()
                .withExternal()
                .source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE)
                .event(OrderStatusChangeEvent.DELIVERY)
                .and()
                .withExternal()
                .source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH)
                .event(OrderStatusChangeEvent.RECEIVED);
    }

}

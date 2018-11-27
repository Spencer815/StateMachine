package com.spencer.statemachine.constant;

/**
 * @author lichao
 * @date 2018/11/27 3:21 PM
 **/
public enum OrderStatus {
    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}

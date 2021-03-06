package com.spencer.statemachine.entity;

import com.spencer.statemachine.constant.OrderStatus;

/**
 * @author lichao
 * @date 2018/11/27 3:21 PM
 **/
public class OrderTest {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_test.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_test.order_id
     *
     * @mbggenerated
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_test.status
     *
     * @mbggenerated
     */
    private OrderStatus status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_test.id
     *
     * @return the value of order_test.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_test.id
     *
     * @param id the value for order_test.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_test.order_id
     *
     * @return the value of order_test.order_id
     *
     * @mbggenerated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_test.order_id
     *
     * @param orderId the value for order_test.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_test.status
     *
     * @return the value of order_test.status
     *
     * @mbggenerated
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_test.status
     *
     * @param status the value for order_test.status
     *
     * @mbggenerated
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
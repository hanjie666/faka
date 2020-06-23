/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;

/**
 *
 * @author 良匠
 */
public interface OrderDao {
    //生成订单
    int addorder(Order order);
    
    //查找支付订单
    String findPayOrder(String payOrder);
    
}

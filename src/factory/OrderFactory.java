/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.proxy.OrderDaoProxy;

/**
 *
 * @author 良匠
 */
public class OrderFactory {
     public static OrderDaoProxy getGoodsDAOInstance(){//取得DAO实例 
         return new OrderDaoProxy();//返回代理实例 
    } 
}

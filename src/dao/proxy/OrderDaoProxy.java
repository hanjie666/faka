/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.proxy;

import dao.GoodsDao;
import dao.OrderDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.OrderDaoImpl;
import entity.Order;
import utils.JDBCUtil;

/**
 *
 * @author 良匠
 */
public class OrderDaoProxy implements OrderDao{
    private JDBCUtil dbc=null;//定义数据库连接 
    private OrderDao dao=null;//定义DAO接口 
    public OrderDaoProxy(){ 
        try{ 
           this.dbc=new JDBCUtil();//实例化数据库连接  
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        this.dao=new OrderDaoImpl(dbc.getCon()); 
    } 

    @Override
    public int addorder(Order order) {
       int res = dao.addorder(order);
       dbc.closeCon();
       return res;
    }
}

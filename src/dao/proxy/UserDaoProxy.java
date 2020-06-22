/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import utils.JDBCUtil;

/**
 *
 * @author 良匠
 */
public class UserDaoProxy implements UserDao{
    private JDBCUtil dbc=null;//定义数据库连接 
    private UserDao dao=null;//定义DAO接口 
    public UserDaoProxy(){ 
        try{ 
           this.dbc=new JDBCUtil();//实例化数据库连接  
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        this.dao=new UserDaoImpl(dbc.getCon()); 
    } 

    @Override
    public User userLogin(User user) {
       User users = dao.userLogin(user);
       dbc.closeCon();
       return users;
    }

    @Override
    public int updateUserMoney(User user) {
       int res = dao.updateUserMoney(user);
       dbc.closeCon();
       return res;
    }

    @Override
    public int getUserMoneyByUsername(String username) {
       int res = dao.getUserMoneyByUsername(username);
       dbc.closeCon();
       return res;
    }
}

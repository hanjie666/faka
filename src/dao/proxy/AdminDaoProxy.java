/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.proxy;

import dao.AdminDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import utils.JDBCUtil;

/**
 *
 * @author 良匠
 */
public class AdminDaoProxy implements AdminDao{
    private JDBCUtil dbc=null;//定义数据库连接 
    private AdminDao dao=null;//定义DAO接口 
    public AdminDaoProxy(){ 
        try{ 
           this.dbc=new JDBCUtil();//实例化数据库连接  
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        this.dao=new AdminDaoImpl(dbc.getCon()); 
    } 

    @Override
    public int adminLogin(Admin admin) {
       int res = dao.adminLogin(admin);
       dbc.closeCon();
       return res;
    }
}

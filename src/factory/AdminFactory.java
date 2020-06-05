/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.proxy.AdminDaoProxy;



/**
 *
 * @author 良匠
 */
public class AdminFactory {
    public static AdminDaoProxy getAdminDAOInstance(){//取得DAO实例 
         return new AdminDaoProxy();//返回代理实例 
    } 
}

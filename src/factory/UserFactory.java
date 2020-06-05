/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.UserDao;
import dao.proxy.UserDaoProxy;

/**
 *
 * @author 良匠
 */
public class UserFactory {
    public static UserDaoProxy getUserDAOInstance(){//取得DAO实例 
         return new UserDaoProxy();//返回代理实例 
    } 
}

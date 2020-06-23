/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;

/**
 *
 * @author 良匠
 */
public interface UserDao {
    //用户登录
    User userLogin(User user);
    
    //用户扣除余额
    int updateUserMoney(User user);
    
    //根据用户名查询余额
    int getUserMoneyByUsername(String username);
    
    //用户充值余额
    int addUserMoney(int money,String username);
}

package dao.impl;

import dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 良匠
 */
public class UserDaoImpl implements UserDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public UserDaoImpl(Connection con){
        this.con=con;
    }
}

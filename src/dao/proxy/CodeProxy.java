/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.proxy;

import dao.AdminDao;
import dao.CodeDao;
import dao.impl.AdminDaoImpl;
import dao.impl.CodeDaoImpl;
import utils.JDBCUtil;

/**
 *
 * @author 良匠
 */
public class CodeProxy implements CodeDao{
    private JDBCUtil dbc=null;//定义数据库连接 
    private CodeDao dao=null;//定义DAO接口 
    public CodeProxy(){ 
        try{ 
           this.dbc=new JDBCUtil();//实例化数据库连接  
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        this.dao=new CodeDaoImpl(dbc.getCon()); 
    } 
    @Override
    public String[] getCode(String gname, int num) {
       String[] codes = dao.getCode(gname, num);
       dbc.closeCon();
       return codes;
    }

    @Override
    public int useCode(String code) {
       int res = dao.useCode(code);
       dbc.closeCon();
       return res;
    }
    
}

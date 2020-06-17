/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CodeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 良匠
 */
public class CodeDaoImpl implements CodeDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public CodeDaoImpl(Connection con){
        this.con=con;
    }
   
    @Override
    public String[] getCode(String gname,int num) {
         try {
         String sql="select * from gcode where gname = ? and state = 1 limit ? ";
         ps = this.con.prepareStatement(sql);
         ps.setString(1, gname);
         ps.setInt(2, num);
         ResultSet rs = ps.executeQuery();
         String[] codes = new String[num];
         int i = 0;
         while(rs.next()){
              codes[i] = rs.getString("codenum");
              i++;
         }
         return codes;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return  null;
    }

    @Override
    public int useCode(String code) {
        try{
            String sql = "update gcode set state = 0  where codenum = ?";
            ps=this.con.prepareStatement(sql);
            ps.setString(1,code);
            int ss = ps.executeUpdate();
            if(ss==1){
                return 1;
            }else{
                return 0;
            }
        }catch(SQLException ex){
            Logger.getLogger(CodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          return 0;
    }

    @Override
    public int getGoodsNum(String gname) {
        try {
         String sql="select * from gcode where gname = ? and state = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1,gname);
         ps.setInt(2,1);
         ResultSet rs = ps.executeQuery();
         int i = 0;
         while(rs.next()){
            i++;
         }
         return i;

        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return  0;
    }
 
    
}

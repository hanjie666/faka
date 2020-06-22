/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GoodsDao;
import entity.Goods;
import entity.GoodsCategory;
import entity.User;
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
public class GoodsDaoImpl implements GoodsDao{
    public Connection con=null;
    public PreparedStatement ps = null;
    public GoodsDaoImpl(Connection con){
        this.con=con;
    }
    @Override
    public List<String> getAllGoodsCategory() {
         try {
         String sql="select * from goodtype";
         ps = this.con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         List<String> list = new ArrayList<>();
         while(rs.next()){
               list.add(rs.getString("gtype"));
         }
         return list;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return  null;
    }

    @Override
    public List<Goods> getGoods(String goodsCategory) {
        try {
         String sql="select * from goods  where gtypename = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1, goodsCategory);
         ResultSet rs = ps.executeQuery();
        
         List<Goods> Gs = new ArrayList<>();
         while(rs.next()){
            Goods goods = new Goods();
            goods.setGnum(rs.getString("gnum"));
            goods.setGname(rs.getString("gname"));
            goods.setGstock(rs.getInt("gstock"));
            goods.setGprice(rs.getInt("gprice"));
            goods.setGtypename(rs.getString("gtypename"));
            Gs.add(goods);
         }
         return Gs;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return  null;
    }

    @Override
    public Goods getGoodsDetial(String gname) {
        try {
         String sql="select * from goods where gname = ?";
         ps = this.con.prepareStatement(sql);
         ps.setString(1,gname);
         ResultSet rs = ps.executeQuery();
         Goods goods = new Goods();
         while(rs.next()){
            goods.setGnum(rs.getString("gnum"));
            goods.setGname(rs.getString("gname"));
            goods.setGstock(rs.getInt("gstock"));
            goods.setGprice(rs.getInt("gprice"));
            goods.setGtypename(rs.getString("gtypename"));
            goods.setGintroduce(rs.getString("gintroduce"));
         }
         return goods;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
         return  null;
    }

    @Override
    public void setGoodsCategory(Goods good) {
        try{
            String sql="insert into goodtype values (?,?)";
            ps=this.con.prepareStatement(sql);
            ps.setString(1,good.getGnum());
            ps.setString(2,good.getGtypename());
            int rs = ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setGoods(Goods goods) {
         try{
            String sql="insert into goods value(?,?,?,?,?,?)";
            ps=this.con.prepareStatement(sql);
            ps.setString(1, goods.getGnum());
            ps.setString(2, goods.getGname());
            ps.setInt(3, goods.getGstock());
            ps.setInt(4, goods.getGprice());
            ps.setString(5, goods.getGtypename());
            ps.setString(6, goods.getGintroduce());
            ResultSet rs = ps.executeQuery();
        }catch (SQLException ex){
           Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }

    
}

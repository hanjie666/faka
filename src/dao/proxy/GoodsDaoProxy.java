/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.proxy;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Goods;
import java.util.List;
import utils.JDBCUtil;

/**
 *
 * @author 良匠
 */
public class GoodsDaoProxy implements GoodsDao{
    private JDBCUtil dbc=null;//定义数据库连接 
    private GoodsDao dao=null;//定义DAO接口 
    public GoodsDaoProxy(){ 
        try{ 
           this.dbc=new JDBCUtil();//实例化数据库连接  
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        this.dao=new GoodsDaoImpl(dbc.getCon()); 
    } 
    @Override
    public List<String> getAllGoodsCategory() {
       List<String> list = dao.getAllGoodsCategory();
       dbc.closeCon();
       return list;
    }

    @Override
    public List<Goods> getGoods(String goodsCategory) {
       List<Goods> list = dao.getGoods(goodsCategory);
       dbc.closeCon();
       return list;
    }

    @Override
    public Goods getGoodsDetial(String gname) {
        Goods goods = dao.getGoodsDetial(gname);
        dbc.closeCon();
        return goods;
    }

      @Override
    public void setGoodsCategory(Goods good){
        dao.setGoodsCategory(good);
        dbc.closeCon();
    }
    
    
    @Override
    public void setGoods(Goods goods){
        dao.setGoodsCategory(goods);
    }

}

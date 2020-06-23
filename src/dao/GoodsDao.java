/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Goods;
import entity.GoodsCategory;
import java.util.List;


/**
 *
 * @author 良匠
 * 商品类
 */
public interface GoodsDao {
    //查询所以商品分类
    List<String> getAllGoodsCategory();
    
    //查询分类下的商品
    List<Goods> getGoods(String goodsCategory);
    
    //根据商品名字查询商品
    Goods getGoodsDetial(String gname);
    
    
    /**
     * 李思远
     **/
    //添加商品分类
    void setGoodsCategory(Goods good);
    
    //添加商品
    void setGoods(Goods goods);
     
    //删除商品分类
    int delGoodsCategory(String name);
    
}

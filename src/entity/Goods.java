/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author 良匠
 * 商品类
 */
public class Goods {
    private String gnum;
    private String gname;
    private Integer gstock;
    private Integer gprice;
    private String gtypename;
    private String gintroduce;
    
    public String getGnum() {
        return gnum;
    }

    public void setGnum(String gnum) {
        this.gnum = gnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public Integer getGprice() {
        return gprice;
    }

    public void setGprice(Integer gprice) {
        this.gprice = gprice;
    }

    public String getGtypename() {
        return gtypename;
    }

    public void setGtypename(String gtypename) {
        this.gtypename = gtypename;
    }

    public String getGintroduce() {
        return gintroduce;
    }

    public void setGintroduce(String gintroduce) {
        this.gintroduce = gintroduce;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 良匠
 */
public interface CodeDao {
    //获取数据库卡密
    String[] getCode(String gname,int num);
    //标记卡密已使用
    int useCode(String code);
}

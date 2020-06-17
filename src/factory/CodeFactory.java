/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.proxy.CodeProxy;

/**
 *
 * @author 良匠
 */
public class CodeFactory {
     public static CodeProxy getCodeDAOInstance(){//取得DAO实例 
         return new CodeProxy();//返回代理实例 
    } 
}

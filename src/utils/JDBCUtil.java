/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 良匠
 */
public class JDBCUtil {
     private static final String DBdriver="com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://139.9.57.193:3306/faka_system?useSSL=false&serverTimezone=UTC&characterEncoding=utf8"; 
	private static final String DBUSER="root"; 
	private static final String DBPASS="chj0609"; 
	private Connection con=null; 
	public JDBCUtil(){
		try {
			this.con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Connection getCon(){
		return this.con;
	}
	public void closeCon(){
            if(this.con!=null){
                    try {
                            con.close();
                    } catch (SQLException e) {
                            // TODO 自动生成的 catch 块
                            e.printStackTrace();
                    }
            }
	}
    
}

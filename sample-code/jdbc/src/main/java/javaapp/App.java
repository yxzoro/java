package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public  class App   {
            
      private static ComboPooledDataSource ds; 
      // 使用C3p0开源连接池库
      private static void init_conn_pool() {
           App.ds = new ComboPooledDataSource();
           try {
               App.ds.setDriverClass("com.mysql.jdbc.Driver");
               App.ds.setJdbcUrl("jdbc:mysql://21.50.131.32:3306/finedb");
               App.ds.setUser("root"); 
               App.ds.setPassword("Finedb1!pwd8$");
               App.ds.setMaxPoolSize(5); 
               App.ds.setInitialPoolSize(2); 
               App.ds.setMaxIdleTime(600);               
           } catch (Exception e) {
               e.printStackTrace();
           }
      }

      private static String query_mysql(String system, String user) {
          try {
               Connection cn = App.ds.getConnection();
               Statement st = cn.createStatement();
               String sql = 
"select username from BIPlat_bi_user where id in " + 
"(select bi_user_id from BIPlat_middle_map where p13_user_id in " + 
  "(select id from BIPlat_p13_user where username=\"" +user+ "\")" + 
 "and sys_id in " + 
  "(select id from BIPlat_system where sysname=\"" +system+ "\")" + 
")";
               ResultSet rs = st.executeQuery(sql);
               // get bi_usernmame by p13_username + sys_name
               if (rs.next()){
                  return rs.getString("username");
               } else {
                  return null;
               }               
           } catch (Exception e) {
               e.printStackTrace();
           }
          return null;
      }

      public static void main(String[] args) {
    
        // 用户映射关系: system + user -> role=finebi user
        // 考虑支持实时修改接入用户配置以及服务无需重启,则使用mysql表存该map关系,实时查询mysql
          App.init_conn_pool();

      // map finebi user
      // user = App.gmap.getOrDefault(system+"-"+user, "nouser");
          String system = args[0] ;
          String user = args[1] ;
       user = App.query_mysql(system, user);
       System.out.println(user);

  }

}


package javaapp;

import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import java.util.logging.*;
// import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public  class MysqlConn {
            
//      public HashMap<String, String> gmap;

        private ComboPooledDataSource ds;       

// private Logger logger;
// private void init_logger() {
//     try{
//         this.logger = Logger.getLogger("map");
//         FileHandler fh = new FileHandler("/tmp/p13.log", true);
//         fh.setFormatter(new SimpleFormatter());
//         logger.addHandler(fh);
//     }catch (Exception e) {
//         e.printStackTrace();
//     }
// }

      // 使用C3p0开源连接池库
      private void init_conn_pool() {
           this.ds = new ComboPooledDataSource();
           try {
               this.ds.setDriverClass("com.mysql.jdbc.Driver");
               this.ds.setJdbcUrl("jdbc:mysql://21.50.131.32:3306/finedb");
               this.ds.setUser("finedb");
               this.ds.setPassword("finedb");
               this.ds.setMaxPoolSize(5); // 连接池最大连接数量
               this.ds.setInitialPoolSize(3);
               this.ds.setAcquireRetryAttempts(3); //定义在从数据库获取新连接失败后重复尝试的次数
               this.ds.setAcquireRetryDelay(5000); //获得连接的最大等待毫秒数
               this.ds.setMaxIdleTime(600); //最大空闲时间,600秒内未使用则连接被丢弃
           } catch (Exception e) {
               e.printStackTrace();
           }
      }

      private String query_mysql(String system, String p13_user) {
          String bi_user = "no_bi_user"; // 3.什么都查询不到的情况下，默认的bi_user是no_bi_user
          try {
               Connection cn = this.ds.getConnection();
               Statement st = cn.createStatement();
               String sql = 
				"select username from BIPlat_bi_user where id in " + 
				"(select bi_user_id from BIPlat_middle_map where p13_user_id in " + 
				  "(select id from BIPlat_p13_user where username=\"" + p13_user + "\")" + 
				 "and sys_id in " + 
				  "(select id from BIPlat_system where sysname=\"" + system + "\")" + 
				")";
               ResultSet rs = st.executeQuery(sql);
               // 1.使用p13_username + sysname查询映射的bi_user
               if (rs.next()){
                  bi_user = rs.getString("username");
               } else {
               	  // 2.如果查询不到(没有配置p13用户与bi用户的映射关系),就查询该系统的默认bi_user
               	  // 实际上更多的都是这种情况? 业务系统那边懒得给配置人员名单过来？ shit.
               	   sql = "select default_bi_username from BIPlat_system where sysname=\"" + system + "\";";
	               rs = st.executeQuery(sql);
	               if (rs.next()){
                  		bi_user = rs.getString("default_bi_username");
               	   }
           		} 

                // close conn: put conn back into conn_pool
                rs.close();
                st.close();
                cn.close();
       	   } catch (Exception e) {
               e.printStackTrace();
           }
          return bi_user;
      }

      public void init() {        
        // 用户映射关系: system + user -> role=finebi user
        // 考虑支持实时修改接入用户配置以及服务无需重启,则使用mysql表存该map关系,实时查询mysql
//        this.gmap = new HashMap<String, String>();
//        this.gmap.put("jsc-hubian", "jsc-allow-read");
//        this.gmap.put("jsc-yangxing-007", "jsc-deny-read");
          this.init_conn_pool();
// this.init_logger();
      }    

}


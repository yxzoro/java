package javaapp;

public  class App {            

    public static void main(String[] args) {
        MysqlConn mysqlConn = new MysqlConn();
        mysqlConn.init();
        String bi_user = mysqlConn.query_mysql(args[0], args[1]);
        System.out.println(bi_user);
    }

}


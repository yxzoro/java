package dbSource;

import dbSource.influx.Influx;
import dbSource.mongo.Mongo;

import java.util.HashMap;

public class Main{
    public static void main(String[] args) {                
        System.out.println("----> test influx <---");
        Influx t1 = new Influx();

        System.out.println("----> test mongo <---");
        Mongo t2 = new Mongo();

    }
}











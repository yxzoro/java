package dbSource.influx;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.PrintWriter;

import org.influxdb.InfluxDB;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;


class Influx {

        String dbName = "";
        String username = "root";
        String password = "root";
        String addr = "http://10.10.25.54:8090";
        InfluxDB conn;

        public void Influx() throws Exception {
            this.conn = InfluxDBFactory.connect(
                    this.addr, this.username, this.password);
        }
    
        public void close() throws Exception {
            this.conn.close();
        }

        public void read() throws Exception {
            //this.conn
        }

        public void write() throws Exception {
            //this.conn
        }


}




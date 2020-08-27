package dbSource.mongo;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.PrintWriter;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


class Mongo {

        String db = "";
        String collection = "";
        String username = "root";
        String password = "root";
        String addr = "http://10.10.25.54";
        MongoClient conn;

        public void Mongo() throws Exception {
            this.conn = new MongoClient(this.addr, 27017);
        }
    
        public void close() throws Exception {
            this.conn.close();
        }

        public void read() throws Exception {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(this.db); 
            MongoCollection<Document> collection = mongoDatabase.getCollection(this.collection);
        }

        public void write() throws Exception {
           
        }


}




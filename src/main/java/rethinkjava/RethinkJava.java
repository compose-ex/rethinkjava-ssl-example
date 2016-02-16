package rethinkjava;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.ReqlError;
import com.rethinkdb.gen.exc.ReqlQueryLogicError;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.net.Connection;

import java.io.FileInputStream;
import java.util.ArrayList;

public class RethinkJava {
    public static final RethinkDB	r = RethinkDB.r;

    public static final String		host = "hostname";
    public static final int			port = 10965; // Port number
    public static final String		authKey ="GbDfAcEGbDfAcEGbDfAcEGbDfAcEGbDfAcE";
    public static final String		certfile = "./certfile.crt";

    public static void main(String[] args) {
    	System.out.println("Welcome to RethinkJava on Compose");

    	try {
    		FileInputStream cert = new FileInputStream(certfile);

    		Connection		conn = r.connection().
    				hostname(host).
    				port(port).
    				authKey(authKey).
    				certFile(cert).
    				connect();

    		ArrayList<String> tables = r.db("example").tableList().run(conn);
    		for (String tablename:tables)
    			System.out.println(tablename);

            r.close(conn);

    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
}

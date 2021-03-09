package javaapp;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import java.security.MessageDigest;
import cn.org.bjca.security.SecurityUtil;
import cn.org.bjca.utils.Base64Util;
import cn.org.bjca.valuebean.BJCA_type;

import org.eclipse.jetty.unixsocket.UnixSocketConnector;

/*
tcp socket和unix socket的区别:
A UNIX socket is an inter-process communication mechanism that allows bidirectional data exchange between processes running on the same machine.
IP sockets (especially TCP/IP sockets) are a mechanism allowing communication between processes over the network. In some cases, you can use TCP/IP sockets to talk with processes running on the same computer (by using the loopback interface).
UNIX domain sockets know that they’re executing on the same system, so they can avoid some checks and operations (like routing); which makes them faster and lighter than IP sockets. So if you plan to communicate with processes on the same host, this is a better option than IP sockets.
Edit: As per Nils Toedtmann's comment: UNIX domain sockets are subject to file system permissions, while TCP sockets can be controlled only on the packet filter level.

NIX Socket是同一台服务器上不同进程间的通信机制。TCP/IP Socket是网络上不同服务器之间进程的通信机制，也可以让同一服务器的不同进程通信。
Postgres的一位核心开发者曾经做过实验，证明UNIX Socket的方式比TCP/IP Socket方式要快31%，所以，在同一个服务器上应该优先选择UNIX Socket方式。
*/
public class App {
    public static void main( String[] args ) throws Exception{
        // 1.监听 ip:port
        // int port = 30000;
        // Server server = new Server(port);

        // 2.监听 unix socket
        Server server = new Server();
        UnixSocketConnector connector = new UnixSocketConnector(server);
        connector.setUnixSocket("/tmp/jetty.sock");
        server.addConnector(connector);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        // This is a raw Servlet, not a Servlet that has been configured
        // through a web.xml @WebServlet annotation, or anything similar.
        handler.addServletWithMapping(TestServlet.class, "/test");

        server.start();
        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        server.join();
    }


    @SuppressWarnings("serial")
    public static class TestServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Test from jetty HelloServlet...</h1>");
        }
    }



}


package authorbookee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.http.WebSocket;

@WebListener
public class ServerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Hello from my listener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Bye from my listener");
    }
}

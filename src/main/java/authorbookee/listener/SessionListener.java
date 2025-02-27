package authorbookee.listener;

import authorbookee.model.User;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            User user = (User) event.getValue();
            System.out.println(user.getEmail() + " logged in at " + new Date());

        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " destroyed");
    }
}

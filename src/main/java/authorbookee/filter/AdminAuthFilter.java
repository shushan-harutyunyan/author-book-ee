package authorbookee.filter;

import authorbookee.model.User;
import authorbookee.model.UserType;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/addAuthor", "/addBook", "/deleteAuthor", "/editAuthor"})
public class AdminAuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getUserType() == UserType.admin) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/");
        }
    }
}

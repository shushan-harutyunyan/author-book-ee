package authorbookee.servlet;

import authorbookee.model.User;
import authorbookee.model.UserType;
import authorbookee.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserType userType = UserType.valueOf(req.getParameter("user_type"));
        HttpSession session = req.getSession();
        if (userService.getUserByEmail(email) != null) {
            session.setAttribute("msg", "Email already in use");
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        } else {
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .userType(userType)
                    .build();
            userService.add(user);
            session.setAttribute("msg", "User registered successfully");

        }
        resp.sendRedirect( "/");
    }
}

package authorbookee.servlet;

import authorbookee.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAuthor")
public class DeleteAuthorServlet extends HttpServlet {
    private AuthorService authorService = new AuthorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        authorService.deleteAuthorById(id);
        resp.sendRedirect("/authors");
    }
}

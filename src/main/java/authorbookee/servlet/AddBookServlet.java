package authorbookee.servlet;


import authorbookee.model.Author;
import authorbookee.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private AuthorService authorService = new AuthorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.getAllAuthors();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }
}

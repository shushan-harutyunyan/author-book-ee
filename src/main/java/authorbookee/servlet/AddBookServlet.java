package authorbookee.servlet;


import authorbookee.model.Author;
import authorbookee.model.Book;
import authorbookee.model.User;
import authorbookee.model.UserType;
import authorbookee.service.AuthorService;
import authorbookee.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private AuthorService authorService = new AuthorService();
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getUserType() == UserType.admin) {
            List<Author> authors = authorService.getAllAuthors();
            req.setAttribute("authors", authors);
            req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getUserType() == UserType.admin) {
            String title = req.getParameter("title");
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int authorId = Integer.parseInt(req.getParameter("authorId"));

            Book book = Book.builder()
                    .title(title)
                    .price(price)
                    .qty(quantity)
                    .author(authorService.getAuthorById(authorId))
                    .createdAt(new Date())
                    .build();


        }
    }
}

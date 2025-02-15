package authorbookee.servlet;

import authorbookee.model.Book;
import authorbookee.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> allBooks = bookService.getAllBooks();
        req.setAttribute("books", allBooks);
        req.getRequestDispatcher("/WEB-INF/books.jsp").forward(req, resp);
    }
}

package authorbookee.servlet;

import authorbookee.model.Author;
import authorbookee.model.Gender;
import authorbookee.service.AuthorService;
import authorbookee.util.DateUtil;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editAuthor")
public class EditAuthorServlet extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Author author = authorService.getAuthorById(authorId);
        req.setAttribute("author", author);
        req.getRequestDispatcher("/WEB-INF/editAuthor.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        Author author = Author.builder()
                .id(authorId)
                .name(name)
                .surname(surname)
                .phone(phone)
                .dateOfBirth(DateUtil.fromWebStringToDate(dob))
                .gender(Gender.valueOf(gender))
                .build();
        authorService.updateAuthor(author);
        resp.sendRedirect("/authors");

    }
}


package web;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Account;
import domain.model.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DbServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
            HttpSession session = request.getSession();

            Account account = (Account) session.getAttribute("account");
            Profile profile = (Profile) session.getAttribute("profile");

            catalog.users().add(account);
            catalog.save();
            catalog.profiles().add(profile);
            catalog.saveAndClose();

            session.removeAttribute("account");
            session.removeAttribute("profile");

            response.sendRedirect("welcomeScreen.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//int personId = catalog.users().getLastId();
//account.setId(personId);
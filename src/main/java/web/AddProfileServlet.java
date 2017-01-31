package web;

import domain.model.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addProfileServlet")
public class AddProfileServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String age =req.getParameter("age");



        Profile profile = new Profile();
        profile.setFirstName(req.getParameter("firstName"));
        profile.setLastName(req.getParameter("lastName"));
        profile.setCity(req.getParameter("city"));
        profile.setCountry(req.getParameter("country"));
        profile.setAge(Integer.parseInt(age));

        HttpSession session = req.getSession();
        session.setAttribute(SessionKey.profile, profile);
        resp.sendRedirect("final.jsp");
    }
}
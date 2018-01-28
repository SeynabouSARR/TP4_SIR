package servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoPerson;
import domain.Person;

@WebServlet(name="listePersonne",
urlPatterns={"/list"})
public class ShowPersonList extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        DaoPerson dao = new DaoPerson();
        List<Person> personnes = dao.getPersons();

        String texte = "";

        for(Person p : personnes)
        {
            texte += p.getNom()+" "+p.getPrenom()+" "+p.getAge()+"<br/>";
        }

        req.setAttribute("texte", texte);

        RequestDispatcher caller = req.getRequestDispatcher("/listePersonne.jsp");
        caller.forward(req, resp);
    }

}
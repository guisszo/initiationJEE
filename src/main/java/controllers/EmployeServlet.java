package controllers;

import modeles.Employe;
import modeles.Service;
import modeles.Users;
import services.Employedao;
import services.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "employe",urlPatterns = "/employe")

public class EmployeServlet extends HttpServlet {
    Employedao employedao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        employedao= new Employedao();
        switch (action){
            case "add":

                req.setAttribute("services",employedao.findServices());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");



        switch (action){
            case "add":
                String matricule = req.getParameter("matricule");
                String nom = req.getParameter("nom");
                String tel = req.getParameter("tel");
                DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate datenais = LocalDate.parse(req.getParameter("datenais"),df);
                int salaire = Integer.parseInt(req.getParameter("salaire"));
                int Ids = Integer.parseInt(req.getParameter("idservice"));

                //on met dans service l'id du service selectionné au niveau du menu select
                Service s =  new Service();
                s.setId(Ids);

                //instantiation de la classe employé
                Employe e = new Employe();
                e.setIdService(s);
                e.setMatricule(matricule);
                e.setNom(nom);
                e.setTel(tel);
                e.setDatenais(datenais);
                e.setSalaire(salaire);
                employedao.addEmploye(e);
                req.setAttribute("services",employedao.findServices());

                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);

                break;
        }

    }
}

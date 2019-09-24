package controllers;

import modeles.Users;
import services.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "user",urlPatterns = "/user")

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login"); // on récupère les paramères du formularies
        String pwd = req.getParameter("password");
        Userdao userdao  = new Userdao();
        Users u = userdao.logon(log,pwd);//on lui passe les paramètres récupérés sur le formulaire
        if(u != null){
            HttpSession session = req.getSession(true);
            session.setAttribute( "connectedUser",u);
            if (u.getProfile().equalsIgnoreCase("user")){
                //on le redirige dans la page suivante
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
            }else {
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
            }

        }else {
            // on le redirige sur la même page avec un message d'erreur au cas ou cela ne marche pas
            req.setAttribute("error","Login ou password incorrect");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);

        }

    }
}

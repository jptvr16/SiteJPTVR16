/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Role;
import entity.Student;
import entity.User;
import entity.UserRoles;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import role.RoleLogic;
import session.UserFacade;
import session.RoleFacade;
import session.StudentFacade;
import session.UserRolesFacade;
import utils.PagePathLoader;


/**
 *
 * @author pupil
 */
@WebServlet(name = "SecureController", urlPatterns = {
      "/showLogin",
    "/login",
     "/logout",
    "/showRegistration",
    "/registration",
})
public class SecureController extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private StudentFacade studentFacade;
    @EJB
    
    private UserRolesFacade userRolesFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RoleLogic rl = new RoleLogic();
       HttpSession session = request.getSession(false);
        User regUser = null;
        if(session != null){
            regUser=(User) session.getAttribute("regUser");
        }
        String path = request.getServletPath();
        
        if (path != null) {
            switch (path) {
                case "/logout":
                    session = request.getSession(false);
                if(session != null){
                    session.invalidate();
                    request.setAttribute("info", "Вы вышли!");
                    request.getRequestDispatcher(PagePathLoader.getPagePath("index")).forward(request, response);
                }
                    request.setAttribute("info", "Вы вышли");
                   
                case "/showLogin":
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showLogin")).forward(request, response);
                    
                    break;
                case "/login":
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    regUser = userFacade.findByLogin(login);
                    if (regUser == null) {
                        request.setAttribute("info", "Нет такого пользователя");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("index")).forward(request, response);
                    }
                    String encriptPass = setEncriptPass(password, "");

                    if (encriptPass != null && !encriptPass.equals(regUser.getPassword())) {
                        request.setAttribute("info", "Нет такого пользователя");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("index")).forward(request, response);
                    }
                   session = request.getSession(true);
                    session.setAttribute("regUser", regUser);
                    request.setAttribute("info", "Привет " + regUser.getStudent().getName() + ", вы вошли как " + rl.getRole(regUser).getName());
                    request.setAttribute("role", rl.getRole(regUser));
                    request.getRequestDispatcher("/SessionContextServlet").forward(request, response);
                    
                    break;
                case "/showRegistration":
                    
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showRegistration")).forward(request, response);
                    break;
                case "/registration":
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String email = request.getParameter("email");
                    login = request.getParameter("login");
                    String password1 = request.getParameter("password1");
                    String password2 = request.getParameter("password2");
                    if (!password1.equals(password2)) {
                        request.setAttribute("info", "Нет такого пользователя");
                        
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showRegistration")).forward(request, response);
                    }
                    encriptPass = setEncriptPass(password1, "");
                    Student student = new Student(email, name, surname);
                    studentFacade.create(student);
                    User user = new User(login, encriptPass, true, student);
                     userFacade.create(user);
                    UserRoles ur = new UserRoles();
                    ur.setUser(user);
                    Role role = roleFacade.findByName("USER");
                    ur.setRole(role);
                    userRolesFacade.create(ur);
                    request.getRequestDispatcher(PagePathLoader.getPagePath("index")).forward(request, response);
                    break;
                 
default:
                       request.setAttribute("info", "Нет тако");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("error")).forward(request, response);
            }
        }
    }
public String setEncriptPass(String password, String salts) {
        password = salts + password;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("SHA-256");
            m.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Controller.class.getName())
                    .log(Level.SEVERE,
                            "Не поддерживается алгоритм хеширования", ex);
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

    
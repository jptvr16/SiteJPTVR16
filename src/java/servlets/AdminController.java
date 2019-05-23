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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import role.Roles;
import session.WordFacade;
import session.StudentFacade;
import session.RoleFacade;
import session.UserFacade;
import session.UserRolesFacade;
import utils.Encription;
import utils.PagePathLoader;

/**
 *
 * @author pupil
 */
@WebServlet(name = "AdminController", loadOnStartup = 1, urlPatterns = {
    "/showChangeRole",
    "/changeRole",
    "/changeUserPassword",
    "/showChangeUserPassword",})

public class AdminController extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private WordFacade buyerFacade;
    @EJB
    private StudentFacade studentFacade;
    @EJB
    private UserRolesFacade userRolesFacade;

    @Override
    public void init() throws ServletException {
        List<User> listUsers = userFacade.findAll();
        if (!listUsers.isEmpty()) {
            return;
        }

        Student student = new Student("words@mail.ru", "Admin", "Admin");
        //Buyer seller = new Buyer("test@mail.ru", "Seller", "Seller",500,null);
        //buyerFacade.create(seller);
        studentFacade.create(student);
        Encription encription = new Encription();

        String password = encription.getEncriptionPass("admin");
        User user = new User("admin", password, true, student);
        //User moder = new User("moder", password, true, seller);

        userFacade.create(user);
        //userFacade.create(moder);
        Role role = new Role("ADMINISTRATOR");

        roleFacade.create(role);
        UserRoles ur = new UserRoles();
        ur.setRole(role);
        ur.setUser(user);
        userRolesFacade.create(ur);

        role.setName("USER");

        roleFacade.create(role);
        ur.setRole(role);
        ur.setUser(user);
        userRolesFacade.create(ur);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = null;
        RoleLogic rl = new RoleLogic();
        String path = request.getServletPath();
        session = request.getSession(false);
                    User regUser = (User) session.getAttribute("regUser");
                     RoleLogic roleLogic = new RoleLogic();
                    Boolean isRole = roleLogic.isRole(Roles.ADMINISTRATOR.toString(), regUser);
                     
                    if (session == null) {
                        request.setAttribute("info", "Вы должны войти");
                         request.getRequestDispatcher(PagePathLoader.getPagePath("showLogin")).forward(request, response);
                        
                    }
                    regUser = (User) session.getAttribute("regUser");
                    if (regUser == null) {
                        request.setAttribute("info", "Вы должны войти");
                         request.getRequestDispatcher(PagePathLoader.getPagePath("showLogin")).forward(request, response);
                        
                    }
                    roleLogic = new RoleLogic();
                    isRole = roleLogic.isRole(Roles.ADMINISTRATOR.toString(), regUser);
                    if (!isRole) {
                        request.setAttribute("info", "У вас должна быть роль ADMINISTRATOR!");
                        request.getRequestDispatcher("/showLogin").forward(request, response);;
                    }
        if (path != null) {
            switch (path) {
                case "/showChangeRole":                                        
                    List<Role> listRoles = roleFacade.findAll();
                    List<User> listUsers = userFacade.findAll();
                    Role role;
                    Map<User, Role> mapUsers = new HashMap<>();
                    for (User user : listUsers) {
                        role = rl.getRole(user);
                        mapUsers.put(user, role);
                    }
                    request.setAttribute("listRoles", listRoles);
                    request.setAttribute("mapUsers", mapUsers);
                    
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showChangeRole")).forward(request, response);
                    break;
                case "/changeRole":
                    String roleId = request.getParameter("roleId");
                    String userId = request.getParameter("userId");
                    role = roleFacade.find(Long.parseLong(roleId));
                    User user = userFacade.find(Long.parseLong(userId));
                    if (!"admin".equals(user.getLogin())) {
                        rl.setRole(role, user);
                    }
                     request.getRequestDispatcher(PagePathLoader.getPagePath("showChangeRole")).forward(request, response);
                    break;
                case "/showChangeUserPassword":
                   

                    String username = regUser.getStudent().getName() + " " + regUser.getStudent().getSurname();
                    request.setAttribute("username", username);
                    String login = regUser.getLogin();
                    request.setAttribute("login", login);

                    List<User> listUserss = userFacade.findAll();
                    request.setAttribute("listUsers", listUserss);
 request.getRequestDispatcher(PagePathLoader.getPagePath("changeUserPassword")).forward(request, response);
                    
                    break;

                case "/changeUserPassword":
                    session = request.getSession();

                    regUser = (User) session.getAttribute("regUser");
                    String userID = request.getParameter("userId");
                    user = userFacade.find(new Long(userID));
                    Encription encription = new Encription();

                    String newPassword1 = request.getParameter("newPassword1");

                    user.setPassword(encription.getEncriptionPass(newPassword1));

                    if (!"admin".equals(user.getLogin())) {
                        userFacade.edit(user);
                        request.setAttribute("info", "Вы успешно изменили пароль");
                    } else {
                        request.setAttribute("info", "Нельзя изменить пароль главному администратору!");
                    }

                    request.getRequestDispatcher(PagePathLoader.getPagePath("index")).forward(request, response);
                    break;
                    default:
                       request.setAttribute("info", "Нет тако");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("error")).forward(request, response);
            }

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

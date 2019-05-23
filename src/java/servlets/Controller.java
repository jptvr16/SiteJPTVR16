/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.User;
import entity.UserWords;
import entity.Word;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeMath.random;
import role.RoleLogic;
import role.Roles;
import session.RoleFacade;
import session.StudentFacade;
import session.UserFacade;
import session.UserRolesFacade;
import session.UserWordsFacade;
import session.WordFacade;
import utils.Encription;
import utils.PagePathLoader;

/**
 *
 * @author pupil
 */
@WebServlet(name = "Controller", urlPatterns = {
    "/showNewWord",
    "/addNewWord",
    "/showListWords",
    "/showChangePassword",
    "/changePassword",
    "/showEditWord",
    "/editWord",
    "/showDeleteWord",
    "/deleteWord",
    "/showLearnedWords",
    "/hideWord",
    "/returnWord",
    "/showLearning",
    "/manageWords",
    "/showCheckingWords",
    "/checkWord"

})
public class Controller extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private StudentFacade studentFacade;
    @EJB
    private UserRolesFacade userRolesFacade;
    @EJB
    private WordFacade wordFacade;
    @EJB
    private UserWordsFacade userWordsFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        RoleLogic roleLogic = new RoleLogic();
        HttpSession session = request.getSession(false);
        User regUser = (User) session.getAttribute("regUser");
        if (session == null) {
            request.setAttribute("info", "Войдите");
            request.getRequestDispatcher("/showLogin");

        }

        if (regUser == null) {

            request.setAttribute("info", "Войдите");
            request.getRequestDispatcher("/showLogin");

        }

        Boolean isRole = roleLogic.isRole(Roles.USER.toString(), regUser);
        if (!isRole) {
            request.setAttribute("info", "У вас должна быть роль USER");
            request.getRequestDispatcher("/showLogin").forward(request, response);;
        }
        Calendar c = new GregorianCalendar();
        Encription encription = new Encription();
        String path = request.getServletPath();
        if (path != null) {
            switch (path) {

                case "/showNewWord":

                    request.getRequestDispatcher(PagePathLoader.getPagePath("showNewWord")).forward(request, response);

                    break;

                case "/addNewWord":
                    String wordName = request.getParameter("word");
                    String translation = request.getParameter("translation");
                    String phrase = request.getParameter("phrase");
                    Word word = new Word(wordName, translation, phrase);
                    wordFacade.create(word);
                    UserWords userWords = new UserWords(regUser, word);
                    userWordsFacade.create(userWords);

                    request.setAttribute("info", " Слово: \"" + word.getWord() + "\" добавлено ");
                    request.getRequestDispatcher("/showListWords").forward(request, response);
                    break;

                case "/showListWords":
<<<<<<< HEAD
                    List<Word> listWords = wordFacade.findNoHidden();
                    if (!listWords.isEmpty()) {
                        request.setAttribute("listWords", listWords);
=======
                    List<UserWords> listUserWords = userWordsFacade.findNoHidden(regUser);
                    if (!listUserWords.isEmpty()) {
                        request.setAttribute("listUserWords", listUserWords);
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showListWords")).forward(request, response);
                    } else {
                        request.setAttribute("info", "Список слов пуст");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showListWords")).forward(request, response);
                    }

                    break;
                case "/showLearning":
<<<<<<< HEAD
                    List<Word> listWordsAll = wordFacade.findNoHidden();
                    listWords = null;
                    if (!listWordsAll.isEmpty()) {
                        listWords = (List<Word>) session.getAttribute("listWords");
                        listWords = wordFacade.findNoHidden();
                        Random rand = new Random();
                        word = listWords.get(rand.nextInt(listWords.size())); // Math.random(listWordsss.size());
                        request.setAttribute("word", word);
                        listWords.remove(word);

                    }
                    if (listWordsAll.isEmpty()) {
=======
                    List<UserWords> listUserWordsAll = userWordsFacade.findNoHidden(regUser);
                     listUserWords = null;
//                    List<Word> listWordsAll = wordFacade.findNoHidden();
//                    List<Word> listWords = null;
                    if (!listUserWordsAll.isEmpty()) {
                        listUserWords = (List<UserWords>) session.getAttribute("listUserWords");
                        listUserWords = userWordsFacade.findNoHidden(regUser);
                        Random rand = new Random();
                       UserWords userWord = listUserWords.get(rand.nextInt(listUserWords.size())); // Math.random(listWordsss.size());
                        request.setAttribute("UserWords", userWord);
                        listUserWords.remove(userWord);

                    }
                    if (listUserWordsAll.isEmpty()) {
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                        request.setAttribute("info", "Список слов пуст");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showLearning")).forward(request, response);
                    }

<<<<<<< HEAD
                    session.setAttribute("listWords", listWords);
=======
                    session.setAttribute("listWords", listUserWords);
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showLearning")).forward(request, response);

                    break;
                case "/showLearnedWords":
<<<<<<< HEAD
                    listWords = wordFacade.findHidden();
                    request.setAttribute("listWords", listWords);
=======
                    listUserWords = userWordsFacade.findHidden(regUser);
                    request.setAttribute("listUserWords", listUserWords);
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showLearnedWords")).forward(request, response);
                    break;
                case "/hideWord":

                    String wordId = request.getParameter("id");
                    Word getWord = wordFacade.find(new Long(wordId));
                    getWord.setHidden(true);
                    wordFacade.edit(getWord);
                    request.setAttribute("info", "Слово \"" + getWord.getWord() + "\" добавлено в выученные!");
                    request.getRequestDispatcher("/showListWords").forward(request, response);
                    break;
                case "/returnWord":

                    wordId = request.getParameter("id");
                    getWord = wordFacade.find(new Long(wordId));
                    getWord.setHidden(false);
                    wordFacade.edit(getWord);
                    request.setAttribute("info", "Слово \"" + getWord.getWord() + "\" добавлено обратно в словарь!");
                    request.getRequestDispatcher("/showListWords").forward(request, response);
                    break;
                case "/showChangePassword":

                    String username = regUser.getStudent().getName() + " " + regUser.getStudent().getSurname();
                    request.setAttribute("username", username);
                    String login = regUser.getLogin();
                    request.setAttribute("login", login);
                    request.getRequestDispatcher(PagePathLoader.getPagePath("changePassword")).forward(request, response);

                    break;
                case "/changePassword":

                    String oldPassword = request.getParameter("oldPassword");

                    String encriptOldPassword = encription.getEncriptionPass(oldPassword);
                    if (!encriptOldPassword.equals(regUser.getPassword())) {
                        request.setAttribute("info", "Вы должны войти");
                        request.getRequestDispatcher("/showLogin").forward(request, response);
                        break;
                    }
                    String newPassword1 = request.getParameter("newPassword1");
                    String newPassword2 = request.getParameter("newPassword2");
                    if (newPassword1.equals(newPassword2)) {
                        regUser.setPassword(encription.getEncriptionPass(newPassword1));
                        userFacade.edit(regUser);
                    }
                    request.setAttribute("info", "Вы успешно изменили пароль");
                    request.getRequestDispatcher("/logout");
                    request.getRequestDispatcher("/showLogin").forward(request, response);
                    break;
                case "/showEditWord":
                    wordId = request.getParameter("id");
                    getWord = wordFacade.find(new Long(wordId));
                    request.setAttribute("word", getWord);

                    request.getRequestDispatcher(PagePathLoader.getPagePath("showEditWord")).forward(request, response);
                    break;
                case "/editWord":

                    String wordText = request.getParameter("word");
                    String wordTranslation = request.getParameter("translation");
                    String wordPhrase = request.getParameter("phrase");
                    wordId = request.getParameter("id");
                    getWord = wordFacade.find(new Long(wordId));
                    getWord.setWord(wordText);
                    getWord.setTranslation(wordTranslation);
                    getWord.setPhrase(wordPhrase);
                    wordFacade.edit(getWord);
                    request.setAttribute("info", "Слово \"" + getWord.getWord() + "\" изменено!");
                    request.getRequestDispatcher("/showListWords").forward(request, response);
                    break;
                case "/deleteWord":

                    wordId = request.getParameter("id");
                    try {
<<<<<<< HEAD
                        getWord = wordFacade.find(new Long(wordId));

                        wordFacade.remove(getWord);
=======
                        word = wordFacade.find(new Long(wordId));
                        word.setDeleted(true);
                        wordFacade.edit(word);
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                    } catch (Exception e) {
                        request.setAttribute("info", "Слово не удалось удалить");
                        request.getRequestDispatcher("/showListWords").forward(request, response);
                        break;
                    }

<<<<<<< HEAD
                    request.setAttribute("info", "Слово \"" + getWord.getWord() + "\" удалено!");
=======
                    request.setAttribute("info", "Слово \"" + word.getWord() + "\" удалено!");
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                    request.getRequestDispatcher("/showListWords").forward(request, response);

                    break;
                case "/manageWords":
                    word = null;
                    String[] words = request.getParameterValues("words");
                    String deleteWords = request.getParameter("deleteWords");
                    String hideWords = request.getParameter("hideWords");
                    String returnWords = request.getParameter("returnWords");
                    try {
                        if (deleteWords != null) {
                            for (int i = 0; i < words.length; i++) {
                                word = wordFacade.find(new Long(words[i]));
<<<<<<< HEAD
                                wordFacade.remove(word);
=======
                                word.setDeleted(true);
                                wordFacade.edit(word);
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                            }
                            request.setAttribute("info", "Слова удалены.");
                            request.getRequestDispatcher("/showListWords").forward(request, response);
                        }

                    } catch (Exception e) {
                        request.setAttribute("info", "Слова не удалось удалить.");
                        request.getRequestDispatcher("/showListWords").forward(request, response);
                    }
                    try {
                        if (hideWords != null) {
                            for (int i = 0; i < words.length; i++) {
                                word = wordFacade.find(new Long(words[i]));
<<<<<<< HEAD
                                wordFacade.remove(word);
=======
                                
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                                word.setHidden(true);
                                wordFacade.edit(word);
                            }
                            request.setAttribute("info", "Слова добавлены в выученные.");
                            request.getRequestDispatcher("/showListWords").forward(request, response);
                        }

                    } catch (Exception e) {
                        request.setAttribute("info", "Слова не удалось добавить.");
                        request.getRequestDispatcher("/showListWords").forward(request, response);
                    }

                    try {
                        if (returnWords != null) {
                            for (int i = 0; i < words.length; i++) {
                                word = wordFacade.find(new Long(words[i]));
<<<<<<< HEAD
                                wordFacade.remove(word);
=======
                                
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520
                                word.setHidden(false);
                                wordFacade.edit(word);
                            }
                            request.setAttribute("info", "Слова добавлены обратно в словарь.");
                            request.getRequestDispatcher("/showListWords").forward(request, response);
                        }

                    } catch (Exception e) {
                        request.setAttribute("info", "Слова не удалось добавить обратно в словарь.");
                        request.getRequestDispatcher("/showListWords").forward(request, response);
                    }
<<<<<<< HEAD
                case "/showCheckingWords":
                    List<Word> CheckListWordsAll = wordFacade.findNoHidden();
                    listWords = null;
                    if (!CheckListWordsAll.isEmpty()) {
                        listWords = (List<Word>) session.getAttribute("listWords");
                        listWords = wordFacade.findNoHidden();
                        Random rand = new Random();
                        word = listWords.get(rand.nextInt(listWords.size())); // Math.random(listWordsss.size());
                        request.setAttribute("word", word);
                        listWords.remove(word);
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showCheckingWords")).forward(request, response);

                    }
                    if (CheckListWordsAll.isEmpty()) {
                        request.setAttribute("info", "Список слов пуст");
                        request.getRequestDispatcher(PagePathLoader.getPagePath("showCheckingWords")).forward(request, response);
                    }
                    break;
                case "/checkWord":
                    wordId = request.getParameter("wordId");
                    word = wordFacade.find(new Long(wordId));
                    String answer = request.getParameter("answer");
                    //String wordCheckTranslation = request.getParameter("check");

                    if (answer.equals(word.getTranslation())) {
                        request.setAttribute("info", "Правильное Слово");
                    } else {
                        request.setAttribute("info", "Слово неправильно. Ответ: " + word.getTranslation());
                        
                    }
                    request.setAttribute("word", word);
                    
                    request.getRequestDispatcher(PagePathLoader.getPagePath("showCheckingWords")).forward(request, response);

                        
                      
=======

                    break;
>>>>>>> 394ac4c705cce78158338c2efbe0704f99469520

//                default:
//                    request.setAttribute("info", "Нет тако");
//                    request.getRequestDispatcher(PagePathLoader.getPagePath("error")).forward(request, response);
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

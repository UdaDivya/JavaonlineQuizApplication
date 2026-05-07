package com.quizapp.servlet;

import com.quizapp.dao.QuizDAO;
import com.quizapp.model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            QuizDAO dao = new QuizDAO();
            User user = dao.loginUser(username, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect(
                    req.getContextPath() + "/quiz");
            } else {
                resp.sendRedirect(
                    req.getContextPath() + 
                    "/login.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(
                req.getContextPath() + 
                "/login.jsp?error=2");
        }
    }
}